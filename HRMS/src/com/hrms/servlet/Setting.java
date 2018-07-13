package com.hrms.servlet;

import com.alibaba.fastjson.JSONArray;
import com.hrms.dao.IUserInfoDao;
import com.hrms.dao.impl.UserInfoDaoimpl;
import com.hrms.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "Setting")
public class Setting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        Integer status = 0;

        String username = new String("lmx");
        String new_name;
        String old_password;
        String new_password;
        new_name = request.getParameter("new_name");
        old_password = request.getParameter("old_password");
        new_password = request.getParameter("new_password");

        IUserInfoDao userInfoDao = new UserInfoDaoimpl();
        UserInfo userInfo;

        if (old_password == null){
            userInfo = new UserInfo(username,null,new_name);
            userInfoDao.updateUser(userInfo);
            status = 0;
            request.setAttribute("status",status);
            request.getRequestDispatcher("setting.jsp").forward(request,response);
        } else {
            List<Object>user = new ArrayList<>();
            user.add(username);
            UserInfo resultUser = userInfoDao.findUser(user);
            try {
                if (old_password.equals(resultUser.getPassword())){
                    userInfo = new UserInfo(username,new_password, null);
                    userInfoDao.updateUser(userInfo);
                    status = 1;
                    request.setAttribute("status",status);
                    request.getRequestDispatcher("setting.jsp").forward(request,response);
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
