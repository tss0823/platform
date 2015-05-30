/**
 * 
 */
package com.usefullc.platform.common.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
 
/**
 * @author tangss
 * @2013年10月12日 @下午3:03:59
 */
public class UserInfoSpringDto extends User {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 用户中文名
     */
    private String            cnName;

    /**
     * @param username
     * @param password
     * @param enabled
     * @param accountNonExpired
     * @param credentialsNonExpired
     * @param accountNonLocked
     * @param authorities
     */
    public UserInfoSpringDto(String username, String password, boolean enabled, boolean accountNonExpired,
                    boolean credentialsNonExpired, boolean accountNonLocked,
                    Collection<? extends GrantedAuthority> authorities){
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

}
