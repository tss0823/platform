package com.usefullc.platform.service.auth;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
 
/**
 * 
 * 
 */
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager {

    private final static Logger log = LoggerFactory.getLogger(AccessDecisionManager.class);

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
                                                                                                                  throws AccessDeniedException,
                                                                                                                  InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        for (ConfigAttribute ca : configAttributes) {
            String needRole = ((SecurityConfig) ca).getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        log.error("没有权限");
        throw new AccessDeniedException("没有权限");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
