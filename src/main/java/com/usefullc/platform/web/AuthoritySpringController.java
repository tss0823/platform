/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.web;

import org.springframework.security.core.context.SecurityContextHolder;

import com.usefullc.platform.common.dto.UserInfoDto;
import com.usefullc.platform.common.dto.UserInfoSpringDto;

/**
 * 类AuthoritySpringController.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年2月17日 下午3:04:09
 */
public class AuthoritySpringController extends AbstractController {

    /**
     * 获得用户信息
     * 
     * @return
     */
    @Override
    protected UserInfoDto getUserInfo() {
        UserInfoSpringDto userDetails = (UserInfoSpringDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetails.getUsername();
        UserInfoDto dto = new UserInfoDto();
        dto.setCnName(userDetails.getCnName());
        dto.setUsername(userDetails.getUsername());
        return dto;
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
}
