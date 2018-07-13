package com.hrms.test;

import com.hrms.util.BaseDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDaoTest {

    private BaseDao baseDao;

    @Test
    public void getConnection() {
        baseDao=new BaseDao();
        if (baseDao.getConnection()==null){
            System.out.println("连接可能出现问题。");
        } else {
            System.out.println("数据库连接成功。");
        }
    }
}