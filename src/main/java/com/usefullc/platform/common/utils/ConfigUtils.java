/**
 * 
 */
package com.usefullc.platform.common.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * config.propertis 工具类
 * 
 * @author tangss
 * @2013-6-25 @下午5:28:17
 */
public class ConfigUtils {

    private static Properties prop;
    static {
        // 公共模块中加载配置
        Resource resource = new ClassPathResource("config-common.properties");
        try {
            prop = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加载应用系统中的config.properties
        try {
            resource = new ClassPathResource("config.properties");
            Properties configProp = PropertiesLoaderUtils.loadProperties(resource);
            prop.putAll(configProp);
        } catch (Exception e) {
        }

    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }

    public static String getValue(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }

}
