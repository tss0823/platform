package com.usefullc.platform.common.utils;

/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类FtpUtils.java的实现描述：ftp文件上传下载
 * 
 * @author shengshang.tang 2014年4月8日 上午10:51:35
 */
public class FtpUtils {

    private static final Logger log       = LoggerFactory.getLogger(FtpUtils.class);

    private static FTPClient    ftpClient = new FTPClient();

    private static String       host;

    private static int          port;

    private static String       user;

    private static String       password;

    private static String       remoteDir;

    static {
        host = ConfigUtils.getValue("ftp.host");
        String cfPort = ConfigUtils.getValue("ftp.port");
        port = Integer.valueOf(cfPort);
        user = ConfigUtils.getValue("ftp.user");
        password = ConfigUtils.getValue("ftp.password");
        remoteDir = ConfigUtils.getValue("ftp.remoteDir");
    }

    /**
     * 下载
     * 
     * @param oppositePath 相对路径
     * @param downFileName 下载文件 名
     * @return
     */
    public static InputStream download(String oppositePath, String downFileName) {
        InputStream is = null;
        try {
            // // 连接
            ftpClient.connect(host, port);

            // 登录
            ftpClient.login(user, password);

            // 检测连接是否成功
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                log.error("FTP server refused connection,host=" + host + ",user=" + user + "," + password);
                return is;
            }

            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            String sep = "/";
            String workRemoteDir = StrUtils.joinEmpty(remoteDir, sep, oppositePath);
            FTPFile[] remoteFiles = ftpClient.listFiles(workRemoteDir);
            if (remoteFiles != null) {
                for (int i = 0; i < remoteFiles.length; i++) {
                    String name = remoteFiles[i].getName();
                    if (!name.equals(downFileName)) {
                        continue;
                    }
//                    String sep = File.separator;
                    String fileName = StrUtils.joinEmpty(remoteDir, sep, oppositePath, sep, name);
                    is = ftpClient.retrieveFileStream(fileName);
                }
            }
            ftpClient.logout();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return is;
    }

    /**
     * 文件上传
     * 
     * @param oppositePath 相对路径
     * @param uploadFileName 上传文件名
     * @param is 上传流
     */
    public static void upload(String oppositePath, String uploadFileName, InputStream is) {
        try {
            // 连接
            ftpClient.connect(host, port);

            // 登录
            ftpClient.login(user, password);

            // 检测连接是否成功
            int reply = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                log.error("FTP server refused connection,host=" + host + ",user=" + user + "," + password);
                return;
            }

            String sep = "/";
            String workRemoteDir = StrUtils.joinEmpty(remoteDir, sep, oppositePath);
            // 创建目录
            try {
                int n = workRemoteDir.indexOf("/", 1);
                String subRemoteDir = null;
                while (n != -1) {
                    subRemoteDir = workRemoteDir.substring(0, n);
                    if (!ftpClient.changeWorkingDirectory(subRemoteDir)) {
                        ftpClient.makeDirectory(subRemoteDir);
                    }
                    n = workRemoteDir.indexOf("/", n + 1);
                }
                ftpClient.makeDirectory(workRemoteDir);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);

            conf.setServerLanguageCode("zh");

            // 设置上传目录
            ftpClient.changeWorkingDirectory(workRemoteDir);

            ftpClient.setBufferSize(1024);

            ftpClient.setControlEncoding("GBK");

            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            // 上传
            boolean state = ftpClient.storeFile(uploadFileName, is);

            log.debug("storeFile state = " + state);

            ftpClient.logout();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }


    /**
     * 删除文件
     * 
     * @param oppositePath 相对路径
     * @param downFileName 文件 名
     * @return
     */
    public static InputStream delete(String oppositePath, String fileName) {
        InputStream is = null;
        try {
            // // 连接
            ftpClient.connect(host, port);

            // 登录
            ftpClient.login(user, password);

            // 检测连接是否成功
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                log.error("FTP server refused connection,host=" + host + ",user=" + user + "," + password);
                return is;
            }
            
            if (fileName != null) {
                String sep = "/";

                String deleteFileName = StrUtils.joinEmpty(remoteDir, sep, oppositePath, sep, fileName);
                
                ftpClient.deleteFile(deleteFileName);

            }
            ftpClient.logout();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return is;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "E:/test/test.txt";
        File file = new File(filePath);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        upload("test/abc/", "test.txt", is);

    }

}
