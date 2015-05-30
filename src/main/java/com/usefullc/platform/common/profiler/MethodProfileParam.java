/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.profiler;

/**
 * 类PerformanceParam.java的实现描述：方法拦截参数封装
 * 
 * @author shengshang.tang 2014年5月20日 上午10:52:14
 */
public class MethodProfileParam {

    private Boolean monitor    = true;

    private int     infoValve  = 100; // >= 100

    private int     warnValve  = 500; // >= 500

    private int     errorValve = 1000; // >= 1000

    private int     fatalValve = 5000;

    public Boolean getMonitor() {
        return monitor;
    }

    public void setMonitor(Boolean monitor) {
        this.monitor = monitor;
    }

    public int getInfoValve() {
        return infoValve;
    }

    public void setInfoValve(int infoValve) {
        this.infoValve = infoValve;
    }

    public int getWarnValve() {
        return warnValve;
    }

    public void setWarnValve(int warnValve) {
        this.warnValve = warnValve;
    }

    public int getErrorValve() {
        return errorValve;
    }

    public void setErrorValve(int errorValve) {
        this.errorValve = errorValve;
    }

    public int getFatalValve() {
        return fatalValve;
    }

    public void setFatalValve(int fatalValve) {
        this.fatalValve = fatalValve;
    }

}
