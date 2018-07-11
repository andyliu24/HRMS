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
			//1.ע�����ݿ�����
			Class.forName(driver);
			//2.ͨ��DriverManager��ȡ���ݿ�����
			if(conn==null||conn.isClosed())
				conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("����ע������");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("getConnection()���Ӵ���");
		}
		return conn;
	}
	
	/**
	 * ͨ�ò�ѯ����
	 * @param sql
	 * @param params
	 * @return rs��ѯ�����
	 */
	
	public ResultSet executeQuery(String sql,List<Object> params) {
		//��ȡ����
		if(getConnection()==null) {
			return null;
		}
		try {
			//����PreparedSatement����
			pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.size()>0) {
				//ѭ����ѯ����������Ϊ��ȷ�����϶�����ÿ���ֶε����ͣ��ʲ���patmt.setObject()����
				for(int i=0;i<params.size();i++) {
					pstmt.setObject(i+1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
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
	 * ͨ�ò��� ���·���
	 * @author 11766
	 * @param sql
	 * @param params
	 * @return ����ɾ��Ӱ������result
	 */
	 public int executeUpdate(String sql,List<Object> params) {
		int result = 0;
		if(getConnection()==null) {
			return -1;
		}
		try {
			//����PreparedSatement����
			pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.size()>0) {
				//ѭ����ѯ����������Ϊ��ȷ�����϶�����ÿ���ֶε����ͣ��ʲ���patmt.setObject()����
				for(int i=0;i<params.size();i++) {
					pstmt.setObject(i+1, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return result;
	}
	
}
