/**
 * 
 */
package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.dao.IPosition_MovementDao;
import com.hr.entity.Position_Movement;
import com.hr.util.BaseDao;

/**
 * @author 11766
 *
 */
public class Position_MovementDaoImpl implements IPosition_MovementDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IPosition_MovementDao#findPosition_Movement(java.util.List)
	 */
	public List<Position_Movement> findPosition_Movement(List<Object> params) {
		
		basedao = new BaseDao();
		List<Position_Movement> pmovement = new ArrayList<Position_Movement>();
		String sql = "select * from position_movement";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_position_id = rs.getString("old_position_id");
				String new_position_id = rs.getString("new_position_id");
				Date position_movement_date = (Date)rs.getDate("position_movement_date");
				Position_Movement pmove = new Position_Movement(id,old_position_id,new_position_id,position_movement_date);
				pmovement.add(pmove);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return pmovement;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IPosition_MovementDao#insertPosition_Movement(com.hr.entity.Position_Movement)
	 */
	public int insertPosition_Movement(Position_Movement pMovement) {
		
		basedao = new BaseDao();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into position_movement values(?,?,?,?)";
		params.add(pMovement.getId());
		params.add(pMovement.getOld_position_id());
		params.add(pMovement.getNew_position_id());
		params.add((java.sql.Date)pMovement.getPosition_movement_date());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

}
