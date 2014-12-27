<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="seller_servlet.Seller"%>
<%
	Seller seller = (Seller) session.getAttribute("seller");
%>
<html>
<head>
<title>恭喜发财!</title>
<link rel="stylesheet" type="text/css" href="../css/sellerMain.css" />
</head>
<body>
	<ul class="nav">
		<li class="logo"><img src="../img/logo.jpg" /></li>
		<li class="word">welcome to selling,<%=seller.getUsername()%></li>
	</ul>

	<div class="main">
		<div class="left">
			<ul>
				<li><a href="addGoods.jsp"> 增加商品</a></li>
				<li><a href="deleteGoods.jsp"> 删除商品</a></li>
				<li><a href="changeGoods.jsp"> 修改商品</a></li>
				<li><a href="findGoods.jsp"> 查看商品</a></li>
			</ul>
		</div>
		<div class="right">
			<h1 align="center">欢迎，请点击右边按钮，选择功能!</h1>
		</div>
	</div>
</body>
</html>