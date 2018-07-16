package com.hrms.servlet;

import com.hrms.dao.IDepartmentDao;
import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.IPositionDao;
import com.hrms.dao.impl.DepartmentDaoImpl;
import com.hrms.dao.impl.EmployeeDaoImpl;
import com.hrms.dao.impl.PositionDaoImpl;
import com.hrms.entity.Department;
import com.hrms.entity.Employee;
import com.hrms.entity.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "Main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string = request.getParameter("method");
        if (string.equals("info")){
            IEmployeeDao employeeDao = new EmployeeDaoImpl();
            List<Employee> result = employeeDao.findRegisterEmployee();
            request.setAttribute("result",result);

            IPositionDao positionDao = new PositionDaoImpl();
            List<Position> post = positionDao.findPositionALL(null);
            request.setAttribute("post",post);

            IDepartmentDao departmentDao = new DepartmentDaoImpl();
            List<Department> depart = departmentDao.findDepartmentALL(null);
            request.setAttribute("depart",depart);

            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }
}
