<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/res/css/login.css">
<script type="text/javascript" src="../res/js/login.js"></script>
</head>
<body>
	<div class="main">
		<h4>登录</h4>
		<form action="/adopt-web/login.do" method="post" id="form-login">
			<p style="color: red;" id="msg">${msg }</p>
			<label for="phone">账号：</label><input type="text" name="phone" id="phone" placeholder="请输入11位电话号码"><br> 
			<label for="phone">密码：</label><input type="password" name="pwd" id="passwd" placeholder="请输入密码"> <br>
			<button type="submit" id="sub">登录</button>
			<a href="<%=basePath %>People/register.jsp" id="reg">注册</a>
		</form>
	</div>
</body>

</html>