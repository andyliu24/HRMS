/**
 * 
 */
package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.IDepartment_MovementDao;
import com.hrms.entity.Department_Movement;
import com.hrms.util.BaseDao;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public class Department_MovementDaoImpl implements IDepartment_MovementDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IDepartment_MovementDao#findDepart_Movement(java.util.List)
	 */
	@Override
	public List<Department_Movement> findDepartment_MovementALL(List<Object> params) {
		
		//新建List<Department_Movement>对象，用于存放Department_Movement
		List<Department_Movement> movelist = new ArrayList<Department_Movement>();
		basedao = new BaseDao();
		//查询的sql语句
		String sql = "select * from department_movement";
		//查询返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_department_id = rs.getString("old_department_id");
				String new_department_id = rs.getString("new_department_id");
				Date department_movement_date = (Date) rs.getDate("department_movement_date");
				//新建的Department_Movement对象，存放部门调动的信息
				Department_Movement move = new Department_Movement(id,old_department_id,new_department_id,department_movement_date);
				movelist.add(move);
			}
			System.out.println(movelist);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao对象
			basedao.closeConnection();
		}
		return movelist;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IDepartment_MovementDao#insertDepart_Movement(com.hr.entity.Department_Movement)
	 */
	@Override
	public int insertDepartment_Movement(Department_Movement movement) {
		
		basedao = new BaseDao();
		//插入的sql语句
		String sql = "insert into department_movement values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		//想参数列表里添加参数值
		params.add(movement.getId());
		params.add(movement.getOld_department_id());
		params.add(movement.getNew_department_id());
		params.add(movement.getDepartment_movement_date());
		//返回插入操作的影响行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	@Override
	/**
	 * 查询指定的部门调动信息
	 * @return List<Department_Movement>
	 * @params List<Object>
	 */
	public List<Department_Movement> findDepartment_Movement(String s1,String s2) {
		
		basedao = new BaseDao();
		
		Department_Movement move = new Department_Movement();
		List<Object> params = null;
		//查询的失去了语句
		List<Department_Movement>  departlist= new ArrayList<>();
		String sql = "select * from department_movement where department_movement_date between '" +s1 +"' and '" + s2 +"'";
		//查询返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_department_id = rs.getString("old_department_id");
				String new_department_id = rs.getString("new_department_id");
				Date department_movement_date = (Date) rs.getDate("department_movement_date");
				//新建的Department_Movement对象，存放部门调动的信息
				move = new Department_Movement(id,old_department_id,new_department_id,department_movement_date);
				departlist.add(move);
			}
		} catch (SQLException e) {
			
			System.out.println(e.toString());
		}finally {
			//关闭basedao对象
			basedao.closeConnection();
		}
		return departlist;
	}

}
