/**
 * 
 */
package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.dao.IPositionDao;
import com.hrms.entity.Position;
import com.hrms.util.BaseDao;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public class PositionDaoImpl implements IPositionDao {
	
	private BaseDao basedao;
	/* （非 Javadoc）
	 * 查询所有岗位信息
	 * @see com.hr.dao.IPositionDao#findPosition(java.util.List)
	 */
	public List<Position> findPositionALL(List<Object> params) {
		
		basedao = new BaseDao();
		//新建List<Position>对象，存放Position元素
		List<Position> positionlist = new ArrayList<Position>();
		//查询的sql语句
		String sql = "select id,name from positions";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				//新建Position对象
				Position pos = new Position(id,name);
				positionlist.add(pos);
			}
		} catch (SQLException e) {
			
			System.out.println(e.toString());
		}finally {
			//关闭basedao对象
			basedao.closeConnection();
		}
		return positionlist;
	}
	
	
	/**
	 * 修改岗位信息
	 * @param Position
	 * @return 更新影响的行数
	 */
	public int updatePosition(Position pos) {
		
		basedao = new BaseDao();
		//更新的sql语句
		String sql = "update positions set name = ? where id = ?";
		//新建List<Object>参数列表
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getName());
		params.add(pos.getId());
		//返回更新的结果条数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	/**
	 * 删除岗位信息
	 * @param pos
	 * @return int
	 */
	public int deletePosition(Position pos) {
		basedao = new BaseDao();
		//新建List<Object>参数列表
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getId());
		//删除的sql语句
		String sql = "delete from Positions where id = ?";
		//返回的删除结果条数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	/**
	 * 插入岗位信息
	 * @param pos
	 * @return
	 */
	public int insertPosition(Position pos) {
		basedao = new BaseDao();
		//新建List<Object>参数列表
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getId());
		params.add(pos.getName());
		//插入的sql语句
		String sql = "Insert into positions(id,name) values(?,?)";
		//返回的删除结果条数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}


	@Override
	public Position findPosition(List<Object> params) {
		
		basedao = new BaseDao();
		Position pos = new Position(null,null);
		//更新的sql语句
		String sql = "select id,name from positions where id=?";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				pos = new Position(id,name);//新建Position对象
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return pos;
	}
	
}
