/**
 * 
 */
package com.usefullc.platform.common.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Bean 工具类
 * 
 * @author tangss
 * 
 * @2013-4-8 @上午10:14:03
 */
public class BeanUtils {

	private final static Logger log = LoggerFactory.getLogger(BeanUtils.class);

	/**
	 * bean 转换 Map<String,Object>
	 * 
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> beanToMap(Object bean) {
		try {
			return PropertyUtils.describe(bean);
		} catch (Exception e) {
			log.error("bean to queryMap failed! ", e);
			return null;
		}
	}
	
	/**
	 * bean 复制
	 * @param srcBean bean 源对象
	 * @param destClass 目标对象class
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static<T> T beanCopy(Object srcBean,Class destClass){
		if(srcBean == null){
			return null;
		}
		try {
			Object destObj = destClass.newInstance();
			PropertyUtils.copyProperties(destObj, srcBean);
			return (T) destObj;
		} catch (Exception e) {
			throw new RuntimeException("bean copy error! ",e);
		}
	}
	/**
	 * bean 复制
	 * @param srcBean bean 源对象
	 * @param destBean 目标对象
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void beanCopy(Object srcBean,Object destBean){
		if(srcBean == null){
			return;
		}
		try {
			PropertyUtils.copyProperties(destBean, srcBean);
		} catch (Exception e) {
			throw new RuntimeException("bean copy error! ",e);
		}
	}

	/**
	 * 对象深度复制，条件各引用对象必须实现序列化
	 * @param srcObj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static<T> T objDepthCopy(T srcObj) {
		T destObj = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(srcObj);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			destObj = (T) ois.readObject();
		} catch (Exception e) {
			log.error("depth object copy failed! ", e);
			return null;
		}
		return destObj;
	}

    public static Map<String, Object> beanToMapNotNull(Object srcBean) {
        try {
            Map<String, Object> map = PropertyUtils.describe(srcBean);
            Set<String> key = new HashSet<String>(map.keySet());
            for (String string : key) {
                if (map.get(string) == null) {
                    map.remove(string);
                }
            }
            return map;
        } catch (Exception e) {
            log.error("bean to queryMap failed! ", e);
            return null;
        }
    }
}
