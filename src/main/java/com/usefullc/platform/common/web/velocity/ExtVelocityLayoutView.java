/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.web.velocity;

import javax.servlet.FilterConfig;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.view.VelocityView;

/**
 * 类ExtVelocityView.java的实现描述：扩展 VelocityView
 * 
 * @author shengshang.tang 2014年3月6日 上午11:06:23
 */
public class ExtVelocityLayoutView extends VelocityView {

    /**
     * @param config
     */
    public ExtVelocityLayoutView(FilterConfig config){
        super(config);
    }

    /*
     * (non-Javadoc)
     * @see org.apache.velocity.tools.ToolManager#getVelocityEngine()
     */
    @Override
    public VelocityEngine getVelocityEngine() {

        return super.getVelocityEngine();
    }

}
