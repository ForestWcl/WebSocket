<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员首页</title>
</head>
<body>
	<h3>您好，<label style="color:red;font-family: 微软雅黑;font-size:small;">${currAdmin.name }</label> ，欢迎登录系统!</h3>
	<a href="${pageContext.request.contextPath }/manage/book/mgr">图书管理</a>
</body>
</html>