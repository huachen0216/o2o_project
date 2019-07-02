package com.fathua.o2o.dao;

import com.fathua.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商铺种类
 *
 * @author jidi
 * @date 2019/6/25 23:02
 */
public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);
}
