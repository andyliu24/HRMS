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
		String sql = "select username,password,name from userinfo";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String username = rs.getString("username");
				String name = rs.getString("name");
				String password = rs.getString("password");
				
				UserInfo user = new UserInfo(username,password,name);
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return userlist;
	}
	
	
	/**
	 * 插入用户信息
	 * @param user
	 * @return int
	 */
	public int insertUser(UserInfo user) {
		
		basedao = new BaseDao();
		String sql = "insert into userinfo values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserName());
		params.add(user.getPassword());
		params.add(user.getName());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return int
	 */
	public int updateUser(UserInfo user) {
		basedao = new BaseDao();
		String sql = "update userinfo set password=?,name=? where username = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getPassword());
		params.add(user.getName());
		params.add(user.getUserName());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * 删除用户信息
	 * @param user
	 * @return int
	 */
	public int deleteUser(UserInfo user) {
		basedao = new BaseDao();
		String sql = "delete from userinfo where username = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserName());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
}
