/**
 * 
 */
package com.hr.entity;

import java.util.Date;

/**
 * @author 11766
 *
 */
public class Department_Movement {
	private String id;
	private String old_department_id;
	private String new_department_id;
	private Date department_movement_date;
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
	 * @return old_department_id
	 */
	public String getOld_department_id() {
		return old_department_id;
	}
	/**
	 * @param old_department_id 要设置的 old_department_id
	 */
	public void setOld_department_id(String old_department_id) {
		this.old_department_id = old_department_id;
	}
	/**
	 * @return new_department_id
	 */
	public String getNew_department_id() {
		return new_department_id;
	}
	/**
	 * @param new_department_id 要设置的 new_department_id
	 */
	public void setNew_department_id(String new_department_id) {
		this.new_department_id = new_department_id;
	}
	/**
	 * @return department_movement_date
	 */
	public Date getDepartment_movement_date() {
		return department_movement_date;
	}
	/**
	 * @param department_movement_date 要设置的 department_movement_date
	 */
	public void setDepartment_movement_date(Date department_movement_date) {
		this.department_movement_date = department_movement_date;
	}
	/**
	 * @param id
	 * @param old_department_id
	 * @param new_department_id
	 * @param department_movement_date
	 */
	public Department_Movement(String id, String old_department_id, String new_department_id,
			Date department_movement_date) {
		super();
		this.id = id;
		this.old_department_id = old_department_id;
		this.new_department_id = new_department_id;
		this.department_movement_date = department_movement_date;
	}
	
	
}
