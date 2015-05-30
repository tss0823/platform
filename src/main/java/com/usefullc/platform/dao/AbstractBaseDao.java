/**
 * 
 */
package com.usefullc.platform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.usefullc.platform.common.web.Pagination;

/**
 * @author tangss
 * @2013-6-17 @上午9:58:20
 */
public abstract class AbstractBaseDao {

    @Autowired
    protected SqlSession sqlSession;

    /**
     * 分页查询
     * 
     * @param queryMap
     * @param queryPageId
     * @param queryPageCountId
     * @return
     */
    public <T> Pagination<T> getPagination(Map<String, Object> queryMap, String queryPageId, String queryPageCountId) {
        Integer totalCount = sqlSession.selectOne(queryPageCountId, queryMap);
        Integer pageNum = (Integer) queryMap.get("pageNum");
        Integer pageSize = (Integer) queryMap.get("pageSize");
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 0 : pageSize;
        Pagination<T> pagination = new Pagination<T>(totalCount, pageSize, pageNum);
        queryMap.put("pageSize", pagination.getPageSize());
        queryMap.put("startRow", pagination.getStartRow());
        queryMap.put("endRow", pagination.getEndRow());
        List<T> dataList = sqlSession.selectList(queryPageId, queryMap);
        pagination.setDataList(dataList);
        return pagination;
    }

}
