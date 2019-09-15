package com.fathua.o2o.service;

import com.fathua.o2o.dto.ShopExecution;
import com.fathua.o2o.entity.Shop;
import com.fathua.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

/**
 * @author jidi
 * @date 2019/6/24 22:39
 */
public interface ShopService {

    /**
     * 根据shopCondition分页获取商铺列表
     *
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
    /**
     * 更新店铺信息
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
    /**
     * 根据shopid获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 增加店铺
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);

}
