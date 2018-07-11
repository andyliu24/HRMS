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
	 *��ѯ����Ա����Ϣ
	 * @params params
	 * @return listԱ���б�
	 */

	public List<Employee> findEmployee(List<Object> params);
	
	/**
	 * ����Ա����Ϣ
	 * @param Ա����Ϣemployee
	 * @return int����Ӱ�������
	 */
	public int insertEmployee(Employee employee);
	
	
	
	/**
	 * �޸�Ա����Ϣ
	 * @param employee
	 * @return int�޸�Ӱ�������
	 */
	public int updateEmployee(Employee employee);
	
	
	/**
	 * ɾ��Ա����Ϣ
	 * @param employee
	 * @return intɾ��Ӱ�������
	 */
	public int deleteEmployee(Employee employee);
}
