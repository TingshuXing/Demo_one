<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>注册成功</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: red;margin-top: 350px;">注册成功，即将跳转到登陆界面</h1>
			<%
				response.setHeader("refresh","2;url='/MyProject_Demo_one/buyerView/buyerLogin.jsp'");
			%>
			<a href="/MyProject_Demo_one/buyerView/buyerLogin.jsp">如未自动跳转，请点击此处进入登陆界面!</a>
		</div>
	</head>
</html>
