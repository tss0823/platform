/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority;

/**
 * 类IAuthorityService.java的实现描述：用户认证远程服务接口
 * 
 * @author shengshang.tang 2013年12月6日 下午2:10:01
 */
public interface IAuthenticateRemoteService {

    /**
     * 用户退出
     * 
     * @param sysCode
     * @param sid
     */
    void logout(String sysCode, String sid);
}
