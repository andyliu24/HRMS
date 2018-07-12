/**
 * 
 */
package com.hr.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hr.dao.IDepartment_MovementDao;
import com.hr.dao.impl.DepartmentDaoImpl;
import com.hr.dao.impl.Department_MovementDaoImpl;
import com.hr.entity.Department;
import com.hr.entity.Department_Movement;

/**
 * @author 11766
 *
 */
public class Department_MovementDaoImplTets {
	private IDepartment_MovementDao move;

	@Test
	public void test1() {
		move = new Department_MovementDaoImpl();
		List<Object> params = null;
		List<Department_Movement> movelist = move.findDepartment_Movement(params);
		System.out.println(movelist);
	}
	@Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		move = new Department_MovementDaoImpl();
		Department_Movement movement;
		try {
			movement = new Department_Movement("201804","2018070502","2018070501",sdf.parse("2018-07-03"));
			int i = move.insertDepartment_Movement(movement);
			System.out.println(i);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
