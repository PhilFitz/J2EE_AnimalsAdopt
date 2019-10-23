<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.showStar{
		font-family:"方正稚艺简体";
		width:350px;
		height:400px;
		padding:20px;
		margin:20px;
		margin-left:80px;
		border:5px solid #ccc;
	}
	img{
		width:100px;
		height: 100px;
	}
	tr td{
		padding: 10px 10px 5px 5px;
	}
	.starImg{
		border: 1px solid #B2D0E7;
	}
</style>
<div class="showStar">
<h3>星人名片</h3>
<table>
	<tr>
		<td>名字：</td>
		<td>${s.sname }</td>
	</tr>
	<tr>
		<td>年龄：</td>
		<td>${s.age }</td>
	</tr>
	<tr>
		<td>头像：</td>
		<td><img class="starImg" src="down.do?file=${s.photo }"></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td>这是一枚${s.sex == 0 ? "小公举" :"王子"}</td>
	</tr>
	<tr>
		<td>呆在：</td>
		<td>${s.address }</td>
	</tr>
	<tr>
		<td>联系电话：</td>
		<td>${s.sphone }</td>
	</tr>
	<tr>
		<td>品种：</td>
		<td>${s.breed }</td>
	</tr>
	<tr>
		<td>领养状况：</td>
		<td>
			<c:if test="${s.isAdopt == 1 }">
				已被领养
			</c:if>
			<c:if test="${s.isAdopt == 0 }">
				<a href="people/adopt.do?id=${p.id == '' ? 0 : p.id}&starId=${s.id}"  class="ajax-link">点击领养</a>
			</c:if>
		</td>
	</tr>
</table>
</div>