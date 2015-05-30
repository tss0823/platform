/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 类FileIoUtils.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年3月28日 上午11:31:06
 */
public class IOUtils {

    /**
     * 文件下载
     * 
     * @param path
     * @param fileName
     * @param response
     * @return
     */
    public static void download(String path, String fileName, HttpServletResponse response) {
        try {

            if (StringUtils.isEmpty(path)) {
                throw new IllegalArgumentException("下载文件的路径不能为空");
            } else {
                File file = new File(path);
                if (!file.exists()) {
                    throw new IllegalArgumentException("下载文件不合法");
                }
            }
            if (StringUtils.isEmpty(fileName)) {
                throw new IllegalArgumentException("下载文件名不能为空");
            }
            if (response == null) {
                throw new IllegalArgumentException("response 不能为空");
            }

            // path是指欲下载的文件的路径。
            File file = new File(path);

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();

            // 编码处理，对于linux 操作系统 （ linux默认 utf-8,windows 默认 GBK)
            String defaultEncoding = System.getProperty("file.encoding");
            if (defaultEncoding != null && defaultEncoding.equals("UTF-8")) {

                response.addHeader("Content-Disposition", "attachment;filename="
                                                          + new String(fileName.getBytes("GBK"), "iso-8859-1"));
            } else {
                response.addHeader("Content-Disposition", "attachment;filename="
                                                          + new String(fileName.getBytes(), "iso-8859-1"));
            }

            // 设置response的Header
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 文件下载
     * 
     * @param content
     * @param fileName
     * @param response
     */
    public static void download(byte[] content, String fileName, HttpServletResponse response) {
        try {
            // 清空response
            response.reset();

            // 编码处理，对于linux 操作系统 （ linux默认 utf-8,windows 默认 GBK)
            String defaultEncoding = System.getProperty("file.encoding");
            if (defaultEncoding != null && defaultEncoding.equals("UTF-8")) {

                response.addHeader("Content-Disposition", "attachment;filename="
                                                          + new String(fileName.getBytes("GBK"), "iso-8859-1"));
            } else {
                response.addHeader("Content-Disposition", "attachment;filename="
                                                          + new String(fileName.getBytes(), "iso-8859-1"));
            }

            // 设置response的Header
            response.addHeader("Content-Length", "" + content.length);
            response.setContentType("application/octet-stream");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(content);
            toClient.flush();
            toClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
