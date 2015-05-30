/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Stack;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.usefullc.platform.common.ServeltContextManager;

/**
 * 类WebCommonFilter.java的实现描述：公共应用过滤器
 * 
 * @author shengshang.tang 2014年5月19日 下午1:53:10
 */
public class WebCommonFilter implements Filter {

    private ActionHandlerInvoke            actionHandlerInvoke;

    private List<ActionHandlerInterceptor> interceptorList;

    private Boolean                        canExcute = false;

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ServeltContextManager.setServletContext(servletContext);
        WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        actionHandlerInvoke = wc.getBean("actionHandlerInvoke", ActionHandlerInvoke.class);
        interceptorList = actionHandlerInvoke.getInterceptorList();
        canExcute = CollectionUtils.isNotEmpty(interceptorList);

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                             ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // String url = req.getRequestURL().toString();
        String url = req.getRequestURI();
        if (canExcute) {

            Stack<ActionHandlerInterceptor> actionStack = new Stack<ActionHandlerInterceptor>();
            ActionHandler actionHandler = new ActionHandler(req, res);
            for (ActionHandlerInterceptor interceptor : interceptorList) {
                String urlPattern = interceptor.getUrlPattern();
                // 校验是否执行url
                Boolean state = PatternMatchUtils.simpleMatch(urlPattern, url);
                if (!state) {
                    continue;
                }
                interceptor.beforeHandler(actionHandler);

                // 入栈
                actionStack.push(interceptor);

            }
            boolean actionState = false;
            try {
                chain.doFilter(request, response);
                actionState = true;
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter print = new PrintWriter(sw);
                e.printStackTrace(print);
                actionHandler.setErrMsg(sw.toString());
            } finally {
                // 出栈执行
                actionHandler.setState(actionState);
                while (!actionStack.isEmpty()) {
                    ActionHandlerInterceptor interceptor = actionStack.pop();
                    interceptor.afterHandler(actionHandler);
                }

            }

        } else {
            chain.doFilter(request, response);
        }

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        String url = "http://wwww.fsd.co/query/11111.htm1";
        AntPathMatcher antMatcher = new AntPathMatcher();
        Boolean state = PatternMatchUtils.simpleMatch("*.htm", url);
        System.out.println(state);
    }

}
