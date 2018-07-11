package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.IDepartmentDao;
import com.hr.entity.Department;
import com.hr.util.BaseDao;

/**
 * @author 11766
 *
 */
public class DepartmentDaoImpl implements IDepartmentDao {
	
	private BaseDao basedao;
	/**
	 * ��ѯ����
	 * 
	 */
	public List<Department> findDepartment(List<Object> params) {
		// TODO �Զ����ɵķ������
		basedao = new BaseDao();
		List<Department> departlist = new ArrayList<Department>();
		String sql = "select id,name,manager_id,superior from department";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String manager_id = rs.getString("manager_id");
				String superior = rs.getString("superior");
				Department dep = new Department(id,name,manager_id,superior);
				departlist.add(dep);
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return departlist;
	}
	
	public int insertDepartment(Department depart) {
		basedao = new BaseDao();
		String sql = "Insert into department(id,name,manager_id,superior) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(depart.getId());
		params.add(depart.getName());
		params.add(depart.getManager_id());
		params.add(depart.getSuperior());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * �޸Ĳ�����Ϣ
	 * @param depart
	 * @return intӰ�������
	 */
	public int updateDepartment(Department depart) {
		basedao = new BaseDao();
		String sql = "update department set name = ?,manager_id=?,superior=? where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(depart.getName());
		params.add(depart.getManager_id());
		params.add(depart.getSuperior());
		params.add(depart.getId());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @param depart
	 * @return intӰ�������
	 */
	public int deleteDepartment(Department depart) {
		basedao = new BaseDao();
		String sql = "delete from department where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(depart.getId());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

}
