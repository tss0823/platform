/**
 * 
 */
package com.usefullc.platform.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * 时间工具类
 * 
 * @author tangss
 * @2013年8月31日 @下午5:46:07
 */
public class DateUtils {

    public final static String DEFAULT_FORMAT      = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 字符转时间
     * 
     * @param dateString 时间字符
     * @param format 转换格式，如果为空则默认为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getDate(String dateString, String format) {
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 时间转字符
     * 
     * @param date 时间
     * @param format 转换格式，如果为空则默认为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDate(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 时间转字符,格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @param date 时间
     * @return
     */
    public static String getDate(Date date) {
        return getDate(date, null);
    }

    /**
     * 时间转字符,格式为：yyyy-MM-dd
     * 
     * @param date 时间
     * @return
     */
    public static String getDate8(Date date) {
        return getDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 获得当前时间
     * 
     * @param format 转换格式，如果为空则默认为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurTime(String format) {
        return getDate(new Date(), format);
    }

    /**
     * 获得当前时间，格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getCurTime() {
        return getDate(new Date(), null);
    }

    /**
     * 获得当前时间，格式为：yyyy-MM-dd
     * 
     * @return
     */
    public static String getCurTime8() {
        return getDate(new Date(), DEFAULT_DATE_FORMAT);
    }

    /**
     * 获得当前时间
     * 
     * @return
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 获得两个时间差的天数
     * 
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static Long getCompareAmountDay(Date startTime, Date endTime) {
        return getCompareAmountMilliseconds(startTime, endTime) / (24 * 60 * 60 * 1000);
    }

    /**
     * 获得两个时间差的毫秒数
     * 
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static Long getCompareAmountMilliseconds(Date startTime, Date endTime) {
        Assert.notNull(startTime, "startTime not be null!");
        Assert.notNull(endTime, "endTime not be null!");
        Long milliseconds = (endTime.getTime() - startTime.getTime());
        return milliseconds;
    }

    /**
     * 时间日期格式（yyyy-MM-dd）比较
     * 
     * @param fromDate 比时间
     * @param toDate 被比时间
     * @return
     */
    public static int compare8(Date fromDate, Date toDate) {
        return getDate8(fromDate).compareTo(getDate8(toDate));
    }

}
