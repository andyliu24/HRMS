package com.hr.dao;

import java.util.List;

import com.hr.entity.Department;

public interface IDepartmentDao {
	
	
	
	/**
	 *��ѯ���в�����Ϣ
	 * @params params
	 * @return 
	 */
	public List<Department> findDepartment(List<Object> params);
	
	/**
	 * ���벿����Ϣ
	 * @param depart
	 * @return intӰ�������
	 */
	
	public int insertDepartment(Department depart);
	
	/**
	 * �޸Ĳ�����Ϣ
	 * @param depart
	 * @return intӰ�������
	 */
	public int updateDepartment(Department depart);
	
	/**
	 * ɾ��������Ϣ
	 * @param depart
	 * @return intӰ�������
	 */
	public int deleteDepartment(Department depart);
}
