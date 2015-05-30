/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 类DataListObject.java的实现描述：线程多变量工具类
 * 
 * @author shengshang.tang 2014年4月16日 上午11:49:27
 */
public class ThreadLocalMultUtils {

    // 线程变量
    private static ThreadLocal<Map<String, Object>> mapThreadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * 获得/读取
     * 
     * @return
     */
    public static Map<String, Object> get() {
        Map<String, Object> map = mapThreadLocal.get();
        if (map == null) {
            map = createMap();
        }
        return map;
    }

    /**
     * 设置/存储
     * 
     * @param map
     */
    public static void set(Map<String, Object> map) {
        mapThreadLocal.set(map);
    }

    /**
     * 删除
     */
    public static void remove() {
        mapThreadLocal.set(null);
    }

    private synchronized static Map<String, Object> createMap() {
        Map<String, Object> map = mapThreadLocal.get();
        // 第二次判断，防止重复创建
        if (map == null) {
            map = new HashMap<String, Object>();
            mapThreadLocal.set(map);
        }
        return map;
    }

}
