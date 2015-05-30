/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.log;

import javax.servlet.ServletContextEvent;

import com.usefullc.platform.common.utils.ConfigUtils;
import org.springframework.web.util.Log4jConfigListener;

import com.usefullc.platform.common.constant.CommonConstant;

/**
 * 类CommonLog4jConfigListener.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年5月29日 下午3:40:01
 */
public class CommonLog4jConfigListener extends Log4jConfigListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // 初始化变量
        String logLevel = ConfigUtils.getValue(CommonConstant.LOG_LEVEL);
        System.setProperty(CommonConstant.LOG_LEVEL, logLevel);
        String logDir = ConfigUtils.getValue(CommonConstant.LOG_DIR);
        System.setProperty(CommonConstant.LOG_DIR, logDir);

        super.contextInitialized(event);
    }

}
