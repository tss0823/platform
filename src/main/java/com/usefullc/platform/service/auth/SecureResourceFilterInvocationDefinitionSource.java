/**
 * 
 */
package com.usefullc.platform.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.CommConstant;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.web.context.ServletContextAware;

import com.usefullc.platform.common.ServeltContextManager;
 
/**
 * @author tangss
 * @2013年9月28日 @上午9:44:38
 */
public class SecureResourceFilterInvocationDefinitionSource implements FilterInvocationSecurityMetadataSource, ServletContextAware {

    private Map<String, String>                      linkMap;
    private Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

    // 获得请求资源所需的权限
    @Override
    public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
        // 设置res req
        HttpServletRequest req = ((FilterInvocation) filter).getRequest();
        HttpServletResponse res = ((FilterInvocation) filter).getResponse();
        ServeltContextManager.set(req, res);

        if (linkMap == null || linkMap.isEmpty()) {
            return null;
        }
        RequestMatcher matcher = null;
        Set<Entry<String, String>> linkSet = linkMap.entrySet();
        for (Entry<String, String> entry : linkSet) {
            String url = entry.getKey();
            matcher = new AntPathRequestMatcher(url);
            if (matcher.matches(((FilterInvocation) filter).getRequest())) {
                Collection<ConfigAttribute> configAttributes = resourceMap.get(url);
                if (configAttributes != null) {
                    return configAttributes;
                }
                // 解析 role
                String value = entry.getValue(); // split by comma
                String values[] = value.split(",");
                configAttributes = new ArrayList<ConfigAttribute>();
                for (String attribute : values) {
                    ConfigAttribute configAttribute = new SecurityConfig(attribute);
                    configAttributes.add(configAttribute);
                }
                resourceMap.put(url, configAttributes);
                return configAttributes;
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setServletContext(ServletContext servletContext) {
        ServeltContextManager.setServletContext(servletContext); // 设置全局servletcontent
        linkMap = (Map<String, String>) servletContext.getAttribute(CommConstant.LINK_MAP);
    }

}
