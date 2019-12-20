<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>user列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户列表 —— 显示所有用户</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/addUser.jsp">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>id</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cs}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.username}</td>
                        <td>${c.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/toUpdate.do?id=${c.id}">更改</a> |
                            <a href="${pageContext.request.contextPath}/user/delete.do?id=${c.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="text-align: center">
                <a href="?start=0">首  页</a>
                <a href="?start=${page.start-page.count}">上一页</a>
                <a href="?start=${page.start+page.count}">下一页</a>
                <a href="?start=${page.last}">末  页</a>
            </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>
