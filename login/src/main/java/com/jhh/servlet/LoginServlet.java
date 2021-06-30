package com.jhh.servlet;

import com.jhh.dao.UserDao;
import com.jhh.domain.User;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login_status")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 读取登录页面参数
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        String password = req.getParameter("password");

        //注：要将lib放到WEB-INF目录下
        UserDao userDao = new UserDao();
        if(userDao.login(username,password)!=null){
           req.getRequestDispatcher("/success").forward(req,resp);
        }else{
            req.getRequestDispatcher("/fail").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
//        UserDao userDao = new UserDao();
//        System.out.println(userDao);
    }
}
