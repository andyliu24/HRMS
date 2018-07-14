
package com.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrms.dao.IEmployeeDao;
import com.hrms.entity.Employee;
import com.hrms.util.BaseDao;

/**
 * @author zhoutao
 * time:2018.7.12
 */
public class EmployeeDaoImpl implements IEmployeeDao {
	private BaseDao basedao;

	/* （非 Javadoc）
	 * @see com.hr.dao.IEmployeeDao#findDepartment(java.util.List)
	 */
	public List<Employee> findEmployeeALL(List<Object> params) {
		
		basedao = new BaseDao();
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//查询的sql语句
		String sql = "select * from employees";
		//返回的查询结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return employeeList;
	}
	
	
	/**
	 * 插入员工信息
	 * @param 员工信息employee
	 * @return int更新影响的行数
	 */
	public int insertEmployee(Employee employee) {
		basedao = new BaseDao();
		//新建List<Object>，存放参数
		List<Object> params = new ArrayList<Object>();
		params.add(employee.getId());
		params.add(employee.getDepartment_id());
		params.add(employee.getPosition_id());
		params.add(employee.getName());
		params.add(employee.getSex());
		params.add(employee.getBirthday());
		params.add(employee.getTelephone());
		params.add(employee.getSalary());
		params.add(employee.getTrial_start_time());
		params.add(employee.getTrial_end_time());
		params.add(employee.getRegister_date());
		params.add(employee.getDimission_date());
		//插入的sql语句
		String sql = "Insert into employees values(?,?,?,?,?,?,?,?,?,?,?,?)";
		//返回插入的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return int修改影响的行数
	 */
	public int updateEmployee(Employee employee) {
		basedao = new BaseDao();
		//新建List<Object>对象，用于存放参数
		List<Object> params = new ArrayList<Object>();
		//向参数列表里插入参数的值
		params.add(employee.getDepartment_id());
		params.add(employee.getPosition_id());
		params.add(employee.getName());
		params.add(employee.getSex());
		params.add(employee.getBirthday());
		params.add(employee.getTelephone());
		params.add(employee.getSalary());
		params.add(employee.getTrial_start_time());
		params.add(employee.getTrial_end_time());
		params.add(employee.getRegister_date());
		params.add(employee.getDimission_date());
		params.add(employee.getId());
		//更新的sql语句
		String sql = "update employees set department_id=?,position_id=?,name=?,sex=?,birthday=?,telephone=?,salary=?,trial_start_time=?,trial_end_time=?,register_date=?,dimission_date=? where id=?";
		//返回更新的行数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}
	
	
	/**
	 * 删除员工信息
	 * @param employee
	 * @return int删除影响的行数
	 */
	public int deleteEmployee(Employee employee) {
		basedao = new BaseDao();
		//向参数列表里插入参数
		List<Object> params = new ArrayList<Object>();
		params.add(employee.getId());
		//删除sql语句
		String sql = "delete from employees where id=?";
		//返回删除的结果条数
		int rowcount = basedao.executeUpdate(sql, params);
		return rowcount;
	}


	@Override
	public Employee findEmployee(List<Object> params) {

		basedao = new BaseDao();
		Employee empl = new Employee();
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//查询的sql语句
		String sql = "select * from employees where id=?";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return empl;
	}
	
	/**
	 * 用于报表查询生成
	 * @author zhoutao
	 * @param params,第一个参数为较小的日期，第二个参数为较大的日期
	 * @return list
	 */
	@Override
	public List<Employee> findRegisterEmployee(List<Object> params) {

		basedao = new BaseDao();
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//在某个时间段的查询sql语句
		String sql = "select * from employees where register_date >= ? and register_date <=?";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return employeeList;
	}

	@Override
	public List<Employee> findRegisterEmployee(String s1,String s2) {

		basedao = new BaseDao();
		List<Object> params = null;
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//在某个时间段的查询sql语句
		String sql = "select * from employees where register_date between '" + s1 + "' and '" + s2 +"'";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return employeeList;
	}
	
	
	@Override
	public List<Employee> findDimssionEmployee(String s1,String s2) {

		basedao = new BaseDao();
		List<Object> params = null;
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//在某个时间段的查询sql语句
		String sql = "select * from employees where dimission_date between '" + s1 + "' and '" + s2 +"'";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return employeeList;
	}
	
	
	
	public List<Employee> findDimssionEmployee(List<Object> params) {

		basedao = new BaseDao();
		//新建List<Employee>，存放Employee的元素
		List<Employee> employeeList = new ArrayList<Employee>();
		//在某个时间段的查询sql语句
		String sql = "select * from employees where dimission_date >= ? and register_date <=?";
		//查询的返回结果集
		ResultSet rs = basedao.executeQuery(sql, params);
		try {
			while(rs.next()) {
				String id = rs.getString("id");
			    String department_id = rs.getString("department_id");
				String position_id = rs.getString("position_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String telephone = rs.getString("telephone");
				String salary = rs.getString("salary");
				Date trial_start_time = (Date)rs.getDate("trial_start_time");
				Date trial_end_time = (Date)rs.getDate("trial_end_time");
				Date register_date = (Date)rs.getDate("register_date");
				Date dimission_date = (Date)rs.getDate("dimission_date");
				//新建Employee对象，作为List<Employee>元素
				Employee empl = new Employee(id,department_id,position_id,name,sex,birthday,telephone,salary,trial_start_time,trial_end_time,register_date,dimission_date);
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			//关闭basedao
			basedao.closeConnection();
		}
		return employeeList;
	}
	
	
	public int updateRandomEmployee(Employee employee) {
		basedao = new BaseDao();  //实例化basedao对象，为后面执行executeUpdate做准备
		List<Object> params = new ArrayList<Object>();  //定义并创建对象集合，为提取参数并传参做准备
		int flag=0;  //设置flag标记是否已经有过至少一个更新的内容，如果有则每次sql语句扩充前需再添加“，”，否则直接扩充需要更新的内容。
		String sql="update employees set";  //基本句头，后半部分的扩充视参数的有无来确定
		if(employee.getDepartment_id()!=null)  //判断参数是否存在，如果没有则无需修改，不需扩充sql语句，此处判断Department_id参数是否存在
		{
			sql+=" department_id=?";  //扩充sql语句
			params.add(employee.getDepartment_id());  //提取传入的employee的department_id参数
			flag=1;  //已有更新，将flag置为1，后面如果再有更新扩充则需添加“，”
		}
		if(employee.getPosition_id()!=null)  //判断Position_id参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" position_id=?";  //扩充sql语句
			params.add(employee.getPosition_id());  //提取传入的employee的position_id参数
			flag=1;  //已有更新，将flag置为1.
		}
		if(employee.getName()!=null)  //判断name参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" name=?";  //扩充sql语句
			params.add(employee.getName());  //提取传入的employee的name参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getSex()!=null)  //判断sex参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}	
			sql+=" sex=?";  //扩充sql语句
			params.add(employee.getSex());  //提取传入的employee的sex参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getBirthday()!=null)  //判断birthday参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}	
			sql+=" birthday=?";  //扩充sql语句
			params.add(employee.getBirthday());  //提取传入的employee的birthday参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getTelephone()!=null)  //判断telephone参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}	
			sql+=" telephone=?";  //扩充sql语句
			params.add(employee.getTelephone());  //提取传入的employee的telephone参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getSalary()!=null)  //判断salary参数是否存在
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}	
			sql+=" salary=?";  //扩充sql语句
			params.add(employee.getSalary());  //提取传入的employee的salary参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getTrial_start_time()!=null)
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" trial_start_time=?";  //扩充sql语句
			params.add(employee.getTrial_start_time());  //提取传入的employee的trial_start_time参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getTrial_end_time()!=null)
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" trial_end_time=?";  //扩充sql语句
			params.add(employee.getTrial_end_time());  //提取传入的employee的trial_end_time参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getRegister_date()!=null)
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" register_date=?";  //扩充sql语句
			params.add(employee.getRegister_date());  //提取传入的employee的Register_date参数
			flag=1;  //已有更新，将flag置为1
		}
		if(employee.getDimission_date()!=null)
		{
			if(flag==1)  //如果前面已有更新，加上“，”隔开；
			{
				sql+=",";
			}
			sql+=" dimission_date=?";  //扩充sql语句
			params.add(employee.getDimission_date());  //提取传入的employee的dimission_date参数
			flag=1;  //已有更新，将flag置为1
		}
			//由于是where语句，因此此项必有，作为查询条件，故无需判断是否存在，也无需加逗号隔开。
			sql+=" where id=?";  //扩充sql语句
			params.add(employee.getId());  //提取传入的employee的id参数
		int rowcount = basedao.executeUpdate(sql, params);  //定义所影响的行数，并执行更新语句
		return rowcount;  //返回所影响的行数
	}

	
	
}
