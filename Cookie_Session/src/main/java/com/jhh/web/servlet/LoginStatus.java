package com.jhh.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginStatus")
public class LoginStatus extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkCode_C = req.getParameter("checkCode");
        System.out.println("客户端："+checkCode_C);
        HttpSession session = req.getSession();
        String checkCode_S = (String)session.getAttribute("checkCode");
        System.out.println("服务器："+checkCode_S);
        resp.setContentType("text/html;charset=utf-8");
        if(checkCode_S.equals(checkCode_C)){
            resp.getWriter().write("验证码正确");
        }else{
            resp.getWriter().write("验证码错误");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
