<%@page import="java.util.ArrayList"%>
<%@page import="seller_dao.Goods_find_dao"%>
<%@page import="goods.Goods"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="seller_servlet.Seller"%>
<%
	Seller seller = (Seller) session.getAttribute("seller");
	String bool = (String) session.getAttribute("login1");
	if (bool == null) {
		response.sendRedirect("sellerLogin.jsp");
	}
%>
<%
	Goods_find_dao goods_dao = new Goods_find_dao();
	ArrayList goods = goods_dao.goods_find();
%>
<html>
<head>
<title>恭喜发财!</title>
<link rel="stylesheet" type="text/css" href="../css/sellerMain.css" />
</head>
<body>
	<ul class="nav">
		<li class="logo"><img src="../img/logo.jpg" /></li>
		<li class="word">welcome to selling,happy everyday!</li>
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
			<h1 align="center">查看商品信息</h1>
			<div>
				<table width=800px heigth=500px border=2 class="table">
					<thead>
						<td>商品名称</td>
						<td>商品价格</td>
						<td>商品简介</td>
						<td>上传图片</td>
					</thead>
					<%
						for (int i = 0; i < goods.size(); i++) {
							Goods goods1 = (Goods) goods.get(i);
					%>
					<tr>
						<td><%=goods1.getGoodsName()%></td>
						<td><%=goods1.getGoodsPrice()%></td>
						<td><%=goods1.getGoodsText()%></td>
						<td>
							<a href="http://localhost:8080/MyProject_Demo_one/sellerView/addPicture.jsp?name=<%=goods1.getGoodsName()%>">添加图片</a>
						</td>
					<tr>
						<%
							}
						%>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>