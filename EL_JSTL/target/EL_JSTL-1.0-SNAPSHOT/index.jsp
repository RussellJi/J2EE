<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %>
    </h1>
    <br/>

    <a href="hello-servlet">Hello Servlet</a>
    <hr>
    <%-- 定义一个list，在页面中输出其内容--%>
    <h2>定义一个list，在页面中输出其内容</h2>
    <%
        List list = new ArrayList<>();
        request.setAttribute("list",list);
    %>
    <c:if test="${not empty list}">
        list
    </c:if>
    <%-- 定义一个user，在页面中输出其name、age、birthday--%>
    <%-- 定义一个map，在页面中输出其内容--%>
</body>
</html>