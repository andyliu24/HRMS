package com.hrms.servlet;

import com.hrms.dao.IPositionDao;
import com.hrms.dao.impl.PositionDaoImpl;
import com.hrms.entity.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "PositionModify")
public class PositionModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id").isEmpty()?null:request.getParameter("id");
        String name = request.getParameter("name").isEmpty()?null:request.getParameter("name");
        Position position = new Position(id,name);
        IPositionDao iPositionDao = new PositionDaoImpl();
        Integer result = iPositionDao.updatePosition(position);
        if(result == 1){
            System.out.println("岗位修改成功");
            request.setAttribute("status",result);
            request.getRequestDispatcher("position_modify.jsp").forward(request,response);
        }else{
            System.out.println("岗位修改失败");
            request.setAttribute("status",result);
            request.getRequestDispatcher("position_modify.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
