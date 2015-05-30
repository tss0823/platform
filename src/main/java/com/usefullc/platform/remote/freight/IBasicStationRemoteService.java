package com.usefullc.platform.remote.freight;

import java.util.List;

import com.usefullc.platform.remote.freight.dto.BasicStationDto;


	/**
	 * 
	 * @author shengshang.tang 2014年4月2日 上午11:15:13
	 */
	public interface IBasicStationRemoteService {

	    /**
	     * 查找所有专线运输的站点
	     * 
	     * @param id
	     * @return
	     */
	    List<BasicStationDto> getBasicStationInfo();
	}
