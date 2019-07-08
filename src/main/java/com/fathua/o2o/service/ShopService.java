package com.fathua.o2o.service;

import com.fathua.o2o.dto.ShopExecution;
import com.fathua.o2o.entity.Shop;
import com.fathua.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {

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
