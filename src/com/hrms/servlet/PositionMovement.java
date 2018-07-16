package com.hrms.servlet;

import com.hrms.dao.IEmployeeDao;
import com.hrms.dao.IPosition_MovementDao;
import com.hrms.dao.impl.EmployeeDaoImpl;
import com.hrms.dao.impl.Position_MovementDaoImpl;
import com.hrms.entity.Employee;
import com.hrms.entity.Position_Movement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(name = "PositionMovement")
public class PositionMovement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String id = request.getParameter("id").isEmpty()?null:request.getParameter("id");
        String old_position_id = request.getParameter("old_position_id").isEmpty()?null:request.getParameter("old_position_id");
        String new_position_id = request.getParameter("new_position_id").isEmpty()?null:request.getParameter("new_position_id");

        String position_movement_date = request.getParameter("position_movement_date").isEmpty()?null:request.getParameter("position_movement_date");
        if (position_movement_date==null){
            request.setAttribute("status",0);
            request.getRequestDispatcher("position_movement.jsp").forward(request,response);
        }
        Position_Movement position_movement = new Position_Movement(id,old_position_id,new_position_id,new Date(position_movement_date));
        IPosition_MovementDao iPosition_movementDao = new Position_MovementDaoImpl();
        //新建Emloyee，更新员工岗位编号
        Employee employee = new Employee();
        employee.setId(id);
        employee.setPosition_id(new_position_id);
        IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();
        Integer result = iEmployeeDao.updateRandomEmployee(employee);
        if(result == 1){
            Integer integer = iPosition_movementDao.insertPosition_Movement(position_movement);
            if(integer == 1){
                System.out.println("岗位调动成功");
                request.setAttribute("status",result);
                request.getRequestDispatcher("position_movement.jsp").forward(request,response);
            }
            else{
                System.out.println("岗位调动失败");
                request.setAttribute("status",integer);
                request.getRequestDispatcher("position_movement.jsp").forward(request,response);
            }

        }else{
            System.out.println("岗位调动失败");
            request.setAttribute("status",result);
            request.getRequestDispatcher("position_movement.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
