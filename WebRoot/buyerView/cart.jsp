<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="buyer_servlet.Buyer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="buyer_dao.Cart_find_dao"%>
<%@page import="goods.Goods"%>
<%
	Buyer buyer = (Buyer) session.getAttribute("buyer");
	String bool = (String) session.getAttribute("login");
	if (bool == null) {
		response.sendRedirect("buyerLogin.jsp");
	}
%>
<%
	Cart_find_dao cart_dao = new Cart_find_dao();
	ArrayList goods = cart_dao.goods_find(buyer.getUsername());
%>
<html>
<head>
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="../css/cart.css" />
</head>
<body>
	<div class="logo">
		<img src="../img/logo.jpg">
		<span><%=buyer.getUsername() %>的购物车</span>
	</div>
	<div class="table">
		<table border=2>
			<tr class="head">
				<td>商品名称</td>
				<td>商品价格</td>
				<td>删除</td>
			</tr>
			<%
				for (int i = 0; i < goods.size(); i++) {
					Goods goods1 = (Goods) goods.get(i);
			%>
			<tr>
				<td><%=goods1.getGoodsName()%></td>
				<td><%=goods1.getGoodsPrice()%></td>
				<td><a href="/MyProject_Demo_one/buyer_servlet/delete_goods?goodsName=<%=goods1.getGoodsName()%>">删除</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<div class="foot">
		<a href="buyerMain.jsp">返回继续购物</a>
		<a href="">结算</a>
	</div>
</body>
</html>