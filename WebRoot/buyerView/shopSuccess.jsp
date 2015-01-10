<%@page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>添加购物车成功</title>
</head>
<head>
<script type="text/javascript">
	alert("添加购物车成功!")
</script>
<%
	response.setHeader("refresh",
			"0;url='/MyProject_Demo_one/buyerView/buyerMain.jsp'");
%>
</head>
</html>
