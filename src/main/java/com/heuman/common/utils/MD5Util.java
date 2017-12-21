package com.heuman.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by heuman on 2017/8/16.
 */
public class MD5Util {

    private static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String encryptByMD5(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        byte[] bytes;
        try {
            bytes = MessageDigest.getInstance("MD5").digest(text.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
        // 把密文转换成十六进制的字符串形式
        char[] chars = new char[bytes.length * 2];
        int k = 0;
        for (byte b : bytes) {
            chars[k++] = hexDigits[b >>> 4 & 0xf];
            chars[k++] = hexDigits[b & 0xf];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(encryptByMD5("123qwe"));//46F94C8DE14FB36680850768FF1B7F2A
    }

}
