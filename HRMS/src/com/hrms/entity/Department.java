package com.hrms.entity;


/**
 * @author zhoutao
 * time:2018.7.12
 */

public class Department {
	private String id;
	private String name;
	private String manager_id;
	private String superior;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public Department(String id, String name, String manager_id, String superior) {
		super();
		this.id = id;
		this.name = name;
		this.manager_id = manager_id;
		this.superior = superior;
	}
	/**
	 * 
	 */
	public Department() {
		super();
	}
	
}
