<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>新增用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增用户</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/user/add.do"
          method="post">
        用&nbsp;&nbsp;户&nbsp;&nbsp;id：<input type="text" name="id"><br><br><br>
        用户姓名：<input type="text" name="username"><br><br><br>
        用户密码：<input type="text" name="password"><br><br><br>
        <input type="submit" value="添加" >
    </form>

</div>
</div>
</body>
</html>
