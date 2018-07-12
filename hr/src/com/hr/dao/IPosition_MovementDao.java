/**
 * 
 */
package com.hr.dao;

import java.util.List;

import com.hr.entity.Position_Movement;

/**
 * @author 11766
 *
 */
public interface IPosition_MovementDao {
	
	/**
	 * 查询岗位调动信息
	 * @param params
	 * @return List<Position_Movement>
	 */
	public List<Position_Movement> findPosition_Movement(List<Object> params);
	
	/**
	 * 插入岗位调动信息
	 * @param pMovement
	 * @return int
	 */
	public int insertPosition_Movement(Position_Movement pMovement);

}
