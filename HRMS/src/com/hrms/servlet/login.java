/**
 * 登录接口
 * @author Andy Liu
 * @time 2018.7.12
 */

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
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            List<Object> userList = new ArrayList<>();
            userList.add(username);
            IUserInfoDao userInfoDao = new UserInfoDaoimpl();
            UserInfo result = userInfoDao.findUser(userList);
            try {
                if (password.equals(result.getPassword())){
                    response.sendRedirect("index.jsp");
                } else {
                    PrintWriter out=response.getWriter();
                    out.println("wrong password!");
                }
            } catch (IndexOutOfBoundsException e){
                PrintWriter out=response.getWriter();
                out.println("username does not exist！");
            }
    }
}
