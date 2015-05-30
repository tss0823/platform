/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.profiler;

import java.util.Stack;

import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类ProfileTaskManger.java的实现描述：性能统计监控任务管理
 * 
 * @author shengshang.tang 2014年5月19日 下午4:25:25
 */
public class ProfileTaskManger {

    private final static Logger                    log             = LoggerFactory.getLogger(ProfileTaskManger.class);

    /**
     * 主任务
     */
    private static ThreadLocal<ProfileTask>        totalPtLocal    = new ThreadLocal<ProfileTask>();

    /**
     * 入栈任务
     */
    private static ThreadLocal<Stack<ProfileTask>> arrayPtInLocal  = new ThreadLocal<Stack<ProfileTask>>();

    /**
     * 出栈任务
     */
    private static ThreadLocal<Stack<ProfileTask>> arrayPtOutLocal = new ThreadLocal<Stack<ProfileTask>>();

    /**
     * 主任务开始
     * 
     * @param name
     * @param content
     */
    public static void startFirst(String name, String content) {
        ProfileTask task = new ProfileTask();
        task.setStartTime(System.currentTimeMillis());
        task.setName(name);
        task.setContent(content);
        totalPtLocal.set(task);

    }

    /**
     * 子任务开始
     * 
     * @param name
     * @param content
     */
    public static void start(String name, String content) {
        ProfileTask task = new ProfileTask();
        task.setStartTime(System.currentTimeMillis());
        task.setName(name);
        task.setContent(content);
        Stack<ProfileTask> stack = arrayPtInLocal.get();
        if (stack == null) {
            stack = new Stack<ProfileTask>();
        }
        stack.add(task);
        arrayPtInLocal.set(stack);

    }

    /**
     * 子任务结束
     * 
     * @param param
     */
    public static void end(MethodProfileParam param) {
        Stack<ProfileTask> stack = arrayPtInLocal.get();
        ProfileTask task = stack.pop();
        // 计算时间
        Long endTime = System.currentTimeMillis();
        task.setEndTime(endTime);

        // 计算级别
        Long time = task.getTime();
        if (time <= param.getInfoValve()) {
            task.setLevel(Level.INFO);
        } else if (time <= param.getWarnValve()) {
            task.setLevel(Level.WARN);
        } else if (time <= param.getErrorValve()) {
            task.setLevel(Level.ERROR);
        } else {
            task.setLevel(Level.FATAL);
        }

        // 入栈
        Stack<ProfileTask> outStatck = arrayPtOutLocal.get();
        if (outStatck == null) {
            outStatck = new Stack<ProfileTask>();
            arrayPtOutLocal.set(outStatck);
        }
        outStatck.push(task);

    }

    /**
     * 主任务结束
     * 
     * @param threshold
     */
    public static void endLast(int threshold) {
        ProfileTask task = totalPtLocal.get();
        // 计算时间
        Long endTime = System.currentTimeMillis();
        task.setEndTime(endTime);

        if (task.getTime() <= threshold) { // 没有超过检测值，则不打印
            return;
        }

        // 打印日志
        // 主任务
        StringBuilder sb = new StringBuilder();
        // sb.append("thread：" + Thread.currentThread().getName());
        sb.append("main task：");
        sb.append(task.getContent());
        sb.append(" take time(millis)[" + task.getTime() + "]");
        sb.append("\n");

        // 方法栈
        Stack<ProfileTask> outStack = arrayPtOutLocal.get();
        if (outStack == null) {
            log.info(sb.toString());
            return;
        }

        // 打印子任务日志
        while (!outStack.isEmpty()) {
            task = outStack.pop();
            sb.append("child task：[");
            sb.append(task.getLevel().toString());
            sb.append("] ");
            sb.append(task.getContent());
            sb.append(" take time(millis)[" + task.getTime() + "]");
            sb.append("\n");
        }
        log.info(sb.toString());
    }

    /**
     * 清空
     */
    public static void clear() {
        totalPtLocal.set(null);
        arrayPtInLocal.set(null);
        arrayPtOutLocal.set(null);
    }

}
