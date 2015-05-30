/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.cache;

import org.springframework.beans.factory.FactoryBean;

/**
 * 类CacheFactoryBean.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年5月15日 下午4:07:31
 */
public class CacheFactoryBean implements FactoryBean<ICacheService> {

    private ICacheService serviceObj;

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    @Override
    public ICacheService getObject() throws Exception {
        return serviceObj;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    @Override
    public Class<?> getObjectType() {
        return ICacheService.class;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setServiceObj(ICacheService serviceObj) {
        this.serviceObj = serviceObj;
    }

}
