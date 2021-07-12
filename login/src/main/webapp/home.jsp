<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/1
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.6.0.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.js"></script>
    <style>
        .form{
            margin:100px auto;
            /*border: 3px solid aquamarine;*/
            /*padding:10px;*/
        }
    </style>
    <script>

        //验证用户名是否存在
        $(function(){
            $("#username").blur(function(){
                $.get({
                    url:"/CheckUsernameServlet",
                    data:{"username":$(this).val()},
                    success:function (data){
                        $("#sp").html(""+data);
                    }
                });
            });
        })
    </script>
</head>
<body>
    <form action = "${pageContext.request.contextPath}/login_status" method="post" style="width:400px" class="form">
        <div class="form-group" >
            <label for="username">Username</label>
            <input class="form-control" type="text" id = "username" placeholder="用户名" name="username">
            <span id="sp"></span>
        </div>
        <div class="form-group" >
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="密码" name="password">
        </div>
        <input type="text" name="checkCode" style="width:100px">
        <img src="${pageContext.request.contextPath}/checkCode">
        <a href="javascript:void(0);">看不清换一张</a>

        <br>
        <button type="submit" class="btn btn-primary" style="margin-top: 10px">登录</button>
        <br>
        ${requestScope.checkCode_error}
        ${requestScope.login_error}

    </form>

    <script>
        var img = document.getElementsByTagName("img")[0];
        img.onclick = function(){
            src = "${pageContext.request.contextPath}/checkCode";
        }
    </script>

</body>
</html>
