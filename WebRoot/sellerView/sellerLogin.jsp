<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/login.css">
		<title>卖家登陆</title>
		<script type="text/javascript">
			var flag1 = false;
			var flag2 = false;
			//判断用户名是否为空
			function checkusername(username){	
				if(username == ""){
					flag1 = false;	//表单无法提交
				}else{
					flag1 = true;	//表达可以提交
				}
			}
			//判断密码是否为空
			function checkpassword(password){
				if(password == ""){
					flag2 = false;	//表单无法提交
				}else{
					flag2 = true;	//表达可以提交
				}
			}
			//判断表单是否可以提交
			function checkForm(){
				return flag1&&flag2;
			}
		</script>
	</head>
	<body>
		<div align="center" class="log0">
			<span class="login_span">卖家登陆</span>
		</div>
		<div class="log1">
			<form action="/MyProject_Demo_one/seller_servlet/seller_login" method="post" onsubmit="return checkForm()">
				<img src="../img/login.jpg" class="img_login" /><br />
				<img src="../img/user.jpg" class="img_user" />
				<input type="text" name="username" class="username" placeholder="username" onblur="checkusername(this.value)"/><br />
				<img src="../img/pwd.jpg" class="img_pwd" />
				<input type="password" name="password" class="password" placeholder="password" onblur="checkpassword(this.value)"/><br />
				<input type="checkbox" name="remember" class="remember" /><span class="rem_span">remember me</span><br />
				<input type="submit" value="登陆"  class="submit" /><br />
				<a href="sellerRegister.jsp" class="register">注册</a>
			</form>
		</div>
		<div class="log2">
			<a href="../buyerView/buyerLogin.jsp" class="a_change">买家入口</a>
		</div>
		<div class="log3">
			<%@include file="../Repetition/footer.jsp" %>
		</div>
	</body>
</html>
