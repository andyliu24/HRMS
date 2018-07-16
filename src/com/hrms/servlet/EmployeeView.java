package com.hrms.servlet;

import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.impl.EmployeeDaoImpl;
import com.hrms.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "EmployeeView")
public class EmployeeView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        List<Object> list = new ArrayList<>();
        list.add(ID);
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.findEmployee(list);

        request.setAttribute("employee",employee);
        request.getRequestDispatcher("employee_view.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
