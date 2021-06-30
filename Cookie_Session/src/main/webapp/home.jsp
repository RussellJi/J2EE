<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/30
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy年-MM月-dd日 HH:mm:ss");
        String time = sdf.format(date);
        time = URLEncoder.encode(time, StandardCharsets.UTF_8);
        Cookie time_cookie = new Cookie("time",time);
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("time".equals(cookie.getName())){
                    String lastTime = cookie.getValue();
                    lastTime = URLDecoder.decode(lastTime, StandardCharsets.UTF_8);
    %>
    <p>欢迎回来，上次访问时间是：<%=lastTime%></p>
    <%
                    cookie.setValue(time);
                    response.addCookie(cookie);
                }
            }
        }else {
            out.print("欢迎首次访问");
            response.addCookie(time_cookie);
        }
    %>
</body>
</html>
