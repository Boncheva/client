package com.yitu.hotel.util;

import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/20
 */
public class PatternUtil {

    //手机格式正则
    public static final String pattern = "^(1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9]))\\d{8}$";

    /**
     * 验证字符串格式(电话号码，邮箱等格式)
     *
     * @param source
     * @return boolean
     * @author zouhao
     * @date 2020/11/20 16:05
     */
    public static boolean matches(String source) {
        return Pattern.matches(pattern, source);
    }
}
