package com.fathua.o2o.service;

import com.fathua.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @author jidi
 * @date 2019/6/25 23:51
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
