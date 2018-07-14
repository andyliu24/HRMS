package com.hrms.servlet;

import com.hrms.dao.IUserInfoDao;
import com.hrms.dao.impl.UserInfoDaoimpl;
import com.hrms.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "FirstRegister")
public class FirstRegister extends HttpServlet {
    Boolean isRegistered=true;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if(isRegistered){
            PrintWriter out =response.getWriter();
            out.println("初始化方法已失效！");
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        UserInfo user=new UserInfo(username,password,name);
        IUserInfoDao userInfoDao = new UserInfoDaoimpl();
        if (userInfoDao.insertUser(user)==1){
            System.out.println("success!");
            isRegistered=true;
        } else {
            System.out.println("something wrong!");
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
