/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority;

import java.util.List;

import com.usefullc.platform.common.dto.UserInfoDto;

/**
 * 类IUserRemoteService.java的实现描述：用户远程接口
 * 
 * @author shengshang.tang 2014年4月2日 上午11:15:13
 */
public interface IUserRemoteService {

    /**
     * 根据角色id集合获得用户id集合
     * 
     * @param roleIdlist
     * @return
     */
    List<Long> selectUserIdByRoleIds(List<Long> roleIdlist);

    /**
     * 根据用户id集合获得用户对象集合
     * 
     * @param ids
     * @return
     */
    List<UserInfoDto> getUserInfoListByIds(List<Long> ids);

}
