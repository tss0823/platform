package com.usefullc.platform.common.cache.vm;

import com.usefullc.platform.common.cache.DateUnitEnum;
import com.usefullc.platform.common.cache.ICacheService;
import com.usefullc.platform.common.utils.StrUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengshan.tang on 2015/6/1 0001 0:18.
 */
public class VmCacheServiceImpl implements ICacheService, InitializingBean {

    private Map<String, Object> cacheMap = new HashMap<String, Object>();
    private Map<String, Object> cacheKeyTimeMap = new HashMap<String, Object>();

    /**
     * ”¶”√√˚≥∆
     */
    private String system;

    @Override
    public void set(String key, Object value) {
        String newKey = StrUtils.join(system, key);
        cacheMap.put(newKey, value);
    }

    @Override
    public void set(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        String newKey = StrUtils.join(system, key);
        cacheMap.put(newKey, value);
    }

    @Override
    public Object get(String key) {
        String newKey = StrUtils.join(system, key);
        return cacheMap.get(newKey);
    }

    @Override
    public void setGlobal(String key, Object value) {
        cacheMap.put(key, value);
    }

    @Override
    public void setGlobal(String key, Object value, DateUnitEnum dateUnit, Integer expireAmount) {
        cacheMap.put(key, value);
    }

    @Override
    public Object getGlobal(String key) {
        return cacheMap.get(key);
    }

    @Override
    public void remove(String key) {
        String newKey = StrUtils.join(system, key);
        cacheMap.remove(newKey);
    }

    @Override
    public void removeGlobal(String key) {
        cacheMap.remove(key);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }


    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
