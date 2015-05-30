/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority.dto;

import com.usefullc.platform.domain.BaseDomain;

/**
 * 类LogInfoDto.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年5月20日 下午3:56:22
 */
public class LogInfoDto extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -4703132163627064576L;

    /** ID * */
    private java.lang.Long    id;

    /** 创建时间 * */
    private java.util.Date    gmtCreate;

    /** 修改时间 * */
    private java.util.Date    gmtModify;

    /** 删除状态（0：已删除；1：未删除） * */
    private java.lang.Boolean delState;

    /** 请求链接 * */
    private java.lang.String  requestUrl;

    /** 远程IP * */
    private java.lang.String  remoteAddr;

    /** 请求数据 * */
    private java.lang.String  requestData;

    /** 响应状态 * */
    private java.lang.String  status;

    /** 请求头部 * */
    private java.lang.String  requestHeader;

    /** 响应头部 * */
    private java.lang.String  responseHeader;

    /** 用户姓名 * */
    private java.lang.String  userName;

    /** 操作状态 * */
    private java.lang.Boolean actionState;

    /** 失败信息 * */
    private java.lang.String  errMsg;

    public void setId(java.lang.Long value) {
        this.id = value;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setGmtCreate(java.util.Date value) {
        this.gmtCreate = value;
    }

    public java.util.Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtModify(java.util.Date value) {
        this.gmtModify = value;
    }

    public java.util.Date getGmtModify() {
        return this.gmtModify;
    }

    public void setDelState(java.lang.Boolean value) {
        this.delState = value;
    }

    public java.lang.Boolean getDelState() {
        return this.delState;
    }

    public void setRequestUrl(java.lang.String value) {
        this.requestUrl = value;
    }

    public java.lang.String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRemoteAddr(java.lang.String value) {
        this.remoteAddr = value;
    }

    public java.lang.String getRemoteAddr() {
        return this.remoteAddr;
    }

    public void setRequestData(java.lang.String value) {
        this.requestData = value;
    }

    public java.lang.String getRequestData() {
        return this.requestData;
    }

    public void setStatus(java.lang.String value) {
        this.status = value;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setRequestHeader(java.lang.String value) {
        this.requestHeader = value;
    }

    public java.lang.String getRequestHeader() {
        return this.requestHeader;
    }

    public java.lang.String getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(java.lang.String responseHeader) {
        this.responseHeader = responseHeader;
    }

    public java.lang.String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(java.lang.String errMsg) {
        this.errMsg = errMsg;
    }

    public void setUserName(java.lang.String value) {
        this.userName = value;
    }

    public java.lang.String getUserName() {
        return this.userName;
    }

    public void setActionState(java.lang.Boolean value) {
        this.actionState = value;
    }

    public java.lang.Boolean getActionState() {
        return this.actionState;
    }
}
