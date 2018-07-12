package com.hr.test;

import java.util.List;

import org.junit.Test;

import com.hr.dao.IUserInfoDao;
import com.hr.dao.impl.UserInfoDaoimpl;
import com.hr.entity.UserInfo;

public class UserInfoDaoimplTest {

	private IUserInfoDao userdao;
	@Test
	public void test() {
		userdao = new UserInfoDaoimpl();
		List<Object> params = null;
		List<UserInfo> userlist = userdao.findUser(params);
		System.out.println(userlist);
	}

}
