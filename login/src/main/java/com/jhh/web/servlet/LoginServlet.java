package com.jhh.web.servlet;

import com.jhh.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login_status")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 读取登录页面参数
        String username = req.getParameter("username");
        req.setAttribute("username", username);
        String password = req.getParameter("password");
        // 获取验证码
        HttpSession session = req.getSession();
        String checkCode_S = (String)session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        String checkCode_C = req.getParameter("checkCode");

        //注：要将lib放到WEB-INF目录下
        UserDao userDao = new UserDao();
        if(checkCode_C!=null&&checkCode_C.equalsIgnoreCase(checkCode_S)){
            if(userDao.login(username,password)!=null){
                // 重定向
                session.setAttribute("username",username);
                resp.sendRedirect("/login_success.jsp");
            }else{
                req.setAttribute("login_error","用户名或密码错误");
                // 转发
                req.getRequestDispatcher("/home.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("checkCode_error","验证码错误");
            // 转发
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

    }
}
