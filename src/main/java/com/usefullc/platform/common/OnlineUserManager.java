/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common;

import java.util.List;

import com.usefullc.platform.common.dto.OnlineUserResDto;
import com.usefullc.platform.common.dto.SystemDto;
import com.usefullc.platform.common.dto.UserInfoDto;
import com.usefullc.platform.common.dto.UserStationInfoDto;

/**
 * 类OnlineUserManager.java的实现描述：在线用户管理类
 * 
 * @author shengshang.tang 2013年12月5日 下午5:47:45
 */
public class OnlineUserManager {

    static ThreadLocal<OnlineUserResDto> oudLocal    = new ThreadLocal<OnlineUserResDto>();

    static ThreadLocal<SystemDto>        systemLocal = new ThreadLocal<SystemDto>();

    public static void setOnlineUserResDto(OnlineUserResDto oud) {
        oudLocal.set(oud);
    }

    public static void setSystemDto(SystemDto system) {
        systemLocal.set(system);
    }

    /**
     * 获取用户对象
     * 
     * @return
     */
    public static UserInfoDto getUserInfo() {
        OnlineUserResDto oud = oudLocal.get();
        if (oud != null) {
            return oud.getUserInfo();
        }
        return null;
    }

    public static List<UserStationInfoDto> getStationInfo() {
        OnlineUserResDto oud = oudLocal.get();
        return oud.getUserStationInfoList();
    }

    /**
     * 获取用户id
     * 
     * @return
     */
    public static Long getUserId() {
        UserInfoDto oud = getUserInfo();
        if (oud != null) {
            return oud.getId();
        }
        return null;
    }

    /**
     * 获取用户名
     * 
     * @return
     */
    public static String getUsername() {
        UserInfoDto oud = getUserInfo();
        if (oud != null) {
            return oud.getUsername();
        }
        return null;
    }

    /**
     * 获取中文名
     * 
     * @return
     */
    public static String getCnName() {
        UserInfoDto oud = getUserInfo();
        if (oud != null) {
            return oud.getCnName();
        }
        return null;
    }

    public static SystemDto getSystem() {
        return systemLocal.get();
    }
}
