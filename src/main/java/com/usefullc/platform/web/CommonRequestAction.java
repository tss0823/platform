/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.CommConstant;
import com.usefullc.platform.common.OnlineUserManager;
import com.usefullc.platform.common.dto.AppInfo;
import com.usefullc.platform.common.dto.SystemDto;
import com.usefullc.platform.common.utils.ConfigUtils;
import com.usefullc.platform.common.utils.JsonUtil;
import com.usefullc.platform.web.form.MenuTree;
import org.springframework.web.HttpRequestHandler;

import com.usefullc.platform.common.ServeltContextManager;
import com.usefullc.platform.common.utils.StrUtils;

/**
 * 类CommonController.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2013年12月6日 下午10:19:22
 */
public class CommonRequestAction extends AbstractController implements HttpRequestHandler {

    /**
     * 获得系统信息
     */
    public void getSystem() {
        SystemDto systemDto = OnlineUserManager.getSystem();
        String urlAuthorityUrl = ConfigUtils.getValue(CommConstant.URL_AUTHORITY_APP);
        String logoutUrl = StrUtils.joinEmpty(urlAuthorityUrl, "/logout.htm");
        systemDto.setLogoutUrl(logoutUrl);
        String str = JsonUtil.toStr(systemDto);
        this.write(str);
    }

    /**
     * 获得应用信息
     */
    public void getAppInfo() {
        AppInfo appInfo = new AppInfo();
        HttpServletRequest request = ServeltContextManager.getRequest();
        appInfo.setAppsPath(request.getAttribute("appsPath").toString());
        appInfo.setImagesPath(request.getAttribute("imagesPath").toString());
        appInfo.setScriptsPath(request.getAttribute("scriptsPath").toString());
        String str = JsonUtil.toStr(appInfo);
        this.write(str);
    }

    public void getRootMenuTree() {
        HttpServletRequest request = ServeltContextManager.getRequest();
        MenuTree root = (MenuTree) request.getAttribute(CommConstant.ROOT_MENU_TREE);
        String str = JsonUtil.toStr(root);
        this.write(str);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                       IOException {
        String url = request.getRequestURI();
        String methodName = request.getParameter("method");
        try {
            Method method = this.getClass().getMethod(methodName);
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
