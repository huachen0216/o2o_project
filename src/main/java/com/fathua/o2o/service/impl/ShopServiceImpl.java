package com.fathua.o2o.service.impl;

import com.fathua.o2o.dao.ShopDao;
import com.fathua.o2o.dto.ShopExecution;
import com.fathua.o2o.entity.Shop;
import com.fathua.o2o.enums.ShopStateEnum;
import com.fathua.o2o.exceptions.ShopOperationException;
import com.fathua.o2o.service.ShopService;
import com.fathua.o2o.utils.ImageUtil;
import com.fathua.o2o.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/**
 * @author
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;


    @Override
    @Transactional(rollbackFor = ShopOperationException.class)
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 异常判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            // 赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            // 添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败！");
            } else {
                try {
                    if (shopImgInputStream != null) {
                        // 存储图片
                        //更新店铺的图片地址
                        addShopImg(shop, shopImgInputStream, fileName);
                        effectedNum = shopDao.updateShop(shop);
                        if (effectedNum <= 0) {
                            throw new ShopOperationException("更新图片地址失败！");
                        }
                    }
                } catch (Exception e) {
                    throw new ShopOperationException("add ShopImg error: " + e.getMessage());
                }

            }
        } catch (Exception e) {
            throw new ShopOperationException("add Shop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 获取Shop图片目录的相对值路径
        String destPath = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, destPath);
        shop.setShopImg(shopImgAddr);

    }
}
