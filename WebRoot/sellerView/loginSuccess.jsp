<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>登陆成功</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: red;margin-top: 350px;">登陆成功!即将跳转到主页面</h1>
			<%
				response.setHeader("refresh","2;url='/MyProject_Demo_one/sellerView/sellerMain.jsp'");
			%>
			<a href="/MyProject_Demo_one/sellerView/sellerMain.jsp">如未自动跳转，请点击此处进入主页面!</a>
		</div>
	</head>
</html>
