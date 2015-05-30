/*
 * Copyright 2010-2011 ESunny.com All right reserved. This software is the confidential and proprietary information of
 * ESunny.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ESunny.com.
 */
package com.usefullc.platform.web.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类TreeFrm.java的实现描述：树对象
 * 
 * @author shengshang.tang 2013年12月11日 上午9:47:08
 */
public class TreeFrm implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long              id;

    /**
     * 业务ID
     */
    private Long              bisId;

    /**
     * 名称
     */
    private String            name;

    /**
     * 等级
     */
    private Integer           level;

    /**
     * 是否页节点
     */
    private boolean           leaf;

    /**
     * 是否根节点
     */
    private boolean           root;

    /**
     * 子节点集合
     */
    private List<TreeFrm>     childList        = new ArrayList<TreeFrm>();

    /**
     * 父ID
     */
    private Long              parentId;

    /**
     * 根ID (对于module 是systemId；对于function是moduleId)
     */
    private Long              rootId;

    /**
     * 是否展示
     */
    private boolean           display;

    /**
     * 连接
     */
    private String            url;
    
    /**
     * 行政级别
     */
    private Long              depth;
    
    /**
     * 行政区划编码
     */
    private String            code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeFrm> getChildList() {
        return childList;
    }

    public void addChild(TreeFrm treeFrm) {
        this.childList.add(treeFrm);
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public Long getBisId() {
        return bisId;
    }

    public void setBisId(Long bisId) {
        this.bisId = bisId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
