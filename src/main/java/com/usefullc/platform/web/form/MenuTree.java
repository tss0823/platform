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
 * 类MenuTree.java的实现描述：TODO 类实现描述
 * 
 * @author shengshang.tang 2014年2月17日 下午1:14:30
 */
public class MenuTree implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            id;

    private String            code;

    private String            name;

    private String            url;

    private boolean           root;

    private boolean           leaf;

    private String            parentId;

    private List<MenuTree>    childList        = new ArrayList<MenuTree>();

    /**
     * 是否父级菜单连接【方便业务中传递参数】
     */
    private boolean           parentMenuUrl;

    /**
     * 排序
     */
    private int               orderBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<MenuTree> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuTree> childList) {
        this.childList = childList;
    }

    public void addChild(MenuTree child) {
        this.childList.add(child);
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isParentMenuUrl() {
        return parentMenuUrl;
    }

    public void setParentMenuUrl(boolean parentMenuUrl) {
        this.parentMenuUrl = parentMenuUrl;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

}
