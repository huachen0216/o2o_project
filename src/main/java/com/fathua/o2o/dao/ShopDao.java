package com.fathua.o2o.dao;

import com.fathua.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 通过Shop id 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

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
