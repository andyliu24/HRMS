package com.hrms.entity;

import java.util.Date;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public class Position_Movement {
	private String id;
	private String old_position_id;
	private String new_position_id;
	private Date position_movement_date;
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return old_position_id
	 */
	public String getOld_position_id() {
		return old_position_id;
	}
	/**
	 * @param old_position_id 要设置的 old_position_id
	 */
	public void setOld_position_id(String old_position_id) {
		this.old_position_id = old_position_id;
	}
	/**
	 * @return new_position_id
	 */
	public String getNew_position_id() {
		return new_position_id;
	}
	/**
	 * @param new_position_id 要设置的 new_position_id
	 */
	public void setNew_position_id(String new_position_id) {
		this.new_position_id = new_position_id;
	}
	/**
	 * @return position_movement_date
	 */
	public Date getPosition_movement_date() {
		return position_movement_date;
	}
	/**
	 * @param position_movement_date 要设置的 position_movement_date
	 */
	public void setPosition_movement_date(Date position_movement_date) {
		this.position_movement_date = position_movement_date;
	}
	/**
	 * @param id
	 * @param old_position_id
	 * @param new_position_id
	 * @param position_movement_date
	 */
	public Position_Movement(String id, String old_position_id, String new_position_id, Date position_movement_date) {
		super();
		this.id = id;
		this.old_position_id = old_position_id;
		this.new_position_id = new_position_id;
		this.position_movement_date = position_movement_date;
	}
	
	
	
	
}
