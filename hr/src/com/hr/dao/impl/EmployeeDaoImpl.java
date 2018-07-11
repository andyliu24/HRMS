/**
 * 
 */
package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.dao.IEmployeeDao;
import com.hr.entity.Employee;
import com.hr.util.BaseDao;

/**
 * @author 11766
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployeeDao#findDepartment(java.util.List)
	 */
	public List<Employee> findEmployee(List<Object> params) {
		basedao = new BaseDao();
		List<Employee> employeeList = new ArrayList<Employee>();
		String sql = "select * from employees";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				int salary = rs.getInt("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return employeeList;
	}
	
	
	/**
	 * 插入员工信息
	 * @param 员工信息employee
	 * @return int更新影响的行数
	 */
	public int insertEmployee(Employee employee) {
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		params.add(employee.getId());
		params.add(employee.getDepartment_id());
		params.add(employee.getPosition_id());
		params.add(employee.getName());
		params.add(employee.getSex());
		params.add(employee.getBirthday());
		params.add(employee.getTelephone());
		params.add(employee.getSalary());
		params.add(employee.getTrial_start_time());
		params.add(employee.getTrial_end_time());
		params.add(employee.getRegister_date());
		params.add(employee.getDimission_date());
		String sql = "Insert into employees values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return int修改影响的行数
	 */
	public int updateEmployee(Employee employee) {
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		params.add(employee.getDepartment_id());
		params.add(employee.getPosition_id());
		params.add(employee.getName());
		params.add(employee.getSex());
		params.add(employee.getBirthday());
		params.add(employee.getTelephone());
		params.add(employee.getSalary());
		params.add(employee.getTrial_start_time());
		params.add(employee.getTrial_end_time());
		params.add(employee.getRegister_date());
		params.add(employee.getDimission_date());
		params.add(employee.getId());
		String sql = "update employees set department_id=?,position_id=?,name=?,sex=?,birthday=?,telephone=?,salary=?,trial_start_time=?,trial_end_time=?,register_date=?,dimission_date=? where id=?";
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	/**
	 * 删除员工信息
	 * @param employee
	 * @return int删除影响的行数
	 */
	public int deleteEmployee(Employee employee) {
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		params.add(employee.getId());
		String sql = "delete from employees where id=?";
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

}
