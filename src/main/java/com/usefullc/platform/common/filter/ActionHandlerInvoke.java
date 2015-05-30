/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

import java.util.List;

/**
 * 类ActionInvokeExecute.java的实现描述：请求动作拦截封装对象
 * 
 * @author shengshang.tang 2014年5月19日 下午2:01:14
 */
public class ActionHandlerInvoke {

    private List<ActionHandlerInterceptor> interceptorList;

    public void invoke() {
        // for(ActionHandlerInterceptor)
    }

    public void setInterceptorList(List<ActionHandlerInterceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public List<ActionHandlerInterceptor> getInterceptorList() {
        return interceptorList;
    }

}
