package com.hrms.servlet;

import com.hrms.dao.IDepartmentDao;
import com.hrms.dao.impl.DepartmentDaoImpl;
import com.hrms.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentSearch")
public class DepartmentSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");

        if (ID.equals("") || ID==null){
            IDepartmentDao departmentDao = new DepartmentDaoImpl();
            List<Department> result = departmentDao.findDepartmentALL(null);
            request.setAttribute("result",result);
            request.getRequestDispatcher("department_view.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
