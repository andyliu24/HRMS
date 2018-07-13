package com.hrms.test;

import com.hrms.dao.IUserDao;
import com.hrms.dao.impl.UserDaoImpl;
import com.hrms.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private IUserDao userDao;

    @Test
    public void findAllUsers() {
        userDao=new UserDaoImpl();
        List<Object> parameters=null;
        List<User> userList=userDao.findAllUsers(parameters);

        System.out.println(userList);
    }
}