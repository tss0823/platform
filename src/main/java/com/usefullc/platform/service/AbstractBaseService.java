/**
 * 
 */
package com.usefullc.platform.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tangss
 *
 * @2013年9月13日 @下午4:35:17
 */
public abstract class AbstractBaseService {

	@Autowired
	protected SqlSession sqlSession;
	
}
