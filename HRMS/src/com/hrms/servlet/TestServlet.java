package com.hrms.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class TestServlet extends javax.servlet.http.HttpServlet {

    //版本号，序列化和反序列化进行验证。
    private static final long serialVersionUID=1L;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init method is called.");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy method is called.");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("Hello, World!");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
