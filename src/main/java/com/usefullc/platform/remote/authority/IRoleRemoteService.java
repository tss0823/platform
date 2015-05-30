/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority;

import java.util.List;

import com.usefullc.platform.remote.authority.dto.RoleDto;

/**
 * 类IRoleRemoteService.java的实现描述：角色远程接口
 * 
 * @author shengshang.tang 2014年4月3日 下午4:54:29
 */
public interface IRoleRemoteService {

    /**
     * 根据角色id集合获得角色远程对象集合
     * 
     * @param roleIds
     * @return
     */
    List<RoleDto> getRoleListByRoleIds(List<Long> roleIds);
}
