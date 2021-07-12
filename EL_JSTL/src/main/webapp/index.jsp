<%@ page import="com.jhh.EL_JSTL.Domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>JSTL&&EL</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
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
        List<String> list = new ArrayList<>();
        list.add("jhh");
        list.add("zsm");
        list.add("xm");
        request.setAttribute("list",list);
    %>
    <c:if test="${not empty list}">
        ${list}
    </c:if>
    <c:forEach items="${list}" var="name" varStatus="n">
        ${name} ${n.index} ${n.count} <br>
    </c:forEach>

    <%-- 定义一个user，在页面中输出其name、age、birthday--%>
    <h2>定义一个user，在页面中输出其name、age、birthday</h2>
    <%
        User jhh = new User("jhh",new Date());
        User zsm = new User("zsm",new Date());
        List list2 = new ArrayList();
        list2.add(jhh);
        list2.add(zsm);
        request.setAttribute("user",list2);
    %>
    <br>
<%--    ${jhh.name}<br>--%>
<%--    ${jhh.date}<br>--%>
<%--    ${jhh.dateStr}<br>--%>

    <table class="table table-hover table-bordered">
        <tbody>
            <tr>
                <th>姓名</th>
                <th>出生日期</th>
            </tr>
            <c:forEach items="${user}" var="u" varStatus="s">
                <tr>
                    <td>
                            ${u.name}
                    </td>
                    <td>
                            ${u.dateStr}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <%-- 定义一个map，在页面中输出其内容--%>
    <h2>定义一个map，在页面中输出其内容</h2>
    <%
        Map map = new HashMap();
        map.put("name","jhh");
        map.put("age",23);
        request.setAttribute("map",map);
    %>
    ${map.name}<br>
    ${map["age"]}<br>

    <%-- 定义一个number,在页面输出对应的星期--%>
    <h2>定义一个number,在页面输出对应的星期</h2>
    <%
        request.setAttribute("number",3);
    %>
    <c:choose>
        <c:when test="${number==1}">星期一</c:when>
        <c:when test="${number==2}">星期二</c:when>
        <c:when test="${number==3}">星期三</c:when>
        <c:when test="${number==4}">星期四</c:when>
        <c:when test="${number==5}">星期五</c:when>
        <c:when test="${number==6}">星期六</c:when>
        <c:when test="${number==7}">星期日</c:when>
        <c:otherwise>输入有误</c:otherwise>
    </c:choose>


</body>
</html>