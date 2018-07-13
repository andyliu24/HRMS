/**
 * 
 */
package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.IPosition_MovementDao;
import com.hrms.entity.Position_Movement;
import com.hrms.util.BaseDao;

/**
 * @author 11766
 * time:2018.7.12
 */
public class Position_MovementDaoImpl implements IPosition_MovementDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IPosition_MovementDao#findPosition_Movement(java.util.List)
	 */
	public List<Position_Movement> findPosition_MovementALL(List<Object> params) {
		
		basedao = new BaseDao();
		//新建List<Position_Movement>对象，用于存放Position_Movement的对象
		List<Position_Movement> pmovement = new ArrayList<Position_Movement>();
		//无条件的查询sql语句
		String sql = "select * from position_movement";
		//查询的结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_position_id = rs.getString("old_position_id");
				String new_position_id = rs.getString("new_position_id");
				Date position_movement_date = (Date)rs.getDate("position_movement_date");
				//新建Position_Movement对象，作为List<Position_Movement>的元素
				Position_Movement pmove = new Position_Movement(id,old_position_id,new_position_id,position_movement_date);
				pmovement.add(pmove);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return pmovement;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IPosition_MovementDao#insertPosition_Movement(com.hr.entity.Position_Movement)
	 */
	public int insertPosition_Movement(Position_Movement pMovement) {
		
		basedao = new BaseDao();
		//新建参数的List
		List<Object> params = new ArrayList<Object>();
		///插入失去了语句
		String sql = "insert into position_movement values(?,?,?,?)";
		params.add(pMovement.getId());
		params.add(pMovement.getOld_position_id());
		params.add(pMovement.getNew_position_id());
		params.add((java.sql.Date)pMovement.getPosition_movement_date());
		//获取语句影响的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

	
	/**
	 * 查询指定的岗位移动信息
	 * @param List<Object> params
	 * @return List<Position_Movement>
	 */
	@Override
	public Position_Movement findPosition_Movement(List<Object> params) {
		
		basedao = new BaseDao();
		Position_Movement pmove = new Position_Movement(null,null,null,null);;
		//有条件的查询sql语句
		String sql = "select * from position_movement where id=? and old_position_id=? and new_position_id=? and position_movement_date=?";
		//查询的结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_position_id = rs.getString("old_position_id");
				String new_position_id = rs.getString("new_position_id");
				Date position_movement_date = (Date)rs.getDate("position_movement_date");
				//新建Position_Movement对象，作为List<Position_Movement>的元素
				pmove = new Position_Movement(id,old_position_id,new_position_id,position_movement_date);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return pmove;
	}

	
	
	
public List<Position_Movement> findPosition_Movement_Date(String s1,String s2) {
		
		basedao = new BaseDao();
		//新建List<Position_Movement>对象，用于存放Position_Movement的对象
		List<Position_Movement> pmovement = new ArrayList<Position_Movement>();
		List<Object> params = null;
		//无条件的查询sql语句
		String sql = "select * from position_movement where position_movement_date between '" + s1 + "' and '" + s2+"'";
		//查询的结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_position_id = rs.getString("old_position_id");
				String new_position_id = rs.getString("new_position_id");
				Date position_movement_date = (Date)rs.getDate("position_movement_date");
				//新建Position_Movement对象，作为List<Position_Movement>的元素
				Position_Movement pmove = new Position_Movement(id,old_position_id,new_position_id,position_movement_date);
				pmovement.add(pmove);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return pmovement;
	}
}
