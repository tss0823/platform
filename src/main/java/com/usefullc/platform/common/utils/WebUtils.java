/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usefullc.platform.common.CommConstant;
import org.springframework.util.StringUtils;

import com.usefullc.platform.common.ServeltContextManager;

/**
 * 类WebUtils.java的实现描述：web工具类
 * 
 * @author shengshang.tang 2013年12月8日 下午2:32:15
 */
public class WebUtils {

    public static synchronized String getSessionId() {
        HttpServletRequest request = ServeltContextManager.getRequest();
        String sid = CookieUtils.getValue(request, CommConstant.SESSION_ID);
        if (StringUtils.isEmpty(sid)) {
            // 将sid放到cookie中
            HttpServletResponse response = ServeltContextManager.getResponse();
            HttpSession session = request.getSession();
            sid = session.getId();
            String domain = ConfigUtils.getValue(CommConstant.COOKIE_DOMAIN);
            CookieUtils.addCookie(response, CommConstant.SESSION_ID, sid, domain);
        }
        return sid;
    }

    /**
     * 获得客户端ip
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
