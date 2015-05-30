/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.dto;

import java.io.Serializable;

/**
 * 类AppInfo.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年2月21日 上午10:49:37
 */
public class AppInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7017596246011392225L;

    private String            appsPath;

    private String            imagesPath;

    private String            scriptsPath;

    public String getAppsPath() {
        return appsPath;
    }

    public void setAppsPath(String appsPath) {
        this.appsPath = appsPath;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public String getScriptsPath() {
        return scriptsPath;
    }

    public void setScriptsPath(String scriptsPath) {
        this.scriptsPath = scriptsPath;
    }

}
