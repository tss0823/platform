/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.cache.memcached;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.InitializingBean;

import com.usefullc.platform.common.cache.DateUnitEnum;
import com.usefullc.platform.common.cache.ICacheService;
import com.usefullc.platform.common.utils.StrUtils;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * 类MemcachedService.java的实现描述：memcached 服务类
 * 
 * @author shengshang.tang 2013年12月3日 下午1:32:08
 */
public class MemCacheServiceImpl implements ICacheService, InitializingBean {

    private String          system;

    private String          host;

    private String          port;

    private MemCachedClient mcc;

    @Override
    public void set(String key, Object value) {
        String newKey = StrUtils.join(system, key);
        mcc.set(newKey, value);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void set(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        Date d = new Date();
        d = DateUtils.add(d, dateUnit.getNum(), expireAmount);
        String newKey = StrUtils.join(system, key);
        mcc.set(newKey, value, d);
    }

    /**
     * 设置全局数据
     * 
     * @param key
     * @param value
     */
    @Override
    public void setGlobal(String key, Object value) {
        mcc.set(key, value);
    }

    /**
     * 设置全局数据
     * 
     * @param key
     * @param value
     * @param dateUnit
     * @param expireAmount
     */
    @Override
    @SuppressWarnings("deprecation")
    public void setGlobal(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        Date d = new Date();
        d = DateUtils.add(d, dateUnit.getNum(), expireAmount);
        mcc.set(key, value, d);
    }

    @Override
    public Object get(String key) {
        String newKey = StrUtils.join(system, key);
        return mcc.get(newKey);
    }

    /**
     * 获得全局数据
     * 
     * @param key
     * @return
     */
    @Override
    public Object getGlobal(String key) {
        return mcc.get(key);
    }

    /**
     * 移除数据
     * 
     * @param key
     */
    @Override
    public void remove(String key) {
        String newKey = StrUtils.join(system, key);
        this.mcc.delete(newKey);
    }

    /**
     * 移除全局数据
     * 
     * @param key
     */
    @Override
    public void removeGlobal(String key) {
        this.mcc.delete(key);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        mcc = new MemCachedClient();

        // server list and weights
        String[] servers = { host + ":" + port };

        // Integer[] weights = { 3, 3, 2 };

        // grab an instance of our connection pool
        SockIOPool pool = SockIOPool.getInstance();

        // set the servers and the weights
        pool.setServers(servers);
        // pool.setWeights(weights);

        // set some basic pool settings
        // 5 initial, 5 min, and 250 max conns
        // and set the max idle time for a conn
        // to 6 hours
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000 * 60 * 60 * 6);

        // set the sleep for the maint thread
        // it will wake up every x seconds and
        // maintain the pool size
        pool.setMaintSleep(30);

        // set some TCP settings
        // disable nagle
        // set the read timeout to 3 secs
        // and don't set a connect timeout
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);

        // initialize the connection pool
        pool.initialize();

    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
