package com.fathua.o2o.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jidi
 * @date 2019/6/24 22:39
 */
@Controller
@RequestMapping(value = "shop", method = {RequestMethod.POST, RequestMethod.GET})
public class AdminController {

    @RequestMapping(value = "/shopoperation", method = RequestMethod.GET)
    private String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
    private String shopManage() {
        return "shop/shopmanage";
    }
}
