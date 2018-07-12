/**
 * 
 */
package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.IEmployee_InformationDao;
import com.hr.entity.Employee_Information;
import com.hr.util.BaseDao;

/**
 * @author 11766
 *
 */
public class Employee_InformationDaoImpl implements IEmployee_InformationDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#findEmployee_Info(java.util.List)
	 */
	@Override
	public List<Employee_Information> findEmployee_Info(List<Object> params) {
		
		basedao = new BaseDao();
		String sql = "select * from employee_information";
		List<Employee_Information> infolist = new ArrayList<Employee_Information>();
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_company = rs.getString("old_company");
				String seniority = rs.getString("seniority");
				String ploitical_statue = rs.getString("master_language");
				String master_language = rs.getString("political_status");
				String whether_married = rs.getString("whether_married");
				Employee_Information emp = new Employee_Information(id,old_company,seniority,master_language,ploitical_statue,whether_married);
				infolist.add(emp);
			}
			return null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return infolist;
	}
	

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#insertEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int insertEmployee_Info(Employee_Information info) {
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		params.add(info.getId());
		params.add(info.getOld_company());
		params.add(info.getSeniority());
		params.add(info.getMaster_language());
		params.add(info.getPolitical_status());
		params.add(info.getWhether_married());
		String sql = "insert into employee_information values(?,?,?,?,?,?)";
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#updateEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int updateEmployee_Info(Employee_Information info) {
		
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		String sql = "update employee_information set old_company=?,seniority=?,master_language=?,political_status=?,whether_married=? where id = ?";
		params.add(info.getOld_company());
		params.add(info.getSeniority());
		params.add(info.getMaster_language());
		params.add(info.getPolitical_status());
		params.add(info.getWhether_married());
		params.add(info.getId());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#deleteEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int deleteEmployee_Info(Employee_Information info) {
		
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		String sql = "delete from employee_information where id = ?";
		params.add(info.getId());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

}
