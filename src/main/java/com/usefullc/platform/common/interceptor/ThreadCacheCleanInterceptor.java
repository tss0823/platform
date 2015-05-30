package com.usefullc.platform.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.usefullc.platform.common.utils.ThreadLocalMultUtils;

/**
 * 类CacheCleanInterceptor.java的实现描述：线程缓存清空拦截器
 * 
 * @author shengshang.tang 2014年4月16日 下午4:19:54
 */
public class ThreadCacheCleanInterceptor extends HandlerInterceptorAdapter {

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        // 删除线程缓存
        ThreadLocalMultUtils.remove();
        super.postHandle(request, response, handler, modelAndView);
    }

}
