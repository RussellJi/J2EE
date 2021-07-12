<%@ page import="com.jhh.userManager.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jhh.userManager.dao.UserDao" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户管理界面</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.6.0.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.js"></script>
</head>
<body>

    <%
        //将User对象存入list数组中，并添加到request作用域中
        UserDao userDao = new UserDao();
        List<User> list = userDao.queryMulti("select * from user",User.class);
//        User jhh = new User("jhh","123456");
//        User zsm = new User("zsm","12345");
//        List<User> list = new ArrayList<>();
//        list.add(jhh);
//        list.add(zsm);
        request.setAttribute("list",list);
    %>
    <table class="table table-hover table-bordered" style="width: 600px; text-align: center" >
        <tr style="text-align: center">
            <th>用户名</th>
            <th>密码</th>
            <th colspan="2">操作</th>
        </tr>
        <tbody>
        <c:forEach items="${list}" var="user" varStatus="s">
            <tr>
                <form action="/UpdateServlet" method="post">
                    <td>
                        <input type="text" value="${user.username}" name="username" readonly="true">
                    </td>
                    <td>
                        <input type="text" value="${user.password}" name="password" >
                    </td>
                    <td>
                        <button type="submit" onclick="update(this)">修改</button>
                        <button type="submit" onclick="del(this)" >删除</button>
                    </td>
                </form>

            </tr>
        </c:forEach>
        <tr>
            <form action="/AddServlet" method="post">
                <td>
                    <input type="text" placeholder="username" name="username">
                </td>
                <td>
                    <input type="text" placeholder="password" name="password">
                </td>
                <td>
                    <button type="submit">添加一行</button>
                </td>

            </form>
        </tr>
        </tbody>
    </table>
    <script>

        //不应该把所有表格的action改掉，待解决
        var update = function(btn){
            btn.form.action='/UpdateServlet';
        }
        var del = function(btn){
            btn.form.action="/DelServlet";
        }
    </script>
</body>
</html>