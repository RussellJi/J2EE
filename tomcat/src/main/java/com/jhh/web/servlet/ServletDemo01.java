package com.jhh.web.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Date;

/*
* servlet快速入门
*
* */
//@WebServlet(urlPatterns="/demo1")
//@WebServlet(value="/demo1")
@WebServlet("/demo1")
public class ServletDemo01 implements Servlet {
    Date date = new Date();
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(date);
        System.out.println("Hello Servlet!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(date);
        System.out.println("Hello Service!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(date);
        System.out.println("Bye Servlet!");
    }
}
