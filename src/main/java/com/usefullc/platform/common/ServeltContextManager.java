/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类OnlineUserManager.java的实现描述：servelt管理类
 * 
 * @author shengshang.tang 2013年12月5日 下午5:47:45
 */
public class ServeltContextManager {

    static ThreadLocal<ServeltContext> serveltLocal = new ThreadLocal<ServeltContext>();

    private static ServletContext      servletContext;

    public synchronized static void setServletContext(ServletContext _servletContext) {
        servletContext = _servletContext;
    }

    public static void set(HttpServletRequest request, HttpServletResponse response) {
        ServeltContext sc = new ServeltContext(request, response);
        serveltLocal.set(sc);
    }

    public static ServeltContext get() {
        return serveltLocal.get();
    }

    public static HttpServletRequest getRequest() {
        return get().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return get().getResponse();
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static class ServeltContext {

        HttpServletRequest  request;
        HttpServletResponse response;

        /**
         * @param request
         * @param response
         */
        public ServeltContext(HttpServletRequest request, HttpServletResponse response){
            super();
            this.request = request;
            this.response = response;
        }

        public HttpServletRequest getRequest() {
            return request;
        }

        public HttpServletResponse getResponse() {
            return response;
        }

    }
}
