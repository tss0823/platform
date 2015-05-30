package com.usefullc.platform.remote.dc;


/**
 * 
 * @author shengshang.tang 2014年4月2日 上午11:15:13
 */
public interface ICpBasicInfoRemoteService {

    /**
     * 根据企业名称，获取企业id
     * 
     * @param id
     * @return
     */
    Long getCompanyIdByCompanyName(String companyName);
}
