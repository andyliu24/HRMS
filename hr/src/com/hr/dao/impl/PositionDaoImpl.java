/**
 * 
 */
package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.IPositionDao;
import com.hr.entity.Position;
import com.hr.util.BaseDao;

/**
 * 对position岗位封装的类
 * @author 11766
 *
 */
public class PositionDaoImpl implements IPositionDao {
	
	private BaseDao basedao;
	/* （非 Javadoc）
	 * 查询所有岗位信息
	 * @see com.hr.dao.IPositionDao#findPosition(java.util.List)
	 */
	public List<Position> findPosition(List<Object> params) {
		// TODO 自动生成的方法存根
		basedao = new BaseDao();
		List<Position> positionlist = new ArrayList<Position>();
		String sql = "select id,name from positions";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Position pos = new Position(id,name);
				positionlist.add(pos);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
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
		String sql = "update positions set name = ? where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getName());
		params.add(pos.getId());
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
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getId());
		String sql = "delete from Positions where id = ?";
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
		List<Object> params = new ArrayList<Object>();
		params.add(pos.getId());
		params.add(pos.getName());
		String sql = "Insert into positions(id,name) values(?,?)";
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
}
