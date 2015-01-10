<%@page language="java" pageEncoding="UTF-8" %>
<%
	String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
	session.setAttribute("goodsName", name);
%>
<html>
	<head>
		<title>添加图片</title>
	</head>
	<head>
		<div align="center">
			<h1 style="color: #666;margin-top: 200px;">添加商品图片</h1>
			<form action="/MyProject_Demo_one/seller_servlet/UploadServlet" method="post" enctype="multipart/form-data">
				商品图片:<input type="file" name="myfile">
				<input type="hidden" value="<%=name %>" name="goodsName">
				<input type="submit" value="上传">
			</form>
		</div>
	</head>
</html>
