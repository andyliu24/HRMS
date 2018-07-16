package com.hrms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public static final String after_login = "index.jsp";
    public static final String to_login = "login.jsp";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        request.setCharacterEncoding("utf-8");

        String currentURL = request.getRequestURI();
        String contextPath = request.getContextPath();

        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(contextPath.length());
        HttpSession session = request.getSession(false);

        //对当前页面进行判断，如果当前页面不为登录页面
        if(!("/login.jsp".equals(targetURL) || "/register.jsp".equals(targetURL))){

/*
            System.out.println("targetURL:"+targetURL);
            System.out.println("contextPath:"+contextPath);
            System.out.println("currentURL:"+currentURL);
*/

            //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
            if(session == null || session.getAttribute("username") == null){
                response.sendRedirect(to_login);
                return;
            } else {
                //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
                chain.doFilter(request, response);
                return;
            }
        } else {
            //这里表示如果当前页面是登陆页面，跳转到登陆页面
            chain.doFilter(request, response);
            return;
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
