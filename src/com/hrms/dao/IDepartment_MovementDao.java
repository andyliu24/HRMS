/**
 * 
 */
package com.hrms.dao;

import java.util.List;

import com.hrms.entity.Department_Movement;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public interface IDepartment_MovementDao {
	
	/**
	 * 查询所有部门移动信息
	 * @param params
	 * @return list<DepartMent_Movement>
	 */
	public List<Department_Movement> findDepartment_MovementALL(List<Object> params);
	
	/**
	 * 查询指定时间部门移动信息
	 * @param params
	 * @return list<DepartMent_Movement>
	 */
	public List<Department_Movement> findDepartment_Movement(String s1,String s2);
	
	/**
	 * 插入部门移动信息
	 * @param movement
	 * @return int
	 */
	public int insertDepartment_Movement(Department_Movement movement);
	
}
