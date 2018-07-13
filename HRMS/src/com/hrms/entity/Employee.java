package com.hrms.entity;

import java.util.Date;


/**
 * @author zhoutao
 * time:2018.7.12
 */

public class Employee {
	private String id;
	private String department_id;
	private String position_id;
	private String name;
	private String sex;
	private Date birthday;
	private String telephone;
	private String salary;
	private Date trial_start_time;
	private Date trial_end_time;
	private Date register_date;
	private Date dimission_date;
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
	 * @return department_id
	 */
	public String getDepartment_id() {
		return department_id;
	}
	/**
	 * @param department_id 要设置的 department_id
	 */
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	/**
	 * @return position_id
	 */
	public String getPosition_id() {
		return position_id;
	}
	/**
	 * @param position_id 要设置的 position_id
	 */
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
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
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex 要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday 要设置的 birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone 要设置的 telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary 要设置的 salary
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return trial_start_time
	 */
	public Date getTrial_start_time() {
		return trial_start_time;
	}
	/**
	 * @param trial_start_time 要设置的 trial_start_time
	 */
	public void setTrial_start_time(Date trial_start_time) {
		this.trial_start_time = trial_start_time;
	}
	/**
	 * @return trial_end_time
	 */
	public Date getTrial_end_time() {
		return trial_end_time;
	}
	/**
	 * @param trial_end_time 要设置的 trial_end_time
	 */
	public void setTrial_end_time(Date trial_end_time) {
		this.trial_end_time = trial_end_time;
	}
	/**
	 * @return register_date
	 */
	public Date getRegister_date() {
		return register_date;
	}
	/**
	 * @param register_date 要设置的 register_date
	 */
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	/**
	 * @return dismission_date
	 */
	public Date getDimission_date() {
		return dimission_date;
	}
	/**
	 * @param dismission_date 要设置的 dismission_date
	 */
	public void setDismission_date(Date dimission_date) {
		this.dimission_date = dimission_date;
	}
	/**
	 * @param id
	 * @param department_id
	 * @param position_id
	 * @param name
	 * @param sex
	 * @param birthday
	 * @param telephone
	 * @param salary
	 * @param trial_start_time
	 * @param trial_end_time
	 * @param register_date
	 * @param dismission_date
	 */
	public Employee(String id, String department_id, String position_id, String name, String sex, Date birthday,
			String telephone, String salary, Date trial_start_time, Date trial_end_time, Date register_date,
			Date dismission_date) {
		super();
		this.id = id;
		this.department_id = department_id;
		this.position_id = position_id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.salary = salary;
		this.trial_start_time = trial_start_time;
		this.trial_end_time = trial_end_time;
		this.register_date = register_date;
		this.dimission_date = dismission_date;
	}
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	
	
	
}
