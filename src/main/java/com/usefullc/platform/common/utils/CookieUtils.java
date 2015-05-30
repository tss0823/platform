/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.usefullc.platform.common.ServeltContextManager;

/**
 * 类CookieUtils.java的实现描述：cookie 工具类
 * 
 * @author shengshang.tang 2013年12月5日 下午4:43:18
 */
public class CookieUtils {

    /**
     * 获得cookie 值
     * 
     * @param request
     * @param name
     * @param domain
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name, String domain) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            String cookieDomain = cookie.getDomain();
            if (!cookieName.equals(name)) {
                continue;
            }
            if (StringUtils.isNotEmpty(domain) && !cookieDomain.equals(domain)) {
                continue;
            }
            return cookie;
        }
        return null;
    }

    /**
     * 获得cookie 值
     * 
     * @param request
     * @param name
     * @param domain
     * @return
     */
    public static String getValue(HttpServletRequest request, String name, String domain) {
        Cookie cookie = getCookie(request, name, domain);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public static String getValue(HttpServletRequest request, String name) {
        return getValue(request, name, null);
    }

    /**
     * 添加cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param domain
     * @param expire
     */
    public static void addCookie(HttpServletResponse response, String name, String value, String domain, Integer expire) {
        Cookie cookie = new Cookie(name, value);
        if (StringUtils.isNotEmpty(domain)) {
            cookie.setDomain(domain);
        }
        if (expire != null) {
            cookie.setMaxAge(expire);
        }
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void addCookie(HttpServletResponse response, String name, String value, String domain) {
        addCookie(response, name, value, domain, null);
    }

    public static void addCookie(HttpServletResponse response, String name, String value, Integer expire) {
        addCookie(response, name, value, null, expire);
    }

    public static void addCookie(HttpServletResponse response, String name, String value) {
        addCookie(response, name, value, null, null);
    }

    /**
     * 删除cookie
     * 
     * @param request
     * @param response
     * @param name
     */
    public static void remove(String name, String domain) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setDomain(domain);
        HttpServletResponse response = ServeltContextManager.getResponse();
        response.addCookie(cookie);
    }
}
