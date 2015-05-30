/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.web;

import com.usefullc.platform.common.OnlineUserManager;
import com.usefullc.platform.common.dto.UserInfoDto;

/**
 * 类AuthorityController.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年2月17日 下午3:04:09
 */
public class AuthorityController extends AbstractController {

    /**
     * 获得用户信息
     * 
     * @return
     */
    @Override
    protected UserInfoDto getUserInfo() {
        return OnlineUserManager.getUserInfo();
    }

    /**
     * 获得用户ID
     * 
     * @return
     */
    protected Long getUserId() {
        return getUserInfo().getId();
    }

    /**
     * 获得用户名
     * 
     * @return
     */
    protected String getUsername() {
        return getUserInfo().getUsername();
    }

    /**
     * 获得用户姓名
     * 
     * @return
     */
    protected String getCnName() {
        return getUserInfo().getCnName();
    }

    /**
     * 获得用户所在部门
     * 
     * @return
     */
    protected Long getDeptId() {
        return getUserInfo().getDeptId();
    }  

    /**
     * 获得用户所在公司
     * 
     * @return
     */
    protected Long getEntpId() {
        return getUserInfo().getEntpId();
    }     
}
