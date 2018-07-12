package com.hr.test;

import java.util.List;

import org.junit.Test;

import com.hr.dao.IUserInfoDao;
import com.hr.dao.impl.UserInfoDaoimpl;
import com.hr.entity.UserInfo;

public class UserInfoDaoimplTest {

	private IUserInfoDao userdao;
	@Test
	public void test1() {
		userdao = new UserInfoDaoimpl();
		List<Object> params = null;
		List<UserInfo> userlist = userdao.findUser(params);
		System.out.println(userlist);
	}
	@Test
	public void test2() {
		userdao = new UserInfoDaoimpl();
		List<Object> params = null;
		UserInfo info = new UserInfo("lmx","zuishuai","123456789");
		int i = userdao.insertUser(info);
		System.out.println(i);
	}
	@Test
	public void test3() {
		userdao = new UserInfoDaoimpl();
		List<Object> params = null;
		UserInfo info = new UserInfo("lmx","zuichou","123456789");
		int i = userdao.updateUser(info);
		System.out.println(i);
	}
	@Test
	public void test4() {
		userdao = new UserInfoDaoimpl();
		List<Object> params = null;
		UserInfo info = new UserInfo("zhou","zuishuai","123456789");
		int i = userdao.deleteUser(info);
		System.out.println(i);
	}
}
