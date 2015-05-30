package com.usefullc.platform.remote.authority;

import java.util.List;

import com.usefullc.platform.remote.authority.dto.DeptInfoDto;

public interface IDeptInfoRemoteService {
    /**
     * 查找所有类型为‘公司’的机构
     * 
     * @param code   部门编号
     * @param deptType   部门类型
     * @return
     */
    List<DeptInfoDto> getDeptInfoList(String code, String deptType);
    
    /**
     * 根据部门ID查找部门信息
     * 
     * @param id   部门id
     * @return
     */
    DeptInfoDto getDeptInfo(Long id);    
}
