/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.dto;

import java.io.Serializable;

/**
 * 类SystemDto.java的实现描述：系统对象
 * 
 * @author shengshang.tang 2013年12月6日 下午9:08:30
 */
public class SystemDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1186223556923515450L;

    /**
     * 系统编号
     */
    private String            sysCode;

    /**
     * session id
     */
    private String            sid;

    /**
     * 注销url
     */
    private String            logoutUrl;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

}
