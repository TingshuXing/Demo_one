<%@page import="java.util.ArrayList"%>
<%@page import="seller_dao.Goods_find_dao"%>
<%@page import="goods.Goods"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="buyer_servlet.Buyer"%>
<%
	Buyer buyer = (Buyer) session.getAttribute("buyer");
	String bool = (String) session.getAttribute("login");
	if (bool == null) {
		response.sendRedirect("buyerLogin.jsp");
	}
%>
<%
	Goods_find_dao goods_dao = new Goods_find_dao();
	ArrayList goods = goods_dao.goods_find();
%>
<html>
<head>
<title>购物愉快!</title>
<link rel="stylesheet" type="text/css" href="../css/buyerMain.css" />
</head>
<body>
	<ul class="nav">
		<li class="logo"><img src="../img/logo.jpg" /></li>
		<li class="word">welcome to shopping,Happy!</li>
		<li class="img1"><a href="cart.jsp"><img src="../img/shop.jpg" /> </a></li>
	</ul>
	<div class="show">
		<img src="../img/chuizi.jpg">
		<video src="../video/1.mp4" controls="controls"></video>
	</div>


	<div class="main">
		<%
			for (int i = 0; i < goods.size(); i++) {
				Goods goods1 = (Goods) goods.get(i);
		%>
		<ul>
			<li>
				<div class="main_img">
					<img src="<%=goods1.getPicture()%>">
				</div>
				<div class="name"><%=goods1.getGoodsName()%></div>
				<div class="price">
					RMB:<%=goods1.getGoodsPrice()%></div>
				<div class="add">
					<a href="/MyProject_Demo_one/buyer_servlet/buy_goods?goodsName=<%=goods1.getGoodsName() %>&goodsPrice=<%=goods1.getGoodsPrice()%>">购买</a>
				</div>
			</li>
		</ul>
		<%
			}
		%>
	</div>
	<div class="log3">
		<%@include file="../Repetition/footer.jsp"%>
	</div>
</body>
</html>
