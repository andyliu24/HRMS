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

//@WebServlet(name = "TrialSetting")
public class TrialSetting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Integer status = null;
        String ID = request.getParameter("id");

        Date trial_start_date = null;
        Date trial_end_date = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            trial_start_date = simpleDateFormat.parse(request.getParameter("trial_start_date"));
            trial_end_date = simpleDateFormat.parse(request.getParameter("trial_end_date"));

        } catch (ParseException e) {
            System.out.println("birthday init error!");
        }

        try {
            Employee employee = new Employee();
            employee.setId(ID);
            employee.setTrial_start_time(trial_start_date);
            employee.setTrial_end_time(trial_end_date);
            IEmployeeDao employeeDao = new EmployeeDaoImpl();
            if(employeeDao.updateRandomEmployee(employee) == 1){
                status=1;
                System.out.println("update trial date success!");
            } else {
                status=0;
                System.err.println("update failure without exception!");
            }
        }catch (Exception e){
            status=0;
            System.err.println("update failure with exception!");
            System.err.println("detail: "+e.toString());
        }

        request.setAttribute("status",status);
        request.getRequestDispatcher("trial_setting.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
