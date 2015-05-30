/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import java.io.File;

/**
 * 类StrUtils.java的实现描述：字符串处理类
 * 
 * @author shengshang.tang 2013年12月5日 上午11:26:06
 */
public class StrUtils {

    public enum StrSeparator {
        STR_EMPTY(""), COMMA(","), UNDERLINE("_"), COLON(":"), SEPARATOR(File.separator);

        private String separator;

        private StrSeparator(String separator){
            this.separator = separator;
        }

        /**
         * @return the separator
         */
        public String getSeparator() {
            return separator;
        }

    }

    /**
     * 字符串拼接
     * 
     * @param separator 连接字符
     * @param objs 要拼接的字符对象
     * @return
     */
    public static String join(StrSeparator separator, Object... objs) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objs) {
            sb.append(separator.getSeparator());
            sb.append(obj);
        }
        String result = sb.toString();
        if (!separator.getSeparator().equals(StrSeparator.STR_EMPTY.getSeparator())) {
            result = sb.substring(1);
        }
        return result;
    }

    /**
     * 字符串拼接，默认用下划线拼接
     * 
     * @param strs 要拼接的字符
     * @return
     */
    public static String join(Object... objs) {
        return join(StrSeparator.UNDERLINE, objs);
    }

    /**
     * 用空字符串拼接
     * 
     * @param strs 要拼接的字符
     * @return
     */
    public static String joinEmpty(Object... objs) {
        return join(StrSeparator.STR_EMPTY, objs);
    }
}
