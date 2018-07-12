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
	 * ��ѯ��λ������Ϣ
	 * @param params
	 * @return List<Position_Movement>
	 */
	public List<Position_Movement> findPosition_Movement(List<Object> params);
	
	/**
	 * �����λ������Ϣ
	 * @param pMovement
	 * @return int
	 */
	public int insertPosition_Movement(Position_Movement pMovement);

}
