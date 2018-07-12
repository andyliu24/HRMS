package com.hr.dao;

import java.util.List;

import com.hr.entity.UserInfo;

public interface IUserInfoDao {
	
	
	/**
	 *��ѯ�����û���Ϣ
	 * @params params
	 * @return
	 */
	public List<UserInfo> findUser(List<Object> params);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return int
	 */
	public int insertUser(UserInfo user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return int
	 */
	public int updateUser(UserInfo user);
	
	/**
	 * ɾ���û���Ϣ
	 * @param user
	 * @return int
	 */
	public int deleteUser(UserInfo user);
}
