/**
 * 
 */
package com.usefullc.platform.common.enums;

/**
 * 数据删除状态（0：已删除；1：未删除）
 * @author tangss
 *
 * @2013年9月6日 @下午4:22:25
 */
public enum DataStateEnum {

	DEL(false),NOT_DEL(true);
	
	private Boolean value;
	
	private DataStateEnum(Boolean value){
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	
}
