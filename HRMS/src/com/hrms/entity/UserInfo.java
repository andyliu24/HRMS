package com.hrms.entity;


/**
 * @author zhoutao
 * time:2018.7.12
 */

public class UserInfo {

	private String username;
	private String name;
	private String password;
	
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo(String username, String password, String name) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
	}
	
}
