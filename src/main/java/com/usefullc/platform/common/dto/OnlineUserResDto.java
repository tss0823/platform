/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.dto;

import java.io.Serializable;
import java.util.List;

import com.usefullc.platform.web.form.MenuTree;

/**
 * 类UserResDto.java的实现描述：登录用户资源信息
 * 
 * @author shengshang.tang 2013年12月5日 下午5:25:26
 */
public class OnlineUserResDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -950283384345958321L;

    private UserInfoDto       userInfo;

    private MenuTree rootMenuTree;
    
    private List<UserStationInfoDto>  userStationInfoList;

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    public MenuTree getRootMenuTree() {
        return rootMenuTree;
    }

    public void setRootMenuTree(MenuTree rootMenuTree) {
        this.rootMenuTree = rootMenuTree;
    }

	public List<UserStationInfoDto> getUserStationInfoList() {
		return userStationInfoList;
	}

	public void setUserStationInfoList(List<UserStationInfoDto> userStationInfoList) {
		this.userStationInfoList = userStationInfoList;
	}


}
