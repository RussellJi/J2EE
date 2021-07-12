package com.jhh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        /*
        将js，css目录下的文件，checkCode、以及和登录有关的文件放行
        由于登录成功时，session中会有username
        查询username是否为空，若为空则未登录，重定向到登录页面
        若username不为空，放行
        */
        HttpSession session = request.getSession();
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().contains("/css/")||request.getRequestURI().contains("/js/")
                ||request.getRequestURI().contains("login")||request.getRequestURI().contains("home")
                ||request.getRequestURI().contains("checkCode")||request.getRequestURI().contains("CheckUsernameServlet")){
            System.out.println("放行");
            chain.doFilter(request, response);
        }else if(session.getAttribute("username")!=null){
            chain.doFilter(request, response);
        }else{
            response.sendRedirect("home.jsp");
        }
        System.out.println("--------------------");


    }
}
