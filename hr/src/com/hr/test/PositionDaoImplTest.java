/**
 * 
 */
package com.hr.test;


import java.util.List;

import org.junit.Test;

import com.hr.dao.IPositionDao;
import com.hr.dao.impl.PositionDaoImpl;
import com.hr.entity.Position;

/**
 * @author 11766
 *
 */
public class PositionDaoImplTest {
	private IPositionDao pos;
	@Test
	public void test() {
		pos = new PositionDaoImpl();
		List<Object> params = null;
		List<Position> positionlist = pos.findPosition(params);
		System.out.println(positionlist);
	}
	@Test
	public void testPosition() {
		Position position = new Position("20180710","清洁工");
		pos = new PositionDaoImpl();
		int i = pos.insertPosition(position);
		System.out.println(i);
	}
	@Test
	public void testupdatePosition() {
		Position position = new Position("20180710","清洁工");
		pos = new PositionDaoImpl();
		int i = pos.updatePosition(position);
		System.out.println(i);
	}
}
