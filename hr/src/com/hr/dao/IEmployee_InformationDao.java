/**
 * 
 */
package com.hr.dao;

import java.util.List;

import com.hr.entity.Employee_Information;

/**
 * @author 11766
 *
 */
public interface IEmployee_InformationDao {
	
	/**
	 * 查询Employee_Information
	 * @param params
	 * @return list 
	 */
	public List<Employee_Information> findEmployee_Info(List<Object> params);
	
	
	/**
	 *插入Employee_Information
	 * @param params
	 * @return list 
	 */
	public int insertEmployee_Info(Employee_Information info);
	
	/**
	 *修改Employee_Information
	 * @param params
	 * @return list 
	 */
	public int updateEmployee_Info(Employee_Information info);
	
	/**
	 *插入Employee_Information
	 * @param params
	 * @return list 
	 */
	public int deleteEmployee_Info(Employee_Information info);
	
	
}
