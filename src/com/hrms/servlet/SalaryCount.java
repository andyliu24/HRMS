package com.hrms.servlet;

import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.impl.EmployeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "SalaryCount")
public class SalaryCount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Integer count1 = employeeDao.findEmployeeSalary("0","5000");
        Integer count2 = employeeDao.findEmployeeSalary("5000","10000");
        Integer count3 = employeeDao.findEmployeeSalary("10000","20000");
        Integer count4 = employeeDao.findEmployeeSalary("20000","9999999999");

        request.setAttribute("count1",count1);
        request.setAttribute("count2",count2);
        request.setAttribute("count3",count3);
        request.setAttribute("count4",count4);

        request.getRequestDispatcher("report_hr_salary.jsp").forward(request,response);
    }
}
