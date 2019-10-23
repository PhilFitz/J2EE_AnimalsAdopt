<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WE ARE 伐木累</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css?ver=1.1">
<link rel="stylesheet" type="text/css" href="res/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="main">
		<div id="top">
			<h2 id="title1" ><a href="/adopt-web/index.jsp"> We Are Family</a></h2> 
			<ul class="login">
				<c:if test="${not empty p}">
					<li><a href="<%=basePath %>toUpdateInf.do" class="ajax-link"><i class="icon-heart-empty"></i>${p.uname}</a></li>
					<li><a href="<%=basePath %>toAddStar.do" class="ajax-link"><i class="icon-plus-sign-alt"></i> 添加</a></li>
				</c:if>
				<c:if test="${empty p}">
					<li><a href="<%=basePath %>index.do"><i class="icon-user"></i>登录</a></li>
					<li><a href="<%=basePath %>signUp.dop"><i class="icon-hand-right"></i> 注册</a></li>
				</c:if>
			</ul>
		</div>
		<div id="middle">
			<div id="left">
				<ul class="menu">
					<li><i class="icon-bell"></i><a href="dog/list.do" class="ajax-link">汪星人</a></li>
					<li><i class="icon-bell-alt"></i><a href="cat/list.do" class="ajax-link">喵星人</a></li>
					<li><i class="icon-bullhorn"></i><a href="other/list.do" class="ajax-link">其他星</a></li>
					<li><i class="icon-plane"></i><a href="yes/list.do" class="ajax-link">找到Family</a></li>
				</ul>
			</div>
			<div id="right">
				<div class="tip">
					<h4><i class=" icon-bullhorn"></i>公告</h4>
					<p>&nbsp;&nbsp;欢迎来到We Are Family 流浪动物收留网站！</p>
					<p>&nbsp;&nbsp;这里有许多星人因为种种原因正在寻找新的Family~如果你的条件允许欢迎你给他们一个新的家庭！</p>
					<p>&nbsp;&nbsp;当然你也可以在此为你的星人寻找新的家庭，添加按钮在右上角<i class="icon-external-link"></i>为了信息的真是可靠，
						您需要注册账号登录后才可完成发布消息和领养星人的操作~我们都是初衷都是为了让星人Happy，谢谢合作!</p>
					<p>&nbsp;&nbsp;如果您有什么疑问或者对网站有什么建议可以随时联系我们！</p>
					<p class="contract"><i class=" icon-envelope"></i>邮件地址：1234567890@qq.com</p>
					<p class="contract"><i class="  icon-phone"></i>电话号码：13562628870</p>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="res/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="res/js/index.js?ver=1.0"></script>
</html>