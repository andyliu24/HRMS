package com.hrms.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.dao.IUserInfoDao;
import com.hrms.entity.UserInfo;
import com.hrms.util.BaseDao;


/**
 * @author zhoutao
 * time:2018.7.12
 */
public class UserInfoDaoimpl implements IUserInfoDao {

	private BaseDao basedao;
	
	public List<UserInfo> findUserALL(List<Object> params) {
		
		basedao = new BaseDao();
		//新建List<UserInfo>，存放参数的值
		List<UserInfo> userlist = new ArrayList<UserInfo>();
		//查询的sql语句
		String sql = "select username,password,name from userinfo";
		//返回的查询结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String username = rs.getString("username");
				String name = rs.getString("name");
				String password = rs.getString("password");
				//新建userInfo对象，存放获取的用户名，密码，姓名的数据
				UserInfo user = new UserInfo(username,password,name);
				userlist.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
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
		//插入的sql语句
		String sql = "insert into userinfo values(?,?,?)";
		//新建List<Object>对象，存放数据
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserName());
		params.add(user.getPassword());
		params.add(user.getName());
		//返回的插入的结果条数
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
		//更新的sql语句
		String sql = "update userinfo set ";
		//新建List<Object>对象，用于存放数据
		List<Object> params = new ArrayList<Object>();
		int flag = 0;
		if(user.getPassword() != null && flag == 0) {
			sql = sql + "password=?";
			params.add(user.getPassword());
			flag=1;
		}
		if(user.getName() != null){
			if(flag==1) {
				sql += ",name=? ";
			}
			else {
				sql +="name=? ";
			}
			params.add(user.getName());
		}
		sql += "where username = ?";
		params.add(user.getUserName());
		//返回更新操作的结果条数
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
		//删除的sql语句
		String sql = "delete from userinfo where username = ?";
		//新建List<Object>对象，存放数据
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserName());
		//返回的删除的结果条数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}


	@Override
	public UserInfo findUser(List<Object> params) {
		
		basedao = new BaseDao();
		//新建UserInfo，用于返回信息
		UserInfo user = new UserInfo(null,null,null);
		//查询的sql语句
		String sql = "select username,password,name from userinfo where username=?";
		//返回的查询结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String username = rs.getString("username");
				String name = rs.getString("name");
				String password = rs.getString("password");
				//新建userInfo对象，存放获取的用户名，密码，姓名的数据
				user = new UserInfo(username,password,name);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return user;
	}
}
