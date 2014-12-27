<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<style type="text/css">
			span{	/*设置span的css样式*/
					font-size: large;
					font-weight: 800;
					font-family: "微软雅黑";
				}
				
			a	{	/*设置a的样式*/
					font-size: x-large;
					font-family: "微软雅黑";
					text-decoration:none;
					color: #666;
				}	 
		</style>
	</head>
	<body>
		<jsp:useBean id="personCount" class="counter.Counter" scope="application"></jsp:useBean>
		<div align="left">
			<span>欢迎您，第</span>
			<jsp:getProperty name="personCount" property="count" />
			<span>名访问者</span>
			<hr />
		</div>
		<div style="float: left;width: 50%;height: 88%">
			<div align="center">
				<a href="../buyerView/buyerLogin.jsp">我是消费者</a>
			</div>
			<div align="center">
				<br />
				<a href="../buyerView/buyerLogin.jsp"><img src="../img/xiaofeizhe.jpg" style="width: 620px;height: 680px"></a>
			</div>
		</div>
		<div style="float: right;width: 50%;height: 88%">
			<div align="center">
				<a href="../sellerView/sellerLogin.jsp">我是商户</a>
			</div>
			<div align="center">
				<br />
				<a href="../sellerView/sellerLogin.jsp"><img src="../img/shanghu.jpg" style="width: 650px;height: 650px;margin-top: 30px"></a>
			</div>
		</div>
	</body>
</html>
<%@include file="../Repetition/footer.jsp" %>