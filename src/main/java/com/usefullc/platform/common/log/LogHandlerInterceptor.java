/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.log;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.OnlineUserManager;
import com.usefullc.platform.common.filter.ActionHandler;
import com.usefullc.platform.common.filter.ActionHandlerInterceptor;
import com.usefullc.platform.remote.authority.ILogInfoRemoteService;
import com.usefullc.platform.remote.authority.dto.LogInfoDto;
import net.sf.json.JSONObject;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 类PerformanceMonitorFilter.java的实现描述：性能统计监控拦截器
 * 
 * @author shengshang.tang 2014年5月19日 下午1:42:05
 */
public class LogHandlerInterceptor implements ActionHandlerInterceptor, ApplicationContextAware {

    private final static Logger     log         = LoggerFactory.getLogger(LogHandlerInterceptor.class);

    /**
     * 日志监控状态
     */
    private Boolean                 monitor     = true;

    /**
     * 请求url正则匹配，默认为.htm
     */
    private String                  urlPattern  = "*.htm";

    private ThreadLocal<LogInfoDto> threadLocal = new ThreadLocal<LogInfoDto>();

    /**
     * 日志service
     */
    private ILogInfoRemoteService logInfoRemoteService;

    /*
     * (non-Javadoc)
     * @see ActionHandlerInterceptor#beforeHandler()
     */
    @Override
    public void beforeHandler(ActionHandler actionHandler) {
        if (!this.monitor) { // 不监控
            return;
        }
        Long userId = OnlineUserManager.getUserId();
        if (userId == null) { // 未登录
            return;
        }
        HttpServletRequest request = actionHandler.getRequest();

        String url = request.getRequestURI();

        // 是否能记录
        if (!logInfoRemoteService.canRecord(url)) {
            return;
        }

        // 创建
        LogInfoDto domain = new LogInfoDto();
        domain.setRequestUrl(url);

        // 用户姓名
        String cnName = OnlineUserManager.getCnName();
        domain.setUserName(cnName);

        String remoteAddr = request.getRemoteAddr();
        domain.setRemoteAddr(remoteAddr);

        // request headers
        JSONObject jsonObj = new JSONObject();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            StringBuilder sb = new StringBuilder();
            while (headerValues.hasMoreElements()) {
                sb.append(headerValues.nextElement());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.substring(0, sb.length() - 1);
            }
            jsonObj.put(headerName, sb.toString());
        }
        domain.setRequestHeader(jsonObj.toString());

        // request data
        jsonObj = new JSONObject();
        Map<String, String[]> paramMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(paramMap)) {
            Set<Entry<String, String[]>> set = paramMap.entrySet();
            for (Entry<String, String[]> entry : set) {
                String key = entry.getKey();
                String value = ArrayUtils.toString(entry.getValue());
                jsonObj.put(key, value);
            }
        }
        domain.setRequestData(jsonObj.toString());
        threadLocal.set(domain);

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
        Long userId = OnlineUserManager.getUserId();
        if (userId == null) { // 未登录
            return;
        }
        // 获得logInfo
        LogInfoDto domain = threadLocal.get();
        if (domain == null) {
            return;
        }
        HttpServletResponse response = actionHandler.getResponse();

        domain.setActionState(actionHandler.getState());

        // 错误消息栈
        if (!actionHandler.getState()) {
            domain.setErrMsg(actionHandler.getErrMsg());
        }

        // request headers
        JSONObject jsonObj = new JSONObject();

        Collection<String> headerNames = response.getHeaderNames(); //
        for (String headerName : headerNames) {
            Collection<String> headerValues = response.getHeaders(headerName);
            StringBuilder sb = new StringBuilder();
            for (String headerValue : headerValues) {
                sb.append(headerValue);
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.substring(0, sb.length() - 1);
            }
            jsonObj.put(headerName, sb.toString());
        }
        domain.setResponseHeader(jsonObj.toString());

        domain.setStatus(String.valueOf(response.getStatus()));

        // 保存日志信息
        logInfoRemoteService.insertLogInfo(domain);

        // 最后清空
        threadLocal.set(null);
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

    /*
     * (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.
     * ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logInfoRemoteService = applicationContext.getBean("logInfoRemoteService", ILogInfoRemoteService.class);

    }

    public void setMonitor(Boolean monitor) {
        this.monitor = monitor;
    }

}
