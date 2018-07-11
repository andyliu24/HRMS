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
 * ��position��λ��װ����
 * @author 11766
 *
 */
public class PositionDaoImpl implements IPositionDao {
	
	private BaseDao basedao;
	/* ���� Javadoc��
	 * ��ѯ���и�λ��Ϣ
	 * @see com.hr.dao.IPositionDao#findPosition(java.util.List)
	 */
	public List<Position> findPosition(List<Object> params) {
		// TODO �Զ����ɵķ������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return positionlist;
	}
	
	
	/**
	 * �޸ĸ�λ��Ϣ
	 * @param Position
	 * @return ����Ӱ�������
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
	 * ɾ����λ��Ϣ
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
	 * �����λ��Ϣ
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
