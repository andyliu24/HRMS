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

public class entry extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Integer status = null;
        String ID = request.getParameter("id");
        String departmentID = request.getParameter("department_id");
        String positionID = request.getParameter("position_id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");
        String salary = request.getParameter("salary");
        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            System.out.println("birthday init error!");
        }

        try {
            Employee employee = new Employee(ID,departmentID,positionID,name,gender,birthday,telephone,salary,null,null,null,null);
            IEmployeeDao employeeDao = new EmployeeDaoImpl();
            if(employeeDao.insertEmployee(employee) == 1){
                status=1;
                System.out.println("insert success!");
            } else {
                status=0;
                System.out.println("insert failure without exception!");
            }
        }catch (Exception e){
            status=0;
            System.out.println("insert failure with exception!");
            System.out.println("detail: "+e.toString());
        }

        request.setAttribute("status",status);
        request.getRequestDispatcher("entry.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
