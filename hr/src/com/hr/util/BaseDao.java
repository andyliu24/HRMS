package com.hr.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class BaseDao {
	String driver = ResourceBundle.getBundle("jdbc").getString("driver");
	String url = ResourceBundle.getBundle("jdbc").getString("url");
	String username = ResourceBundle.getBundle("jdbc").getString("username");
	String password = ResourceBundle.getBundle("jdbc").getString("password");
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public Connection getConnection() {
		try {
			//1.注册数据库驱动
			Class.forName(driver);
			//2.通过DriverManager获取数据库连接
			if(conn==null||conn.isClosed())
				conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("不能注册驱动");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("getConnection()连接错误");
		}
		return conn;
	}
	
	/**
	 * 通用查询方法
	 * @param sql
	 * @param params
	 * @return rs查询结果集
	 */
	
	public ResultSet executeQuery(String sql,List<Object> params) {
		//获取链接
		if(getConnection()==null) {
			return null;
		}
		try {
			//创建PreparedSatement对象
			pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.size()>0) {
				//循环查询参数集合因为不确定集合对象中每个字段的类型，故采用patmt.setObject()方法
				for(int i=0;i<params.size();i++) {
					pstmt.setObject(i+1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
		//	this.closeConnection();
		}
		return rs;
	}
	
	
	public void closeConnection() {

		try {		
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			if(pstmt!=null){
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用插入 更新方法
	 * @author 11766
	 * @param sql
	 * @param params
	 * @return 插入删除影响行数result
	 */
	 public int executeUpdate(String sql,List<Object> params) {
		int result = 0;
		if(getConnection()==null) {
			return -1;
		}
		try {
			//创建PreparedSatement对象
			pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.size()>0) {
				//循环查询参数集合因为不确定集合对象中每个字段的类型，故采用patmt.setObject()方法
				for(int i=0;i<params.size();i++) {
					pstmt.setObject(i+1, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return result;
	}
	
}
