/**
 * 
 */
package com.hr.entity;

/**
 * @author 11766
 *
 */
public class Employee_Information {
	private String id;
	private String old_company;
	private String seniority;
	private String master_language;
	private String political_status;
	private String whether_married;
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
	 * @return old_company
	 */
	public String getOld_company() {
		return old_company;
	}
	/**
	 * @param old_company 要设置的 old_company
	 */
	public void setOld_company(String old_company) {
		this.old_company = old_company;
	}
	/**
	 * @return seniority
	 */
	public String getSeniority() {
		return seniority;
	}
	/**
	 * @param seniority 要设置的 seniority
	 */
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	/**
	 * @return master_language
	 */
	public String getMaster_language() {
		return master_language;
	}
	/**
	 * @param master_language 要设置的 master_language
	 */
	public void setMaster_language(String master_language) {
		this.master_language = master_language;
	}
	/**
	 * @return political_status
	 */
	public String getPolitical_status() {
		return political_status;
	}
	/**
	 * @param political_status 要设置的 political_status
	 */
	public void setPolitical_status(String political_status) {
		this.political_status = political_status;
	}
	/**
	 * @return whether_married
	 */
	public String getWhether_married() {
		return whether_married;
	}
	/**
	 * @param whether_married 要设置的 whether_married
	 */
	public void setWhether_married(String whether_married) {
		this.whether_married = whether_married;
	}
	/**
	 * @param id
	 * @param old_company
	 * @param seniority
	 * @param master_language
	 * @param political_status
	 * @param whether_married
	 */
	public Employee_Information(String id, String old_company, String seniority, String master_language,
			String political_status, String whether_married) {
		super();
		this.id = id;
		this.old_company = old_company;
		this.seniority = seniority;
		this.master_language = master_language;
		this.political_status = political_status;
		this.whether_married = whether_married;
	}
	
	
}
