/**
 * 
 */
package com.hr.dao;

import java.util.List;

import com.hr.entity.Department_Movement;

/**
 * @author 11766
 *
 */
public interface IDepartment_MovementDao {
	
	/**
	 * 查询所有部门移动信息
	 * @param params
	 * @return list<DepartMent_Movement>
	 */
	public List<Department_Movement> findDepartment_Movement(List<Object> params);
	
	/**
	 * 插入部门移动信息
	 * @param movement
	 * @return int
	 */
	public int insertDepartment_Movement(Department_Movement movement);
	
}
