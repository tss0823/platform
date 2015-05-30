/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.cache.ehcache;

import java.net.URL;
import java.util.Date;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ResourceUtils;

import com.usefullc.platform.common.cache.DateUnitEnum;
import com.usefullc.platform.common.cache.ICacheService;
import com.usefullc.platform.common.utils.StrUtils;

/**
 * 类EhcacheServiceImpl.java的实现描述：ehcache 实现
 * 
 * @author shengshang.tang 2014年5月15日 下午2:52:26
 */
public class EhCacheServiceImpl implements ICacheService, InitializingBean {

    /**
     * 应用名称
     */
    private String system;

    /**
     * 配置文件
     */
    private String configLocation;

    private Cache  cache;

    /*
     * (non-Javadoc)
     * @see ICacheService#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String key, Object value) {
        String newKey = StrUtils.join(system, key);
        Element element = new Element(newKey, value);
        cache.put(element);

    }

    /*
     * (non-Javadoc)
     * @see ICacheService#set(java.lang.String, java.lang.Object,
     * DateUnitEnum, java.lang.Integer)
     */
    @Override
    public void set(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        String newKey = StrUtils.join(system, key);
        Element element = createExpireE(newKey, value, dateUnit, expireAmount);
        cache.put(element);
    }

    /*
     * (non-Javadoc)
     * @see ICacheService#get(java.lang.String)
     */
    @Override
    public Object get(String key) {
        String newKey = StrUtils.join(system, key);
        Element element = cache.get(newKey);
        if (element != null) {
            return element.getObjectValue();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see ICacheService#setGlobal(java.lang.String, java.lang.Object)
     */
    @Override
    public void setGlobal(String key, Object value) {
        Element element = new Element(key, value);
        cache.put(element);
    }

    /*
     * (non-Javadoc)
     * @see ICacheService#setGlobal(java.lang.String, java.lang.Object,
     * DateUnitEnum, java.lang.Integer)
     */
    @Override
    public void setGlobal(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        Element element = createExpireE(key, value, dateUnit, expireAmount);
        cache.put(element);

    }

    /*
     * (non-Javadoc)
     * @see ICacheService#getGlobal(java.lang.String)
     */
    @Override
    public Object getGlobal(String key) {
        Element element = cache.get(key);
        if (element != null) {
            return element.getObjectValue();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see ICacheService#remove(java.lang.String)
     */
    @Override
    public void remove(String key) {
        String newKey = StrUtils.join(system, key);
        cache.remove(newKey);

    }

    /*
     * (non-Javadoc)
     * @see ICacheService#removeGlobal(java.lang.String)
     */
    @Override
    public void removeGlobal(String key) {
        cache.remove(key);

    }

    /**
     * 创建一个带失效日期的元素
     * 
     * @param key
     * @param value
     * @param dateUnit
     * @param expireAmount
     * @return
     */
    private Element createExpireE(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        Element element = new Element(key, value);
        Date startTime = com.usefullc.platform.common.utils.DateUtils.getNow();
        Date endTime = DateUtils.add(startTime, dateUnit.getNum(), expireAmount);
        Long milliseconds = com.usefullc.platform.common.utils.DateUtils.getCompareAmountMilliseconds(startTime, endTime);
        int seconds = Long.valueOf(milliseconds / 1000).intValue();
        element.setTimeToIdle(seconds);
        element.setTimeToLive(seconds);
        return element;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        URL url = ResourceUtils.getURL(configLocation);
        CacheManager manager = new CacheManager(url);
        cache = manager.getCache("userCache");
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

}
