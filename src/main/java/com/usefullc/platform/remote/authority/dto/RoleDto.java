/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority.dto;

import com.usefullc.platform.domain.BaseDomain;

/**
 * 类RoleDto.java的实现描述：角色DTO
 * 
 * @author shengshang.tang 2014年4月3日 下午4:52:55
 */
public class RoleDto extends BaseDomain {

    private static final long serialVersionUID = 1L;

    /** ID * */
    private java.lang.Long    id;

    /** 名称 * */
    private java.lang.String  name;

    /** 编号 * */
    private java.lang.String  code;

    /** 删除状态（0：已删除；1：未删除） * */
    private java.lang.Boolean delState;

    /** 创建时间 * */
    private java.util.Date    gmtCreate;

    /** 修改时间 * */
    private java.util.Date    gmtModify;

    /** 系统ID * */
    private java.lang.Long    systemId;

    /** 父ID * */
    private java.lang.Long    parentId;

    /** 排序 * */
    private java.lang.Integer orderby;

    /** 备注 * */
    private java.lang.String  memo;

    public void setId(java.lang.Long value) {
        this.id = value;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setName(java.lang.String value) {
        this.name = value;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setCode(java.lang.String value) {
        this.code = value;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public void setDelState(java.lang.Boolean value) {
        this.delState = value;
    }

    public java.lang.Boolean getDelState() {
        return this.delState;
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

    public void setSystemId(java.lang.Long value) {
        this.systemId = value;
    }

    public java.lang.Long getSystemId() {
        return this.systemId;
    }

    public void setParentId(java.lang.Long value) {
        this.parentId = value;
    }

    public java.lang.Long getParentId() {
        return this.parentId;
    }

    public void setOrderby(java.lang.Integer value) {
        this.orderby = value;
    }

    public java.lang.Integer getOrderby() {
        return this.orderby;
    }

    public void setMemo(java.lang.String value) {
        this.memo = value;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

}
