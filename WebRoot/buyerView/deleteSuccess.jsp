<%@page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>删除商品成功</title>
</head>
<head>
<script type="text/javascript">
	alert("删除商品成功!")
</script>
<%
	response.setHeader("refresh",
			"0;url='/MyProject_Demo_one/buyerView/cart.jsp'");
%>
</head>
</html>
