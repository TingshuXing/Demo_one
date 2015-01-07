<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>商品修改成功</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: red;margin-top: 350px;">商品修改成功!即将返回操作页面</h1>
			<%
				response.setHeader("refresh","2;url='/MyProject_Demo_one/sellerView/changeGoods.jsp'");
			%>
			<a href="/MyProject_Demo_one/sellerView/changeGoods.jsp">如未自动跳转，请点击此处进入操作页面!</a>
		</div>
	</head>
</html>
