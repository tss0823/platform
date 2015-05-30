/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

/**
 * 类ActionInvokeInterceptor.java的实现描述：请求动作处理拦截器
 * 
 * @author shengshang.tang 2014年5月19日 下午1:54:31
 */
public interface ActionHandlerInterceptor {

    String getUrlPattern();

    void beforeHandler(ActionHandler actionHandler);

    void afterHandler(ActionHandler actionHandler);
}
