package com.usefullc.platform.common.utils;

import java.io.IOException;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.codehaus.jackson.map.ObjectMapper;

import com.usefullc.platform.web.form.TreeFrm;

/**
 * JSON解析工具类,使用jackson实现
 * 
 * @author pengrg
 */
public class JsonUtil {

    public enum JSONConvertorType {
        JACKSON, JSONLIB
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将JSON字符串反序列化为java对象,除非迫不得已不使用json-lib
     * 
     * @throws IOException
     */
    public static <T> T toObj(JSONConvertorType type, String jsonStr, Class<T> clazz) {
        try {
            if (JSONConvertorType.JSONLIB.equals(type)) {
                JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonStr);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.setRootClass(clazz);
                @SuppressWarnings("unchecked")
                T obj = (T) JSONSerializer.toJava(jsonObject, jsonConfig);
                return obj;
            } else {
                return objectMapper.readValue(jsonStr, clazz);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 将JSON字符串反序列化为java对象,除非迫不得已不使用json-lib
     * 
     * @throws IOException
     */
    public static <T> T toObj(String jsonStr, Class<T> clazz) {
        return toObj(JSONConvertorType.JACKSON, jsonStr, clazz);
    }

    /**
     * 将java对象转换成json字符串, 默认使用jackson
     * 
     * @param obj
     * @return
     */
    public static String toStr(JSONConvertorType type, Object obj) {
        try {
            if (JSONConvertorType.JSONLIB.equals(type)) {
                return JSONSerializer.toJSON(obj).toString();
            } else {
                return objectMapper.writeValueAsString(obj);
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将java对象转换成json字符串, 默认使用jackson
     * 
     * @param obj
     * @return
     */
    public static String toStr(Object obj) {
        return toStr(JSONConvertorType.JACKSON, obj);
    }

    public static void main(String[] args) {
        TreeFrm treeFrm = new TreeFrm();
        treeFrm.setName("zs");
        TreeFrm childTreeFrm = new TreeFrm();
        childTreeFrm.setName("czs");
        treeFrm.addChild(childTreeFrm);
        // childTreeFrm.setParent(treeFrm); //不能设置parent,不然不能解析
        TreeFrm childTreeFrm1 = new TreeFrm();
        childTreeFrm1.setName("czs1");
        treeFrm.addChild(childTreeFrm1);
        String str = toStr(treeFrm);
        System.out.println(str);
    }

}
