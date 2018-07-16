package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.dao.IDepartmentDao;
import com.hrms.entity.Department;
import com.hrms.util.BaseDao;

/**
 * @author zhoutao
 * Time: 2018.7.12
 */
public class DepartmentDaoImpl implements IDepartmentDao {
	
	private BaseDao basedao;
	/**
	 * 查询所有部门信息
	 * @return List<Department>
	 * @param List<Object>
	 */
	public List<Department> findDepartmentALL(List<Object> params) {
		
		basedao = new BaseDao();
		//新建List<Department>对象，用于存放Department部门信息
		List<Department> departlist = new ArrayList<Department>();
		//查询sql语句
		String sql = "select id,name,manager_id,superior from department";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String manager_id = rs.getString("manager_id");
				String superior = rs.getString("superior");
				//新建Department对象，存放查询的每条结果
				Department dep = new Department(id,name,manager_id,superior);
				//Department对象插入List<Department>中
				departlist.add(dep);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		//返回departlist
		return departlist;
	}
	
	public int insertDepartment(Department depart) {
		basedao = new BaseDao();
		//插入的sql语句
		String sql = "Insert into department(id,name,manager_id,superior) values(?,?,?,?)";
		//新建List<Object>，存放参数
		List<Object> params = new ArrayList<Object>();
		params.add(depart.getId());
		params.add(depart.getName());
		params.add(depart.getManager_id());
		params.add(depart.getSuperior());
		//返回插入的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * 修改部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	public int updateDepartment(Department depart) {
		basedao = new BaseDao();
		//更新的sql语句
		String sql = "update department set name = ?,manager_id=?,superior=? where id = ?";
		//新建List<Object>对象，用于存放参数
		List<Object> params = new ArrayList<Object>();
		params.add(depart.getName());
		params.add(depart.getManager_id());
		params.add(depart.getSuperior());
		params.add(depart.getId());
		//返回更新的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * 修改不确定的数据
	 * @author zhaoxinhao
	 * @param depart
	 * @return int
	 */
	public int updateRandomDepartment(Department depart) {
		basedao = new BaseDao(); //创建basedao对象，为后面执行executeUpdate做准备
		//设置flag标记是否已经有过至少一个更新的内容，如果有则每次sql语句扩充前需再添加“，”，否则直接扩充需要更新的内容。
		int flag=0;
		//有待连接的sql语句
		String sql = "update department set";
		//基本句头，后半部分的扩充视参数的有无来确定
		List<Object> params = new ArrayList<Object>();//定义并创建对象集合，为提取参数并传参做准备
		//进行sql语句的连接判断
		if(depart.getName()!=null&&depart.getName()!="")//判断参数是否存在，如果没有则无需修改，不需扩充sql语句，此处判断name参数是否存在
		{
			sql+=" name=?";
			params.add(depart.getName());//提取传入的depart的name参数
			flag=1;
		}		
		if(depart.getManager_id()!=null)//判断manager_id参数是否存在
		{
			if(flag==1)//如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" manager_id=?";//扩充sql语句
			params.add(depart.getManager_id());//提取传入的depart的name参数
			flag=1;//已有更新，将flag置为1，后面如果再有更新扩充则需添加“，”
		}
		if(depart.getSuperior()!=null)//判断superior参数是否存在
		{
			if(flag==1)//如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" superior=?";
			params.add(depart.getSuperior());
			//由于是最后一个可更新项，所以无需再变更flag;
		}
		//由于是where语句，故不必再添加“，”
		sql+=" where id = ?";//扩充sql语句
		params.add(depart.getId());//提取传入的depart的id参数
		int rowcount = basedao.executeUpdate(sql, params);//所影响的行数
		return rowcount;//返回所影响的行数

	}

	
	
	/**
	 * 删除部门信息
	 * @param depart
	 * @return int影响的行数
	 */
	public int deleteDepartment(Department depart) {
		basedao = new BaseDao();
		//删除sql语句
		String sql = "delete from department where id = ?";
		List<Object> params = new ArrayList<Object>();
		//向参数列表里插入参数
		params.add(depart.getId());
		//返回删除的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	@Override
	public Department findDepartment(List<Object> params) {
		
		basedao = new BaseDao();
		//新建Department对象
		Department dep = new Department();
		//查询sql语句
		String sql = "select id,name,manager_id,superior from department where id=?";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String manager_id = rs.getString("manager_id");
				String superior = rs.getString("superior");
				//新建Department对象，存放查询的每条结果
				dep = new Department(id,name,manager_id,superior);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		//返回departlist
		return dep;
	}

	@Override
	public Department findDepartment(String s1) {
		
		basedao = new BaseDao();
		//新建Department对象
		Department dep = new Department();
		List<Object> params = null;
		//查询sql语句
		String sql = "select id,name,manager_id,superior from department where id=" + s1;
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String manager_id = rs.getString("manager_id");
				String superior = rs.getString("superior");
				//新建Department对象，存放查询的每条结果
				dep = new Department(id,name,manager_id,superior);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		//返回departlist
		return dep;
	}

	
	
}
