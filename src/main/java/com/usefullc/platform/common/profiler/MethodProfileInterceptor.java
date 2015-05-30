package com.usefullc.platform.common.profiler;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类MethodProfileInterceptor.java的实现描述：性能统计方法拦截器
 * 
 * @author shengshang.tang 2014年5月20日 上午11:29:16
 */
public class MethodProfileInterceptor extends MethodProfileParam implements MethodInterceptor {

    private final static Logger log = LoggerFactory.getLogger(MethodProfileInterceptor.class);

    /*
     * (non-Javadoc)
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (getMonitor()) {
            Method method = invocation.getMethod();
            String className = ClassUtils.getShortClassName(method.getDeclaringClass());
            ProfileTaskManger.start(className, className + ":" + method.getName());
        }
        try {
            return invocation.proceed();
        } finally {
            if (getMonitor()) {
                ProfileTaskManger.end(this);
            }
        }
    }

}
