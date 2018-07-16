/**
 * 
 */
package com.hrms.dao;

import java.util.List;

import com.hrms.entity.Position_Movement;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public interface IPosition_MovementDao {
	
	/**
	 * 查询所有岗位调动信息
	 * @param params
	 * @return List<Position_Movement>
	 */
	public List<Position_Movement> findPosition_MovementALL(List<Object> params);
	
	/**
	 * 查询指定岗位调动信息
	 * @param params
	 * @return List<Position_Movement>
	 */
	public Position_Movement findPosition_Movement(List<Object> params);
	
	
	/**
	 * 插入岗位调动信息
	 * @param pMovement
	 * @return int
	 */
	public int insertPosition_Movement(Position_Movement pMovement);
	
	
	/**
	 * 查询指定时间岗位调动信息
	 * @param s1
	 * @param s2
	 * @return list
	 */
	public List<Position_Movement> findPosition_Movement_Date(String s1,String s2);

}
