/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.remote.authority;

import com.usefullc.platform.remote.authority.dto.LogInfoDto;

/**
 * 类ILogInfoRemoteService.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年5月20日 下午3:55:54
 */
public interface ILogInfoRemoteService {

    /**
     * 保存日志信息
     * 
     * @param dto
     */
    void insertLogInfo(LogInfoDto dto);

    /**
     * 是否能记录日志
     * 
     * @param requestUrl
     * @return
     */
    Boolean canRecord(String requestUrl);
}
