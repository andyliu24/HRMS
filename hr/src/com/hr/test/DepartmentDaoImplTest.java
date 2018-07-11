package com.hr.test;


import java.util.List;

import org.junit.Test;

import com.hr.dao.IDepartmentDao;
import com.hr.dao.impl.DepartmentDaoImpl;
import com.hr.entity.Department;

public class DepartmentDaoImplTest {
	private IDepartmentDao depart;

	@Test
	public void test() {
		depart = new DepartmentDaoImpl();
		List<Object> params = null;
		List<Department> departlist = depart.findDepartment(params);
		System.out.println(departlist);
	}
	@Test
	public void testinsert() {
		depart = new DepartmentDaoImpl();
		Department de = new Department("201804","后勤部","2018070501","201803");
		int i = depart.insertDepartment(de);
		System.out.println(i);
	}
	@Test
	public void testupdate() {
		depart = new DepartmentDaoImpl();
		Department de = new Department("201804","后勤部","2018070502","201803");
		int i = depart.updateDepartment(de);
		System.out.println(i);
	}
	@Test
	public void testdelete() {
		depart = new DepartmentDaoImpl();
		Department de = new Department("201804","后勤部","2018070501","201803");
		int i = depart.deleteDepartment(de);
		System.out.println(i);
	}
}
