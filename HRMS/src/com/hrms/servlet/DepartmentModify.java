package com.hrms.servlet;

import com.hrms.dao.IDepartmentDao;
import com.hrms.dao.impl.DepartmentDaoImpl;
import com.hrms.entity.Department;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "DepartmentModify")
public class DepartmentModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id").isEmpty()?null:request.getParameter("id");
        String name = request.getParameter("name").isEmpty()?null:request.getParameter("name");
        String manager_id = request.getParameter("manager_id").isEmpty()?null:request.getParameter("manager_id");
        String superior = request.getParameter("superior").isEmpty()?null:request.getParameter("superior");

        Department department = new Department(id,name,manager_id,superior);
        IDepartmentDao iDepartmentDao = new DepartmentDaoImpl();
        Integer result = iDepartmentDao.updateRandomDepartment(department);
        if(result == 1){
            request.setAttribute("status",result);
            request.getRequestDispatcher("department_modify.jsp").forward(request,response);
        }
        else{
            request.setAttribute("status",result);
            request.getRequestDispatcher("department_modify.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
