<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="seller_servlet.Seller"%>
<%
	Seller seller = (Seller) session.getAttribute("seller");
%>
<html>
<head>
<title>恭喜发财!</title>
<link rel="stylesheet" type="text/css" href="../css/sellerMain.css" />
<link rel="stylesheet" type="text/css" href="../css/addGoods.css" />
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
			<div class="title">
				<h1 align="center">删除商品信息</h1>
				<span>请填写商品信息</span>
			</div>
			<div class="form">
				<form action="/MyProject_Demo_one/seller_servlet/goods_delete" method="post">
	 				<div>
	 					<span>商品名称:</span> <input type="text" name="goodsName" placeholder="请输入商品名称" />
	 				</div>
	 				<div>
	 					<span>商品价格:</span> <input type="text" name="goodsPrice" placeholder="请输入商品价格" />
	 				</div>
	 				<div>
	 					<span>用户密码:</span> <input type="text" name="userpassword" placeholder="请输入用户密码" />
	 				</div>
	 				<div class="button">
	 					<input type="submit" value="确认删除" />
	 				</div>
	 				<span>请核对好商品信息再确认删除</span>
				</form>
			</div>
		</div>
	</div>
	<div class="log3">
		<%@include file="../Repetition/footer.jsp" %>
	</div>
</body>
</html>