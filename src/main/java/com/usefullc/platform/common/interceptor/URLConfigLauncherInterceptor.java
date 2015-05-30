package com.usefullc.platform.common.interceptor;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.utils.DateUtils;
import com.usefullc.platform.common.web.HttpUrlBean;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 类URLConfigLauncherInterceptor.java的实现描述：url设置拦截器
 * 
 * @author shengshang.tang 2014年4月16日 下午4:19:38
 */
public class URLConfigLauncherInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    private Map<String, HttpUrlBean> urlConfigs;

    @Autowired(required = false)
    private AppUrlConfig             appUrlConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        for (Entry<String, HttpUrlBean> entry : urlConfigs.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        // 处理版本号，待优化 TODO
        request.setAttribute("ver", DateUtils.getCurTime("yyyyMMddHHmm"));

        // 各自应用中定好的url config
        if (appUrlConfig != null) {
            Map<String, String> urlConfMap = appUrlConfig.getUrlConfigs();
            if (!MapUtils.isEmpty(urlConfMap)) {
                for (Entry<String, String> entry : urlConfMap.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
            }

        }
        return super.preHandle(request, response, handler);
    }

    public void setUrlConfigs(Map<String, HttpUrlBean> urlConfigs) {
        this.urlConfigs = urlConfigs;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // if (appUrlConfig != null) {
        // this.urlConfigs.putAll(appUrlConfig.getUrlConfigs());
        // }

    }

}
