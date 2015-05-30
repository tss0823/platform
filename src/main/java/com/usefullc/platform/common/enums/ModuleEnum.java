/**
 * 
 */
package com.usefullc.platform.common.enums;

/**
 * 模块枚举
 * 
 * @author tangss
 * @2013年9月6日 @下午4:22:25
 */
public enum ModuleEnum {

    structure("structure"), adminArea("adminArea"), dataDic("dataDic"), module("module"), role("role");

    private String value;

    private ModuleEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
