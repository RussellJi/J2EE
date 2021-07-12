package com.jhh.web.servlet;

import com.jhh.dao.UserDao;
import com.jhh.domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        UserDao userDao = new UserDao();
        if(userDao.querySingle("select * from User where username=?", User.class,username)!=null){
            resp.getWriter().write("用户名存在");
        }else{
            resp.getWriter().write("用户名不存在");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
