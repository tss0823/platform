/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.cache;


/**
 * 类ICacheService.java的实现描述：缓存接口
 * 
 * @author shengshang.tang 2014年5月15日 下午2:41:39
 */
public interface ICacheService {

    public void set(String key, Object value);

    public void set(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount);

    public Object get(String key);

    /**
     * 设置全局数据
     * 
     * @param key
     * @param value
     */
    public void setGlobal(String key, Object value);

    /**
     * 设置全局数据
     * 
     * @param key
     * @param value
     * @param dateUnit
     * @param expireAmount
     */
    public void setGlobal(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount);

    /**
     * 获得全局数据
     * 
     * @param key
     * @return
     */
    public Object getGlobal(String key);

    /**
     * 移除数据
     * 
     * @param key
     */
    public void remove(String key);

    /**
     * 移除全局数据
     * 
     * @param key
     */
    public void removeGlobal(String key);
}
