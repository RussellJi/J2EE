<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="js/jquery-3.6.0.js"></script>
    <script>
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"/AjaxServlet",
                    type: "GET",
                    data: {"username":"纪浩瀚"},
                    success:function(data){
                        $("#p").text(data);
                    }

                });
            });
        })
    </script>
</head>
<body>
    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
    <input type="button" value="发送请求" id="btn">
    <input type="text">
    <p id="p"></p>
</body>
</html>