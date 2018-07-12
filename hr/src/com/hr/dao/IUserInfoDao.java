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
	
	/**
	 * 插入用户信息
	 * @param user
	 * @return int
	 */
	public int insertUser(UserInfo user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return int
	 */
	public int updateUser(UserInfo user);
	
	/**
	 * 删除用户信息
	 * @param user
	 * @return int
	 */
	public int deleteUser(UserInfo user);
}
