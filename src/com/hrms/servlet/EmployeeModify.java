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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(name = "EmployeeModify")
public class EmployeeModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Integer status = 0;
        String ID = request.getParameter("id").isEmpty()?null:request.getParameter("id");
        String name = request.getParameter("name").isEmpty()?null:request.getParameter("name");
        String gender = request.getParameter("gender").isEmpty()?null:request.getParameter("gender");
        String telephone = request.getParameter("telephone").isEmpty()?null:request.getParameter("telephone");
        String salary = request.getParameter("salary").isEmpty()?null:request.getParameter("salary");
        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            System.out.println("birthday init error!");
        }


        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee(ID,null,null,name,gender,birthday,telephone,salary,null,null,null,null);
        if(employeeDao.updateRandomEmployee(employee) == 1){
            status = 1;
        }

        request.setAttribute("status",status);
        request.getRequestDispatcher("employee_modify.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
