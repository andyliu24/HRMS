package com.hr.dao;

import java.util.List;

import com.hr.entity.Department;

public interface IDepartmentDao {
	
	
	
	/**
	 *查询所有部门信息
	 * @params params
	 * @return 
	 */
	public List<Department> findDepartment(List<Object> params);
	
	/**
	 * 插入部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	
	public int insertDepartment(Department depart);
	
	/**
	 * 修改部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	public int updateDepartment(Department depart);
	
	/**
	 * 删除部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	public int deleteDepartment(Department depart);
}
