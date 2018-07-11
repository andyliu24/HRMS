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
	 *��ѯ���и�λ��Ϣ
	 * @params params
	 * @return ��λ�б�List<Position>
	 */
	public List<Position> findPosition(List<Object> params);
	
	
	/**
	 * �޸ĸ�λ��Ϣ
	 * @return ����Ӱ�������
	 */
	public int updatePosition(Position pos);
	
	
	/**
	 * ɾ����λ��Ϣ
	 * 
	 * @param pos
	 * @return int
	 */
	public int deletePosition(Position pos);
	
	
	/**
	 * 
	 * �����λ��Ϣ
	 * 
	 * @param pos
	 * @return
	 */
	public int insertPosition(Position pos);
}
