package com.heuman.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by heuman on 2017/12/19.
 * classpath:properties/config.properties文件中的key/value
 */
public class Config {

    private static ConcurrentMap<String, String> propertyMap = new ConcurrentHashMap<>();

    static {
        Properties properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("properties/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Read classpath:properties/config.properties occur error - " + e.getMessage(), e);
        }
        for (java.util.Map.Entry entry : properties.entrySet()) {
            Object key = entry.getKey();
            if (key != null) {
                if (entry.getValue() != null) {
                    propertyMap.put(String.valueOf(key), String.valueOf(entry.getValue()));
                } else {
                    propertyMap.put(String.valueOf(key), "");
                }
            }
        }
    }

    /**
     * 系统路径
     *
     * @return
     */
    public static String getContextPath() {
        String contextPath = get("contextPath", "");
        if (!contextPath.startsWith("/")) {
            contextPath += "/";
        }
        return contextPath;
    }

    /**
     * rest servlet的拦截路径，从系统根路径开始
     *
     * @return
     */
    public static String getRestPath() {
        String path = getContextPath() + get("rest.path");
        path = path.replaceAll("//", "/");
        if (path.endsWith("/")) {
            return path.substring(0, path.length() - 1);
        }
        return path;
    }

    /**
     * pages servlet的拦截路径，从系统根路径开始
     *
     * @return
     */
    public static String getPagesPath() {
        String path = getContextPath() + get("pages.path");
        path = path.replaceAll("//", "/");
        if (path.endsWith("/")) {
            return path.substring(0, path.length() - 1);
        }
        return path;
    }

    /**
     * 是否是测试模式
     *
     * @return
     */
    public static boolean isTestMode() {
        return !"deployment".equalsIgnoreCase(get("env")) && "true".equalsIgnoreCase(get("test.mode"));
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key - the key whose associated value is to be returned
     * @return
     */
    public static String get(String key) {
        return get(key, null);
    }

    /**
     * Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
     *
     * @param key          - the key whose associated value is to be returned
     * @param defaultValue - the default mapping of the key
     * @return
     */
    public static String get(String key, String defaultValue) {
        return propertyMap.getOrDefault(key, defaultValue);
    }

}
