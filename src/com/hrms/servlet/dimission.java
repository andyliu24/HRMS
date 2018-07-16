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

//@WebServlet(name = "dimission")
public class dimission extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        Integer status = null;
        String ID = request.getParameter("id");

        Date dimission_date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            dimission_date = simpleDateFormat.parse(request.getParameter("dimission_date"));
        } catch (ParseException e) {
            System.out.println("dimission_data init error!");
        }


        try {
            Employee employee = new Employee();
            employee.setId(ID);
            employee.setDismission_date(dimission_date);
            IEmployeeDao employeeDao = new EmployeeDaoImpl();
            if(employeeDao.updateRandomEmployee(employee) == 1){
                System.out.println("dimission date sets successfully.");
                status = 1;
            } else {
                System.err.println("dimission date sets unsuccessfully");
                status = 0;
            }
        }catch (Exception e){
            status=0;
            System.err.println("dimission date sets unsuccessfully with exception!");
            System.err.println("detail: "+e.toString());
        }


        request.setAttribute("status",status);
        request.getRequestDispatcher("dimission.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
