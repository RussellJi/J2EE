package com.jhh.web.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RememberTime")
public class RememberTime extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = df.format(date);

        System.out.println("编码前："+time);
        time = URLEncoder.encode(time,"utf-8");
        System.out.println("编码后："+time);

        Cookie cookie_time = new Cookie("time",time);
        cookie_time.setMaxAge(60);
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")){
                    String result = cookie.getValue();
                    System.out.println("解码前："+result);
                    result = URLDecoder.decode(result,"utf-8");
                    System.out.println("解码后"+result);
                    System.out.println("欢迎回来，上次访问的时间是："+result);
                    resp.getWriter().write("<p>欢迎回来，上次访问的时间为:"+result+"</p>");
                    resp.addCookie(cookie_time);
                    break;
                }
            }
        }else{
            System.out.println("欢迎首次访问！");
            resp.getWriter().write("<p>欢迎首次访问！</p>");
            resp.addCookie(cookie_time);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
