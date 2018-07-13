/**
 * 
 */
package com.hrms.dao;


import java.util.List;
import com.hrms.entity.Employee;


/**
 * @author zhoutao
 * time:2018.7.12
 */
public interface IEmployeeDao {
	/**
	 *查询所有员工信息
	 * @params params
	 * @return list员工列表
	 */

	public List<Employee> findEmployeeALL(List<Object> params);
	
	
	/**
	 *查询指定员工信息
	 * @params params
	 * @return list员工列表
	 */

	public Employee findEmployee(List<Object> params);
	
	
	/**
	 * 插入员工信息
	 * @param 员工信息employee
	 * @return int更新影响的行数
	 */
	public int insertEmployee(Employee employee);
	
	
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return int修改影响的行数
	 */
	public int updateEmployee(Employee employee);
	
	
	/**
	 * 删除员工信息
	 * @param employee
	 * @return int删除影响的行数
	 */
	public int deleteEmployee(Employee employee);
	
	
	
	
	/**
	 * 新聘员工报表查询
	 * @param params
	 * @return list
	 */
	public List<Employee> findRegisterEmployee(List<Object> params);
	
	
	/**
	 * 新聘员工报表查询
	 * @param s1
	 * @param s2
	 * @return list
	 */
	public List<Employee> findRegisterEmployee(String s1,String s2);
	
	
	/**
	 * 新聘员工报表查询
	 * @param params
	 * @return List<Employee>
	 */
	public List<Employee> findDimssionEmployee(List<Object> params);
	
	/**
	 * 新聘员工报表查询
	 * @param s1
	 * @param s2
	 * @return list
	 */
	public List<Employee> findDimssionEmployee(String s1,String s2);
	
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return int
	 */
	public int updateRandomEmployee(Employee employee);
}
