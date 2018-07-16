package com.hrms.dao;

import java.util.List;


import com.hrms.entity.Department;

/**
 * @author zhoutao
 * time:2018.7.12
 */

public interface IDepartmentDao {
	
	
	
	/**
	 *查询所有部门信息
	 * @params params
	 * @return 
	 */
	public List<Department> findDepartmentALL(List<Object> params);
	
	
	/**
	 *查询指定部门信息
	 * @params params
	 * @return 
	 */
	public Department findDepartment(List<Object> params);
	
	
	/**
	 * 查询指定部门信息
	 * @param id
	 * @return Department
	 */
	public Department findDepartment(String id);
	
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
	 * 修改不确定的数据
	 * @param depart
	 * @return int
	 */
	public int updateRandomDepartment(Department depart);
	
	
	
	/**
	 * 删除部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	public int deleteDepartment(Department depart);
}
