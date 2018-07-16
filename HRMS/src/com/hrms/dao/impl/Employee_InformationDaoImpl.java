/**
 * 
 */
package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.dao.IEmployee_InformationDao;
import com.hrms.entity.Employee_Information;
import com.hrms.util.BaseDao;

/**
 * @author zhoutao
 * Time:2018.7.12
 *
 */
public class Employee_InformationDaoImpl implements IEmployee_InformationDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#findEmployee_Info(java.util.List)
	 */
	@Override
	public List<Employee_Information> findEmployee_InfoALL(List<Object> params) {
		
		basedao = new BaseDao();
		//查询的sql语句
		String sql = "select * from employee_information";
		//新建List<Employee_Information>，存放Employee_Information的元素
		List<Employee_Information> infolist = new ArrayList<Employee_Information>();
		//返回的查询结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_company = rs.getString("old_company");
				String seniority = rs.getString("seniority");
				String ploitical_statue = rs.getString("master_language");
				String master_language = rs.getString("political_status");
				String whether_married = rs.getString("whether_married");
				//新建Employee_Information对象，作为List<Employee_Information>元素
				Employee_Information emp = new Employee_Information(id,old_company,seniority,master_language,ploitical_statue,whether_married);
				infolist.add(emp);
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return infolist;
	}
	

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#insertEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int insertEmployee_Info(Employee_Information info) {
		basedao = new BaseDao();
		//新建List<Object>，存放参数
		List<Object> params = new ArrayList<Object>();
		params.add(info.getId());
		params.add(info.getOld_company());
		params.add(info.getSeniority());
		params.add(info.getMaster_language());
		params.add(info.getPolitical_status());
		params.add(info.getWhether_married());
		//插入的sql语句
		String sql = "insert into employee_information values(?,?,?,?,?,?)";
		//返回插入的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#updateEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int updateEmployee_Info(Employee_Information info) {
		
		basedao = new BaseDao();
		//新建List<Object>对象，用于存放参数
		List<Object> params = new ArrayList<Object>();
		//更新的sql语句
		String sql = "update employee_information set old_company=?,seniority=?,master_language=?,political_status=?,whether_married=? where id = ?";
		params.add(info.getOld_company());
		params.add(info.getSeniority());
		params.add(info.getMaster_language());
		params.add(info.getPolitical_status());
		params.add(info.getWhether_married());
		params.add(info.getId());
		//返回更新的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	/**
	 *修改random的Employee_Information
	 * @param info
	 * @return int 
	 */
	public int updateRandomEmployee_Info(Employee_Information info) {
		
		basedao = new BaseDao();
		//标志用于表示语句末尾是否含有'name' = 'value'类型的短语
		int flag=0;
		//有待连接的sql语句
		String sql = "update employee_information set";
		//新建List<Object>，存放参数的数据
		List<Object> params = new ArrayList<Object>();
		//进行sql语句的连接判断
		if(info.getOld_company()!=null)
		{
			sql+=" old_company=?";
			params.add(info.getOld_company());
			flag=1;
		}		
		if(info.getSeniority()!=null)
		{
			if(flag==1)
			{
				sql+=",";
			}
			sql+=" seniority=?";
			params.add(info.getSeniority());
			flag=1;
		}
		if(info.getMaster_language()!=null)
		{
			if(flag==1)
			{
				sql+=",";
			}
			sql+=" Master_language=?";
			params.add(info.getMaster_language());
				
		}
		if(info.getPolitical_status()!=null)
		{
			if(flag==1)
			{
				sql+=",";
			}
			sql+=" Political_status=?";
			params.add(info.getPolitical_status());

		}
		if(info.getWhether_married()!=null)
		{
			if(flag==1)
			{
				sql+=",";
			}
			sql+=" Whether_married=?";
			params.add(info.getWhether_married());

		}
		sql+=" where id = ?";
		params.add(info.getId());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployee_InformationDao#deleteEmployee_Info(com.hr.entity.Employee_Information)
	 */
	@Override
	public int deleteEmployee_Info(Employee_Information info) {
		
		basedao = new BaseDao();
		//向参数列表里插入参数
		List<Object> params = new ArrayList<Object>();
		//删除sql语句
		String sql = "delete from employee_information where id = ?";
		params.add(info.getId());
		//返回删除的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}


	@Override
	public Employee_Information findEmployee_Info(List<Object> params) {
		
		basedao = new BaseDao();
		Employee_Information emp = new Employee_Information();
		//查询的sql语句
		String sql = "select * from employee_information where id=?";
		//新建List<Employee_Information>，存放Employee_Information的元素
		//返回的查询结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_company = rs.getString("old_company");
				String seniority = rs.getString("seniority");
				String ploitical_statue = rs.getString("master_language");
				String master_language = rs.getString("political_status");
				String whether_married = rs.getString("whether_married");
				//新建Employee_Information对象，作为List<Employee_Information>元素
				emp = new Employee_Information(id,old_company,seniority,master_language,ploitical_statue,whether_married);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return emp;
	}

}
