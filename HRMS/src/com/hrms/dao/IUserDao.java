package com.hrms.dao;

import com.hrms.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户信息（无条件查询）
     * @author Andy Liu
     * @time 2018-07-09 15:09
     * @param parameters
     * @return List<User>
     */
    public List<User> findAllUsers(List<Object> parameters);

}
