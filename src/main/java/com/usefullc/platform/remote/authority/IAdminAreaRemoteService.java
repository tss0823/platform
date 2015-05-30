/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority;

import com.usefullc.platform.remote.authority.dto.AdminAreaDto;

/**
 * 类IUserRemoteService.java的实现描述：行政区划远程接口
 * 
 * @author shengshang.tang 2014年4月2日 上午11:15:13
 */
public interface IAdminAreaRemoteService {

    /**
     * 根据行政区划id，获取对应行政区划信息
     * 
     * @param id
     * @return
     */
    // List<Long> selectUserIdByRoleIds(List<Long> roleIdlist);

    AdminAreaDto getAdminAreaInfoById(Long id);

    /**
     * 根据用户id获得行政区划对象
     * 
     * @param userId
     * @return
     */
    AdminAreaDto getAdminAreaInfoByUserId(Long userId);

}
