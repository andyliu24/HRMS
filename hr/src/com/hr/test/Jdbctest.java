package com.hr.test;


import java.util.List;

import org.junit.Test;

import com.hr.util.BaseDao;

public class Jdbctest {

	@Test
	public void testgetConnection() {
		BaseDao jdbc = new BaseDao();
		if(jdbc.getConnection()==null) {
			System.out.println("���ݿ�����ʧ��");
		}else {
			System.out.println("���ݿ����ӳɹ�");
		}
	}
	@Test
	public void testexecuteUpdate() {
		BaseDao jdbc = new BaseDao();
		String sql = "update cms_admin set id = 4 where name = 'oldtwo'";
		List<Object> params = null;
		int result = jdbc.executeUpdate(sql, params);
		if(result!=-1) {
			System.out.println("�ѳɹ����£�Ӱ��" + result +"��");
		}
		else {
			System.out.println("�ѳɹ����£�Ӱ��" + result +"��");
		}
	}

}
