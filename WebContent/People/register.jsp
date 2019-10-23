<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/res/css/reg.css">
<script type="text/javascript" src="../res/js/reg.js"></script>
<script type="text/javascript" src="../res/js/tip.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<div class="main">
		<h2>注册</h2>
		<form action="/adopt-web/reg.do" method="post" id="form-reg"
			name="reg">
			<table>
				<tr>
					<td><label for="name">姓名：</label></td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td></td>
					<td><span class="tip" id="name_tip"></span></td>
				</tr>
				<tr>
					<td><label for="phone">电话：</label></td>
					<td><input type="text" name="phone" id="phone"></td>
				</tr>
				<tr>
					<td></td>
					<td><span class="tip" id="phone_tip"></span></td>
				</tr>
				<tr>
					<td><label for="email">邮件：</label></td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td></td>
					<td><span class="tip" id="email_tip"></span></td>
				</tr>
				<tr>
					<td><label for="passwd">密码：</label></td>
					<td><input type="password" name="passwd" id="passwd"></td>
				</tr>
				<tr>
					<td></td>
					<td><span class="tip" id="passwd_tip"></span></td>
				</tr>
				<tr>
					<td><label for="passwdAg">确认密码：</label></td>
					<td><input type="password" name="passwdAg" id="passwdAg"></td>
				</tr>
				<tr>
					<td></td>
					<td><span class="tip" id="passwdAg_tip"></span></td>
				</tr>
				<tr>

					<td></td>
					<td>
						<button type="submit" class="sub" id="submit">提交</button> <a href="/adopt-web/index.jsp" class="play"> <!-- <button>游客身份</button> -->
							游客身份
					</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

<script type="text/javascript">
	jQuery(function($) {
		$("body").on('submit', 'form#form-reg', function(evt) {
			var form = $(this);
			$.post(form.attr("action"), form.serialize(), function(rs) {
				if (rs != null) {
					alert(rs);
				}
			});
		});
	});
</script>
</html>