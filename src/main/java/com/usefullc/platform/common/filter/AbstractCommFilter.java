/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.ServeltContextManager;

/**
 * 类AbstractCommFilter.java的实现描述 公用过滤器基类
 * 
 * @author shengshang.tang 2013年12月6日 下午9:15:02
 */
public abstract class AbstractCommFilter implements Filter {

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                             ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        ServeltContextManager.set(req, res);
        if (!urlFilterExecute(req, res)) {
            chain.doFilter(req, res);
            return;
        }
        // 写业务
        if (!this.execute(req, res)) {
            return;
        }

        // 过滤执行
        executeFilter(req, res, chain);

        // 之行后
        afterExecute(req, res);
    }

    public void executeFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                                                                                                          throws IOException,
                                                                                                          ServletException {
        chain.doFilter(request, response);
    }

    public boolean urlFilterExecute(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    public abstract boolean execute(HttpServletRequest request, HttpServletResponse response);

    public boolean afterExecute(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}
