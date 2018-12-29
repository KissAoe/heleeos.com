package com.heleeos.blog.util;

/**
 *
 * Created by liyu on 2018/8/2.
 */
public class NullUtil {

    public static <T> T getNotNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static boolean checkNull(Object...objects) {
        for(Object object : objects) {
            if(object == null) {
                return true;
            }
        }
        return false;
    }
}
