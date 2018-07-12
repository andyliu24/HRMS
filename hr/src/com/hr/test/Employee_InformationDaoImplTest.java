/**
 * 
 */
package com.hr.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hr.dao.IEmployee_InformationDao;
import com.hr.dao.impl.Employee_InformationDaoImpl;
import com.hr.entity.Employee_Information;

/**
 * @author 11766
 *
 */
public class Employee_InformationDaoImplTest {
	private IEmployee_InformationDao emplo;

	@Test
	public void test1() {
		List<Object> params = null;
		emplo = new Employee_InformationDaoImpl();
		Employee_Information info = new Employee_Information("201802","¹·Æ¨","Æ¤","masd","fds","123465");
		int i = emplo.insertEmployee_Info(info);
		System.out.println(i);
	}
	@Test
	public void test2() {
		List<Object> params = null;
		emplo = new Employee_InformationDaoImpl();
		Employee_Information info = new Employee_Information("201801","¹·Æ¨","Æ¤","masd","fds","123465");
		int i = emplo.deleteEmployee_Info(info);
		System.out.println(i);
		
	}
	
	@Test
	public void test3() {
		List<Object> params = null;
		emplo = new Employee_InformationDaoImpl();
		Employee_Information info = new Employee_Information("201801","¹·Æ¨lmx","Æ¤","masd","fds","123465");
		int i = emplo.updateEmployee_Info(info);
		System.out.println(i);
		
	}
	
	@Test
	public void test4() {
		List<Object> params = null;
		emplo = new Employee_InformationDaoImpl();
		emplo.findEmployee_Info(params);
	}
}
