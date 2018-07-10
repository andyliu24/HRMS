package com.hrms.dao.impl;

import com.hrms.dao.IUserDao;
import com.hrms.entity.User;
import com.hrms.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private BaseDao baseDao=new BaseDao();
    @Override
    public List<User> findAllUsers(List<Object> parameters) {
        List<User> userList=new ArrayList<User>();
        String SQL = "SELECT id, name, password, Description, date FROM User";
        ResultSet resultSet=baseDao.executeQuery(SQL,parameters);
        try{
            while (resultSet.next()){
                Integer ID=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String password=resultSet.getString("password");
                String description=resultSet.getString("Description");
                Date date=resultSet.getDate("date");

                User user=new User(ID, name, password, description, date);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.err.println("SQL语句处理过程中出现异常，请检查。");
            System.err.println("详细信息："+e.toString());
        }
        return userList;
    }
}
