/**
 * 
 */
package com.usefullc.platform.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usefullc.platform.common.OnlineUserManager;
import com.usefullc.platform.common.utils.ConfigUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.usefullc.platform.common.ServeltContextManager;
import com.usefullc.platform.common.dto.UserInfoDto;
import com.usefullc.platform.common.dto.UserStationInfoDto;

/**
 * @author tangss
 * @2013-6-17 @上午9:59:37
 */
public abstract class AbstractController {

    protected Logger log     = LoggerFactory.getLogger(getClass());

    protected String SUCCESS = "1";                                // 返回json成功
    protected String FAILED  = "0";                                // 失败

    /**
     * 获得 HttpServletResponse
     * 
     * @return
     */
    protected HttpServletResponse getResponse() {
        return ServeltContextManager.getResponse();
    }

    /**
     * 获得 HttpServletRequest
     * 
     * @return
     */
    protected HttpServletRequest getRequest() {
        return ServeltContextManager.getRequest();
    }

    /**
     * 获得 ServletContext
     * 
     * @return
     */
    protected ServletContext getServletContext() {
        return ServeltContextManager.getServletContext();
    }

    /**
     * 打印输出字符串
     * 
     * @param response
     * @param str
     */
    protected void write(String str) {
        str = (str == null ? "" : str);
        HttpServletResponse response = getResponse();
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            log.error("response write error!", e);
        }
    }

    protected String redirect(String url) {
        String appContext = ConfigUtils.getValue("app.context");
        String contextPath = this.getServletContext().getContextPath();
        if (StringUtils.equals(contextPath, "")) {
            url = appContext + "/" + url;
        }
        return "redirect:" + url;
    }

    /**
     * 表单校验结果
     * 
     * @param result
     * @return
     */
    protected boolean formValidAndWriteResult(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errList = result.getAllErrors();
            for (ObjectError errObj : errList) {
                log.error(errObj.getDefaultMessage() + "\n");
                // this.write(errObj.getDefaultMessage() + "\n"); TODO 待处理
            }
            return false;
        }
        return true;
    }

    /**
     * 表单校验结果
     * 
     * @param result
     * @return
     */
    protected boolean formValidResult(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errList = result.getAllErrors();
            for (ObjectError errObj : errList) {
                log.error(errObj.getDefaultMessage() + "\n");
            }
            return false;
        }
        return true;
    }

    /**
     * 写入错误日志消息
     * 
     * @param errMsg
     */
    protected void writeErrMsg(String errMsg) {
        log.error(errMsg);
        // this.write(errMsg);
    }

    /**
     * 获得用户信息
     * 
     * @return
     */
    protected UserInfoDto getUserInfo() {
        return OnlineUserManager.getUserInfo();
    }

    /**
     * 获得用户已授权站点信息
     * 
     * @return
     */
    protected List<UserStationInfoDto> getUserStationInfo() {
        return OnlineUserManager.getStationInfo();
    }    
}
