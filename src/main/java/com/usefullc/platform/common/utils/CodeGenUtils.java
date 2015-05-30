/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类CodeGenUtils.java的实现描述：编码生成器
 * 
 * @author shengshang.tang 2013年12月2日 上午10:53:32
 */
public class CodeGenUtils {

    private final static Logger                      log          = LoggerFactory.getLogger(CodeGenUtils.class);

    // code 缓存容器
    private static Map<String, Map<String, Integer>> codeCacheMap = new HashMap<String, Map<String, Integer>>();

    /**
     * 生成code 格式：前缀+yy+mm+dd+HH+MM+ss+数字 如：M131202104951212
     * 
     * @param prefix 前缀
     * @return
     */
    public static String genCode(String prefix) {
        String d = DateUtils.getDate(new Date(), "yymmddHHMMss");
        Map<String, Integer> codeMap = codeCacheMap.get(prefix);
        Integer value = 1;
        if (codeMap == null) {
            codeMap = new HashMap<String, Integer>();
            codeMap.put(d, 1);
            codeCacheMap.put(prefix, codeMap);
        } else {
            value = codeMap.get(d);
            if (value == null) {
                codeMap.clear(); // 清空历史
                value = 1;
            } else {
                value += 1;
            }
            codeMap.put(d, value);
        }
        String code = prefix + d + value;
        log.info("code=" + code);
        return code;
    }

    public static void main(String[] args) {
        String code = genCode("M");
        String code2 = genCode("M");
        String code3 = genCode("M");
        String code4 = genCode("M");
        String code5 = genCode("M");
        System.out.println(code);
        System.out.println(code2);
        System.out.println(code3);
        System.out.println(code4);
        System.out.println(code5);
    }
}
