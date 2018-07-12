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
	 * ��ѯ���в����ƶ���Ϣ
	 * @param params
	 * @return list<DepartMent_Movement>
	 */
	public List<Department_Movement> findDepartment_Movement(List<Object> params);
	
	/**
	 * ���벿���ƶ���Ϣ
	 * @param movement
	 * @return int
	 */
	public int insertDepartment_Movement(Department_Movement movement);
	
}
