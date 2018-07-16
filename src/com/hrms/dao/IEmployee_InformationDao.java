/**
 * 
 */
package com.hrms.dao;

import java.util.List;

import com.hrms.entity.Employee_Information;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public interface IEmployee_InformationDao {
	
	/**
	 * 查询所有Employee_Information
	 * @param params
	 * @return list 
	 */
	public List<Employee_Information> findEmployee_InfoALL(List<Object> params);
	
	
	/**
	 * 查询指定Employee_Information
	 * @param params
	 * @return list 
	 */
	public Employee_Information findEmployee_Info(List<Object> params);
	
	
	
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
	 *修改random的Employee_Information
	 * @param params
	 * @return int 
	 */
	public int updateRandomEmployee_Info(Employee_Information info);
	
	/**
	 *插入Employee_Information
	 * @param params
	 * @return list 
	 */
	public int deleteEmployee_Info(Employee_Information info);
	
	
}
