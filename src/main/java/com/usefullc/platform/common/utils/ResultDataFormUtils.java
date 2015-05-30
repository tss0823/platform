/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usefullc.platform.web.form.ResultDataForm;

/**
 * 类ResultFormUtils.java的实现描述：返回数据结果工具类
 * 
 * @author shengshang.tang 2014年4月16日 下午8:46:29
 */
public class ResultDataFormUtils {

    private final static Logger log = LoggerFactory.getLogger(ResultDataFormUtils.class);

    /**
     * 打印消息日志并返回数据对象
     * 
     * @return
     */
    public static ResultDataForm success() {
        ResultDataForm rf = new ResultDataForm("1");
        return rf;
    }

    /**
     * 打印成功日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm success(String msg) {
        log.info(msg);
        ResultDataForm rf = new ResultDataForm("1", msg);
        return rf;
    }

    /**
     * 打印成功日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm success(String msg, Object data) {
        log.info(msg);
        ResultDataForm rf = new ResultDataForm("1", msg);
        rf.setData(data);
        return rf;
    }

    /**
     * 返回警告数据对象
     * 
     * @return
     */
    public static ResultDataForm warn() {
        ResultDataForm rf = new ResultDataForm("2");
        return rf;
    }

    /**
     * 打印警告日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm warn(String msg) {
        log.warn(msg);
        ResultDataForm rf = new ResultDataForm("2", msg);
        return rf;
    }

    /**
     * 打印警告日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm warn(String msg, Object data) {
        log.warn(msg);
        ResultDataForm rf = new ResultDataForm("2", msg);
        rf.setData(data);
        return rf;
    }

    /**
     * 返回数错误据对象
     * 
     * @return
     */
    public static ResultDataForm error() {
        ResultDataForm rf = new ResultDataForm("0");
        return rf;
    }

    /**
     * 打印错误日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm error(String msg) {
        log.error(msg);
        ResultDataForm rf = new ResultDataForm("0", msg);
        return rf;
    }

    /**
     * 打印错误日志并返回数据对象
     * 
     * @param msg
     * @return
     */
    public static ResultDataForm error(String msg, Object data) {
        log.error(msg);
        ResultDataForm rf = new ResultDataForm("0", msg);
        rf.setData(data);
        return rf;
    }

}
