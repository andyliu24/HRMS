/**
 * 
 */
package com.hr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.dao.IDepartment_MovementDao;
import com.hr.entity.Department_Movement;
import com.hr.util.BaseDao;

/**
 * @author 11766
 *
 */
public class Department_MovementDaoImpl implements IDepartment_MovementDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IDepartment_MovementDao#findDepart_Movement(java.util.List)
	 */
	@Override
	public List<Department_Movement> findDepartment_Movement(List<Object> params) {
		
		List<Department_Movement> movelist = new ArrayList<Department_Movement>();
		basedao = new BaseDao();
		String sql = "select * from department_movement";
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
				String old_department_id = rs.getString("old_department_id");
				String new_department_id = rs.getString("new_department_id");
				Date department_movement_date = (Date) rs.getDate("department_movemnt_date");
				Department_Movement move = new Department_Movement(id,old_department_id,new_department_id,department_movement_date);
				movelist.add(move);
			}
			System.out.println(movelist);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			basedao.closeConnection();
		}
		return movelist;
	}

	/* （非 Javadoc）
	 * @see com.hr.dao.IDepartment_MovementDao#insertDepart_Movement(com.hr.entity.Department_Movement)
	 */
	@Override
	public int insertDepartment_Movement(Department_Movement movement) {

		String sql = "insert into department_movement values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(movement.getId());
		params.add(movement.getOld_department_id());
		params.add(movement.getNew_department_id());
		params.add(movement.getDepartment_movement_date());
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}

}
