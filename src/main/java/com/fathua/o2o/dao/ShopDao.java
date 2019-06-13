package com.fathua.o2o.dao;

import com.fathua.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    public int insertShop(Shop shop);

    /**
     * 更新店铺
     *
     * @param shop
     * @return
     */
    public int updateShop(Shop shop);

}
