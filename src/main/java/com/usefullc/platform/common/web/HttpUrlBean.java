/**
 * 
 */
package com.usefullc.platform.common.web;

import javax.servlet.http.HttpServletRequest;

import com.usefullc.platform.common.utils.WebUtils;
import org.apache.commons.lang.StringUtils;

import com.usefullc.platform.common.ServeltContextManager;

/**
 * @author tangss
 * @2013年9月6日 @下午4:42:07
 */
public class HttpUrlBean {

    /**
     * 地址
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * web上下文
     */
    private String context;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        HttpServletRequest request = ServeltContextManager.getRequest();
        if (StringUtils.isEmpty(host)) {
            host = WebUtils.getIpAddr(request);
        }
        sb.append(host);
        if (StringUtils.isNotEmpty(port)) {
            sb.append(":");
            sb.append(port);
        }
        if (StringUtils.isNotEmpty(context)) {
            sb.append(context);
        }
        return sb.toString();
    }

}
