<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>登陆失败</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: red;margin-top: 350px;">登陆失败!请重新登陆</h1>
			<%
				response.setHeader("refresh","2;url='/MyProject_Demo_one/buyerView/buyerLogin.jsp'");
			%>
			<a href="/MyProject_Demo_one/buyerView/buyerLogin.jsp">如未自动跳转，请点击此处返回登陆页面!</a>
		</div>
	</head>
</html>
