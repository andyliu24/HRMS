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
import java.util.List;

//@WebServlet(name = "DimissionEmployeeTable")
public class DimissionEmployeeTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date start_date = null;
        Date end_date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            start_date = simpleDateFormat.parse(request.getParameter("start_date"));
            end_date = simpleDateFormat.parse(request.getParameter("end_date"));
        } catch (ParseException e) {
            System.out.println("date init error!");
        }

        if(start_date==null || end_date==null){
            request.setAttribute("employees",null);
            request.getRequestDispatcher("report_dismiss_employee.jsp").forward(request,response);
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String start = sdf.format(start_date);
        String end = sdf.format(end_date);


        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> result = employeeDao.findDimssionEmployee(start,end);

        request.setAttribute("employees",result);
        request.getRequestDispatcher("report_dismiss_employee.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
