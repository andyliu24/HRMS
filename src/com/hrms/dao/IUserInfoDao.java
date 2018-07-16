package com.hrms.dao;

import java.util.List;

/**
 * @author zhoutao
 * time:2018.7.12
 */

import com.hrms.entity.UserInfo;

public interface IUserInfoDao {
	
	
	/**
	 *查询所有用户信息
	 * @params params
	 * @return
	 */
	public List<UserInfo> findUserALL(List<Object> params);
	
	
	/**
	 *查询指定用户信息
	 * @params params
	 * @return
	 */
	public UserInfo findUser(List<Object> params);
	
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
