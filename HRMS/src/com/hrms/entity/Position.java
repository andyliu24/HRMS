package com.hrms.entity;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public class Position {
	private String id;
	private String name;
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param id
	 * @param name
	 */
	public Position(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
