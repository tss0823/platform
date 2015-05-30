/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.profiler;

import org.apache.log4j.Level;

/**
 * 类ProfileTask.java的实现描述：性能统计监控任务
 * 
 * @author shengshang.tang 2014年5月19日 下午4:25:17
 */
public class ProfileTask {

    /**
     * 日志级别
     */
    private Level  level;

    /**
     * 开始时间
     */
    private Long   startTime;

    /**
     * 结束时间
     */
    private Long   endTime;

    /**
     * 开销时间
     */
    private Long   time;

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    public Long getTime() {
        time = endTime - startTime;
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
