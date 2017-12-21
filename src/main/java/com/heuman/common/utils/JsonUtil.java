package com.heuman.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by heuman on 2017/10/24.
 */
public class JsonUtil {

    public static String toJson(Object o) {
        return JSON.toJSONString(o);
    }

    public static <T> T fromJson(String text, Class<T> tClass) {
        return JSON.parseObject(text, tClass);
    }
}
