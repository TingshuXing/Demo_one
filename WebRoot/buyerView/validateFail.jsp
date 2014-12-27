<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>验证码输入错误</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: red;margin-top: 350px;">验证码输入错误，请重新注册!</h1>
			<%
				response.setHeader("refresh","2;url='/MyProject_Demo_one/buyerView/buyerRegister.jsp'");
			%>
			<a href="/MyProject_Demo_one/buyerView/buyerRegister.jsp">如未自动跳转，请点击此处返回注册页面!</a>
		</div>
	</head>
</html>
