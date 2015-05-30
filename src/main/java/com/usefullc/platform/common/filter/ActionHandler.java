/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类ActionHandler.java的实现描述：handler对象
 * 
 * @author shengshang.tang 2014年5月20日 上午10:10:31
 */
public class ActionHandler {

    private HttpServletRequest  request;
    private HttpServletResponse response;

    /**
     * 业务执行状态
     */
    private Boolean             state;

    /**
     * 错误消息
     */
    private String              errMsg;

    /**
     * @param request
     * @param response
     */
    public ActionHandler(HttpServletRequest request, HttpServletResponse response){
        super();
        this.request = request;
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
