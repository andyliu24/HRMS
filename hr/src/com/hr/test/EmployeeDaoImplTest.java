/**
 * 
 */
package com.hr.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.hr.dao.IEmployeeDao;
import com.hr.dao.impl.EmployeeDaoImpl;
import com.hr.entity.Employee;

import org.junit.Test;

/**
 * @author 11766
 *
 */
public class EmployeeDaoImplTest {
	private IEmployeeDao employee;
	
	@Test
	public void test() {
		employee = new EmployeeDaoImpl();
		List<Object> params = null;
		List<Employee> emp = employee.findEmployee(params);
		System.out.println(emp);
	} 
	@Test
	public void testEmployeeDaoImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		employee = new EmployeeDaoImpl();
		Employee empl;
		try {
			empl = new Employee("2018070503","201801","20180705","袁振华","男",sdf.parse("2018-07-10"),"119",10000,sdf.parse("2018-07-01"),sdf.parse("2018-07-05"),sdf.parse("2018-07-06"),sdf.parse("2018-07-31"));
			int i = employee.insertEmployee(empl);
			System.out.println(i);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Test
	public void testEmployeeDaoImplupdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		employee = new EmployeeDaoImpl();
		Employee empl;
		try {
			empl = new Employee("2018070503","201801","20180705","袁振华","男",sdf.parse("2018-07-10"),"119",10000,sdf.parse("2018-07-01"),sdf.parse("2018-07-05"),sdf.parse("2018-07-06"),sdf.parse("2018-07-31"));
			int i = employee.updateEmployee(empl);
			System.out.println(i);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Test
	public void testEmployeeDaoImpldelete() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		employee = new EmployeeDaoImpl();
		Employee empl;
		try {
			empl = new Employee("2018070503","201801","20180705","袁振华","男",sdf.parse("2018-07-10"),"119",10000,sdf.parse("2018-07-01"),sdf.parse("2018-07-05"),sdf.parse("2018-07-06"),sdf.parse("2018-07-31"));
			int i = employee.deleteEmployee(empl);
			System.out.println(i);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
