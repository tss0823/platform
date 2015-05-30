/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.CommConstant;
import com.usefullc.platform.common.OnlineUserManager;
import com.usefullc.platform.common.utils.ConfigUtils;
import com.usefullc.platform.common.utils.CookieUtils;
import com.usefullc.platform.common.utils.WebUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.usefullc.platform.common.ServeltContextManager;
import com.usefullc.platform.common.cache.ICacheService;
import com.usefullc.platform.common.dto.OnlineUserResDto;
import com.usefullc.platform.common.dto.SystemDto;
import com.usefullc.platform.common.utils.StrUtils;

/**
 * 类AuthorityFilter.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2013年12月3日 下午2:14:08
 */
public class AuthorityFilter extends AbstractCommFilter {

    private ICacheService cacheService;

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ServeltContextManager.setServletContext(servletContext);
        WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        cacheService = wc.getBean("cacheService", ICacheService.class);
    }

    /*
     * (non-Javadoc)
     * @see AbstractCommFilter#urlFilterExecute(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public boolean urlFilterExecute(HttpServletRequest request, HttpServletResponse response) {
        String authFilter = ConfigUtils.getValue(CommConstant.AUTH_FILTER);
        if (!Boolean.valueOf(authFilter)) { // 不用权限过滤
            return false;
        }
        // 过滤连接
        String url = request.getRequestURL().toString();

        if (!url.endsWith(".htm") && !url.endsWith("/")) { // 目前只针对.htm 和 /校验

            return false;
        } else {
            if (url.endsWith("freeLogin.htm")) {
                return false;
            }
            if (url.endsWith("enterLogin.htm")) {
                return false;
            }
            if (url.endsWith("enterLoginGov.htm")) {
                return false;
            }
            if (url.endsWith("login.htm")) {
                return false;
            }
            if (url.endsWith("logout.htm")) {
                return false;
            }
            if (url.endsWith("validateCode.htm")) {
                return false;
            }
            if (url.endsWith("register/enterAgrenMent.htm")) {
                return false;
            }
            if (url.endsWith("register/enterRegister.htm")) {
                return false;
            }
            if (url.endsWith("register/register.htm")) {
                return false;
            }
            if (url.endsWith("register/checkuser.htm")) {
                return false;
            }
            if (url.endsWith("register/checkpassword.htm")) {
                return false;
            }
            if (url.endsWith("common/selectParentFromOut.htm")) {
                return false;
            }
            if (url.endsWith("adminArea/getTreeList.htm")) {
                return false;
            }
            if (url.endsWith("ssologin.htm")) {
                return false;
            }
            if (url.endsWith("register/link.htm")) {
                return false;
            }
            if (url.endsWith("register/bind.htm")) {
                return false;
            }
            return true;
        }
    }

    /*
     * (non-Javadoc)
     * @see AbstractCommFilter#execute(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public boolean execute(HttpServletRequest request, HttpServletResponse response) {
        // 过滤连接
        String url = request.getRequestURL().toString();
        String sid = WebUtils.getSessionId();
        // 直接从memcached中取，为注销做准备
        String userKey = ConfigUtils.getValue(CommConstant.USER_KEY);
        String userKeyValue = CookieUtils.getValue(request, userKey);
        Object userId = cacheService.getGlobal(userKeyValue);
        String sysCode = ConfigUtils.getValue(CommConstant.SYS_CODE);
        if (userId == null && !url.endsWith("commonAction.htm")) { // 过滤通用执行url
            // 将url放到缓存中
            String urlKey = StrUtils.join(CommConstant.SYSTEM_CALL_BEFORE_URL, sid);
            cacheService.set(urlKey, url);

            // 跳转到sso
            try {
                String urlAuthorityUrl = ConfigUtils.getValue(CommConstant.URL_AUTHORITY_APP);
                String authorityToLoginUrl = StrUtils.joinEmpty(urlAuthorityUrl, "/freeLogin.htm?sysCode=", sysCode);
                response.sendRedirect(authorityToLoginUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;

        }
        // 获取用户和菜单资源
        String userResKey = StrUtils.join(sid, userId);
        OnlineUserResDto oud = (OnlineUserResDto) cacheService.getGlobal(userResKey);
        if (oud != null) {
            OnlineUserManager.setOnlineUserResDto(oud);
            SystemDto systemDto = new SystemDto();
            systemDto.setSid(sid);
            systemDto.setSysCode(sysCode);
            OnlineUserManager.setSystemDto(systemDto);
            request.setAttribute(CommConstant.USER_INFO, oud.getUserInfo());
            request.setAttribute(CommConstant.ROOT_MENU_TREE, oud.getRootMenuTree());
        }
        return true;
    }
}
