package com.usefullc.platform.service.auth;

import com.usefullc.platform.common.dto.UserInfoSpringDto;

/**
 * @author tangss
 * @2013年9月28日 @上午9:28:53
 */
public interface IUserManager {

    UserInfoSpringDto getUserByUserName(String userName);
}
