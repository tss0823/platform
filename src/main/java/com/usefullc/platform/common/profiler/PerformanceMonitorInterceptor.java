/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.profiler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usefullc.platform.common.filter.ActionHandler;
import com.usefullc.platform.common.filter.ActionHandlerInterceptor;

/**
 * 类PerformanceMonitorFilter.java的实现描述：性能统计监控拦截器
 * 
 * @author shengshang.tang 2014年5月19日 下午1:42:05
 */
public class PerformanceMonitorInterceptor implements ActionHandlerInterceptor {

    private final static Logger log        = LoggerFactory.getLogger(PerformanceMonitorInterceptor.class);

    private Boolean             monitor    = true;

    /**
     * 缺省监测值为100毫秒，超过这个值的request请求将被记录
     */
    private int                 threshold  = 100;

    /**
     * 请求url正则匹配，默认为.htm
     */
    private String              urlPattern = "*.htm";

    /*
     * (non-Javadoc)
     * @see ActionHandlerInterceptor#beforeHandler()
     */
    @Override
    public void beforeHandler(ActionHandler actionHandler) {
        if (!this.monitor) { // 不监控
            return;
        }
        HttpServletRequest request = actionHandler.getRequest();
        String url = request.getRequestURL().toString();
        ProfileTaskManger.startFirst("", url);

    }

    /*
     * (non-Javadoc)
     * @see ActionHandlerInterceptor#afterHandler()
     */
    @Override
    public void afterHandler(ActionHandler actionHandler) {
        if (!this.monitor) { // 不监控
            return;
        }
        ProfileTaskManger.endLast(threshold);
        ProfileTaskManger.clear();

    }

    /*
     * (non-Javadoc)
     * @see ActionHandlerInterceptor#getUrlPattern()
     */
    @Override
    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setMonitor(Boolean monitor) {
        this.monitor = monitor;
    }

}
