package com.usefullc.platform.remote.authority;

import java.util.List;

import com.usefullc.platform.remote.authority.dto.DataDicDto;

/**
 * 类IUserRemoteService.java的实现描述：行政区划远程接口
 * 
 * @author shengshang.tang 2014年4月2日 上午11:15:13
 */
public interface IDataDicRemoteService {

    /**
     * 根据编码查找数据字典下级列表信息 返回多条记录
     * 
     * @param code
     * @return
     */
    List<DataDicDto> getDataDicListByParentCode(String code);

    /**
     * 根据编码查找对应的数据字典信息 返回单条记录
     * 
     * @param code
     * @return
     */
    DataDicDto getDataDicByCode(String code);

    /**
     * 根据id查找对应的数据字典信息 返回单条记录
     * 
     * @param id
     * @return
     */
    DataDicDto getDataDicById(Long id);

    /**
     * 根据父编码和当前编码查找对应的数据字典信息 返回单条记录
     * 
     * @param code
     * @return
     */
    DataDicDto getDataDicByParentMyCodeAndCode(String parentCode, String code);
}
