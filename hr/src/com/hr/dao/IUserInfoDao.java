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
}
