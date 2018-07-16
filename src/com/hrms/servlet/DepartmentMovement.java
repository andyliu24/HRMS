package com.hrms.servlet;

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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(name = "DepartmentMovement")
public class DepartmentMovement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Integer result = 0;
        Integer result2 = 0;
        String id = request.getParameter("id");
        String old_department_id = request.getParameter("old_department_id");
        String new_department_id = request.getParameter("new_department_id");
        Date department_movement_date = null;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        String str = request.getParameter("department_movement_date");
        if (str.equals("")){
            result = 0;
            request.setAttribute("status",result);
            request.getRequestDispatcher("department_movement.jsp").forward(request,response);
        }
        department_movement_date = new Date(str);
//        try {
//            department_movement_date = simpleDateFormat.parse();
//        } catch (ParseException e) {
//            System.out.println("department_movement_date init error!");
//        }
        IDepartment_MovementDao iDepartment_movementDao = new Department_MovementDaoImpl();
        IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();
        Department_Movement department_movement = new Department_Movement(id,old_department_id,new_department_id,department_movement_date);
        //新建Employee对象，用于修改部门id
        Employee employee = new Employee();
        employee.setId(id);
        employee.setDepartment_id(new_department_id);
        result = iEmployeeDao.updateRandomEmployee(employee);
        if(result==1){
            result2 = iDepartment_movementDao.insertDepartment_Movement(department_movement);
            if(result2==1){
                result = 1;
            }
            else{
                result = 0;
            }
        }
        else{
            result = -1;
        }
        request.setAttribute("status",result);
        request.getRequestDispatcher("department_movement.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
