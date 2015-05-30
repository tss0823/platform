/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.dto;

import java.io.Serializable;

/**
 * 类UserInfoDto.java的实现描述：用户对象
 * 
 * @author shengshang.tang 2013年12月5日 下午5:26:22
 */
public class UserInfoDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8337816520643518747L;

    private Long              id;

    private String            username;

    private String            cnName;

    /**
     * 电话号码
     */
    private String            tel;

    /**
     * 手机号码
     */
    private String            mobileNo;

    /**
     * 电子邮箱
     */
    private String            email;

    // #####################危化品平台#################################
    private String            code;

    private Long              companyId;

    private Long              adminAreaId;

    private String            category;
    // #####################危化品平台#################################

    // #####################铁路物流#################################
    /**
     * 所在公司ID
     */
    private Long              entpId;

    private String            entpCode;

    private Long              deptId;

    private String            no;

    private String            entpName;

    // #####################铁路物流#################################

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getEntpId() {
        return entpId;
    }

    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getAdminareaid() {
        return adminAreaId;
    }

    public void setAdminareaid(Long adminAreaId) {
        this.adminAreaId = adminAreaId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEntpCode() {
        return entpCode;
    }

    public void setEntpCode(String entpCode) {
        this.entpCode = entpCode;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
