<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="buyer_servlet.Buyer"%>
<%
	Buyer buyer = (Buyer) session.getAttribute("buyer");
%>
<html>
<head>
<title>购物愉快!</title>
<link rel="stylesheet" type="text/css" href="../css/buyerMain.css" />
</head>
<body>
	<ul class="nav">
		<li class="logo"><img src="../img/logo.jpg" /></li>
		<li class="word">welcome to shopping,<%=buyer.getUsername()%></li>
		<li class="img1"><a href=""><img src="../img/shop.jpg" /> </a></li>
	</ul>
	<div class="show">
		<img src="../img/chuizi.jpg">
	</div>


	<div class="main">
		<ul>
			<li>
				<div class="main_img">
					<img src="../img/bai.jpg">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>

		<ul>
			<li>
				<div class="main_img">
					<img src="../img/bai.jpg">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>

		<ul>
			<li>
				<div class="main_img">
					<img src="../img/bai.jpg">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>

		<ul>
			<li>
				<div class="main_img">
					<img src="../img/hei.png">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>

		<ul>
			<li>
				<div class="main_img">
					<img src="../img/hei.png">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>

		<ul>
			<li>
				<div class="main_img">
					<img src="../img/hei.png">
				</div>
				<div class="name">smartisan t1</div>
				<div class="price">RMB:1988</div>
				<div class="add">
					<a href="">购买</a>
				</div>
			</li>
		</ul>
	</div>
	
	<div class="log3">
		<%@include file="../Repetition/footer.jsp" %>
	</div>
</body>
</html>
