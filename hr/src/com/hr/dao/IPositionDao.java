/**
 * 
 */
package com.hr.dao;

import java.util.List;

import com.hr.entity.Position;

/**
 * @author 11766
 *
 */
public interface IPositionDao {
	
	/**
	 *查询所有岗位信息
	 * @params params
	 * @return 岗位列表List<Position>
	 */
	public List<Position> findPosition(List<Object> params);
	
	
	/**
	 * 修改岗位信息
	 * @return 更新影响的行数
	 */
	public int updatePosition(Position pos);
	
	
	/**
	 * 删除岗位信息
	 * 
	 * @param pos
	 * @return int
	 */
	public int deletePosition(Position pos);
	
	
	/**
	 * 
	 * 插入岗位信息
	 * 
	 * @param pos
	 * @return
	 */
	public int insertPosition(Position pos);
}
