package com.hrms.servlet;

import com.hrms.dao.IDepartmentDao;
import com.hrms.dao.IDepartment_MovementDao;
import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.impl.Department_MovementDaoImpl;
import com.hrms.dao.impl.EmployeeDaoImpl;
import com.hrms.entity.Department_Movement;
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

//@WebServlet(name = "DepartmentMovementTable")
public class DepartmentMovementTable extends HttpServlet {
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
            request.setAttribute("dapart",null);
            request.getRequestDispatcher("report_department_movement.jsp").forward(request,response);
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String start = sdf.format(start_date);
        String end = sdf.format(end_date);

        IDepartment_MovementDao department_movementDao = new Department_MovementDaoImpl();
        List<Department_Movement> result = department_movementDao.findDepartment_Movement(start,end);

        request.setAttribute("depart",result);
        request.getRequestDispatcher("report_department_movement.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
