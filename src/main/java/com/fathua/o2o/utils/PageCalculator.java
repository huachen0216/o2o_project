package com.fathua.o2o.utils;

/**
 * @author jidi
 * @date 2019/7/24 22:14
 */
public class PageCalculator {
    /**
     *
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex -1) * pageSize : 0;
    }

}
