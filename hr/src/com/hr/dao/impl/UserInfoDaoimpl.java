package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.IUserInfoDao;
import com.hr.entity.UserInfo;
import com.hr.util.BaseDao;

public class UserInfoDaoimpl implements IUserInfoDao {

	private BaseDao basedao;
	
	public List<UserInfo> findUser(List<Object> params) {
		basedao = new BaseDao();
		List<UserInfo> userlist = new ArrayList<UserInfo>();
		String sql = "select id,name,password from cms_admin";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				
				UserInfo user = new UserInfo(id,name,password);
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return userlist;
	}

}
