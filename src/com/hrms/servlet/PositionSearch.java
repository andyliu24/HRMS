package com.hrms.servlet;

import com.hrms.dao.IPositionDao;
import com.hrms.dao.impl.PositionDaoImpl;
import com.hrms.entity.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "PositionSearch")
public class PositionSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");

        IPositionDao positionDao = new PositionDaoImpl();

        if (ID==null || ID.equals("")){
            List<Position> result = positionDao.findPositionALL(null);
            request.setAttribute("result",result);
        } else {
            List<Object> parameter = new ArrayList<>();
            parameter.add(ID);
            Position result = positionDao.findPosition(parameter);
            List<Position> list = new ArrayList<>();
            list.add(result);
            request.setAttribute("result",list);
        }
        request.getRequestDispatcher("position_view.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("method").equals("more")){
            doPost(request,response);
        }
    }
}
