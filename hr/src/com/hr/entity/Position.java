/**
 * 
 */
package com.hr.entity;

/**
 * @author 11766
 *
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
	 * @param id Ҫ���õ� id
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
	 * @param name Ҫ���õ� name
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
