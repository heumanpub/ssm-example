package com.heuman.common.utils;

/**
 * Created by heuman on 2017/12/20.
 */
public class PathUtil {

    /**
     * 把多个路径合为一个完整路径，只用于拼接本地系统路径，不要拼接http，ftp等带有//的路径
     * 例：append("/", "/a/b") -> /a/b
     *
     * @param paths 多段路径
     * @return 拼接之后的路径
     */
    public static String append(String... paths) {
        String result = "";
        for (String path : paths) {
            if (path != null) {
                result += path;
            }
        }
        result = result.replaceAll("//", "/");
        return result;
    }

}
