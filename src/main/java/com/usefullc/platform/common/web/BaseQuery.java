/**
 * 
 */
package com.usefullc.platform.common.web;

import java.io.Serializable;

/**
 * @author tangss
 * @2013-6-24 @下午3:21:07
 */
public class BaseQuery implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private Integer           pageNum;

    /**
     * 页大小
     */
    private Integer           pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
