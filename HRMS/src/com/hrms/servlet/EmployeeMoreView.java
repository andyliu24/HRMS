package com.hrms.servlet;

import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.IEmployee_InformationDao;
import com.hrms.dao.impl.EmployeeDaoImpl;
import com.hrms.dao.impl.Employee_InformationDaoImpl;
import com.hrms.entity.Employee;
import com.hrms.entity.Employee_Information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "EmployeeMoreView")
public class EmployeeMoreView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        List<Object> list = new ArrayList<>();
        list.add(ID);
        IEmployee_InformationDao employee_informationDao = new Employee_InformationDaoImpl();
        Employee_Information employee_information = employee_informationDao.findEmployee_Info(list);

        request.setAttribute("employee_information",employee_information);
        request.getRequestDispatcher("employee_more_view.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
