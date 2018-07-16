package com.hrms.servlet;

import com.hrms.dao.IEmployee_InformationDao;
import com.hrms.dao.impl.Employee_InformationDaoImpl;
import com.hrms.entity.Employee_Information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "EmployeeMoreModify")
public class EmployeeMoreModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String id = request.getParameter("id");
        String old_company = request.getParameter("old_company");
        String seniority = request.getParameter("seniority");
        String master_language = request.getParameter("master_language");
        String political_status = request.getParameter("political_status");
        String whether_married = request.getParameter("whether_married");

        Employee_Information employee_information = new Employee_Information(id,old_company,seniority,master_language,political_status,whether_married);
        IEmployee_InformationDao iEmployee_informationDao = new Employee_InformationDaoImpl();
        Integer result = iEmployee_informationDao.updateRandomEmployee_Info(employee_information);

        request.setAttribute("status",result);
        request.getRequestDispatcher("employee_more_modify.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
