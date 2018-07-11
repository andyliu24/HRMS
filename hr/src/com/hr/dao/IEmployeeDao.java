/**
 * 
 */
package com.hr.dao;

import java.util.List;
import com.hr.entity.Employee;

/**
 * @author 11766
 *
 */
public interface IEmployeeDao {
	/**
	 *查询所有员工信息
	 * @params params
	 * @return list员工列表
	 */

	public List<Employee> findEmployee(List<Object> params);
	
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
}
