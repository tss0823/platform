/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.web.form;

import java.io.Serializable;

/**
 * 类ResultForm.java的实现描述：返回结果数据
 * 
 * @author shengshang.tang 2014年4月16日 下午8:24:46
 */
public class ResultDataForm implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8070738505915938812L;

    /**
     * 返回状态</p> 1：成功；0：失败；2：警告
     */
    private String            result;

    private String            msg;

    /**
     * 业务数据
     */
    private Object            data;

    /**
     * @param result
     */
    public ResultDataForm(String result){
        super();
        this.result = result;
    }

    /**
     * @param result
     * @param msg
     */
    public ResultDataForm(String result, String msg){
        super();
        this.result = result;
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
