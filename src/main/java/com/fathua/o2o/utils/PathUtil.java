package com.fathua.o2o.utils;

/**
 * @Author JIDI
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    /**
     * 返回项目图片的根路径
     *
     * @return
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/temp/image/";
        } else {
            basePath = "/home/jidi/image";
        }

        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    /**
     * 返回项目图片的子路径
     *
     * @param shopId
     * @return
     */
    public static String getShopImgPath(long shopId) {
        StringBuilder shopImagePathBuilder = new StringBuilder();
        shopImagePathBuilder.append("/upload/images/item/shop/");
        shopImagePathBuilder.append(shopId);
        shopImagePathBuilder.append("/");
        String shopImagePath = shopImagePathBuilder.toString().replace("/",
                seperator);
        return shopImagePath;
    }

}
