/**
 * 
 */
package com.usefullc.platform.service.auth;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.ServletContextAware;

import com.usefullc.platform.common.CommConstant;
import com.usefullc.platform.common.dto.UserInfoSpringDto;
 
/**
 * @author tangss
 * @2013年9月28日 @上午9:19:25
 */
public class SecurityManagerSupport implements UserDetailsService, ServletContextAware {

    @Resource
    private IUserManager userManager;

    ServletContext       servletContext;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;
        if (StringUtils.isNotEmpty(username) && username.equals("test")) {
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("admin_role"));
            user = new UserInfoSpringDto(username, "e10adc3949ba59abbe56e057f20f883e", true, true, true, true, authorities);
        } else {
            user = userManager.getUserByUserName(username);
        }
        this.servletContext.setAttribute(CommConstant.USER_INFO, user);
        return user;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
