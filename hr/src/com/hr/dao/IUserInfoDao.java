package com.hr.dao;

import java.util.List;

import com.hr.entity.UserInfo;

public interface IUserInfoDao {
	
	
	/**
	 *查询所有用户信息
	 * @params params
	 * @return
	 */
	public List<UserInfo> findUser(List<Object> params);
}
