package com.fathua.o2o.service;

import com.fathua.o2o.dto.ShopExecution;
import com.fathua.o2o.entity.Shop;

import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);

}
