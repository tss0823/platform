/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;

/**
 * 类ArrayUtils.java的实现描述：数组工具类
 * 
 * @author shengshang.tang 2014年4月3日 下午5:38:18
 */
public class ArrayUtils {

    /**
     * list 转 list
     * 
     * @param srcList
     * @param destCls
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static <T> List<T> listToList(List<? extends Object> srcList, Class destCls) {
        List<T> destList = new ArrayList<T>();
        if (CollectionUtils.isNotEmpty(srcList)) {
            for (Object srcObj : srcList) {
                T desetObj = BeanUtils.beanCopy(srcObj, destCls);
                destList.add(desetObj);
            }
        }
        return destList;
    }

    public static <T1, T2> List<T2> arrayToList(T1[] srcArray, Class destCls) {
        List<T2> destList = new ArrayList<T2>();
        if (!org.apache.commons.lang.ArrayUtils.isEmpty(srcArray)) {
            for (T1 srcObj : srcArray) {
                T2 desetObj = BeanUtils.beanCopy(srcObj, destCls);
                destList.add(desetObj);
            }
        }
        return destList;
    }

    /**
     * 对象集合转原是类型集合
     * 
     * @param objList
     * @param propName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T1, T2> List<T2> objListToPrimitiveList(List<T1> objList, String propName) {
        Assert.notEmpty(objList);
        List<T2> destList = new ArrayList<T2>();
        try {
            for (T1 obj : objList) {
                PropertyDescriptor propDes = PropertyUtils.getPropertyDescriptor(obj, propName);
                Method m = PropertyUtils.getReadMethod(propDes);
                Object resultValue = m.invoke(obj);
                if (resultValue != null) {
                    destList.add((T2) resultValue);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return destList;

    }

}
