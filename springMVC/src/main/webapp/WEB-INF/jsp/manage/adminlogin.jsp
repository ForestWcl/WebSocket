<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><sp:message code="springmvc.adminlogin.title"/> </title>
</head>
<body>
	<h2><sp:message code="springmvc.adminlogin.topinfo"/></h2>
	<p><a href="loginForm?language=zh_CN">中文</a>|<a href="loginForm?language=en_US">English</a></p>
	<form action="${pageContext.request.contextPath }/manage/admin/loginCheck" method="POST">
		<p><sp:message code="springmvc.adminlogin.loginId"/><input type="text" name="loginId"></p>
		<p><sp:message code="springmvc.adminlogin.loginPsw"/><input type="password" name="loginPsw"></p>
		<p><input type="submit" value="<sp:message code="springmvc.adminlogin.submit"/>"> <label style="color:red;font-family: 微软雅黑;font-size:small;">${ tip }</label> </p>
	</form>
</body>
</html>