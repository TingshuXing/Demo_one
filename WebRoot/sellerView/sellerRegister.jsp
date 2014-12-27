<%@page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<script type="text/javascript" src="../JS/main.js"></script>
		<script type="text/javascript">
		var flag1 = false;
		var flag2 = false;
		var flag3 = false;
		var flag4 = false;
		var flag5 = false;
		var xmlHttp;
		//创建xmlHttp对象
		function createXMLHttp(){	
			if(window.XMLHttpRequest){	//Mozilla等浏览器
				xmlHttp = new XMLHttpRequest();
			}else if(window.ActiveXObject){	//IE浏览器
				xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
			}
		}
		//判断username
		function checkusername(username){
			if(username == ""){
				document.getElementById("text1").innerHTML = "用户名不能为空!";
				flag1 = false;	//无法提交表单
			}else{
				createXMLHttp();	//创建xmlHttp
				xmlHttp.open("post", "/MyProject_Demo_one/seller_servlet/seller_checkusername?username=" + username);	//设置请求
				xmlHttp.onreadystatechange = checkusernameCallback;	//设置回调函数
				xmlHttp.send(null);	//发送请求
				document.getElementById("text1").innerHTML = "正在验证，请稍后";
			}
		}
		//username回调函数
		function checkusernameCallback(){
			if(xmlHttp.readyState == 4){	//数据返回完毕
				if(xmlHttp.status == 200){	//HTTP操作正常
					var text = xmlHttp.responseText;	//接受返回内容
					if(text == "true"){
						document.getElementById("text1").innerHTML = "恭喜!该ID可以注册";
						flag1 = true;	//可以提交表单
					}else{
						document.getElementById("text1").innerHTML = "用户名重复!请重新输入";
						flag1 = false;	//无法提交表单
					}
				}
			}
		}
		//判断storename
		function checkstorename(storename){
			if(storename == ""){
				document.getElementById("text2").innerHTML = "店铺名不能为空!";
				flag2 = false;	//无法提交表单
			}else{
				createXMLHttp();	//创建xmlHttp
				xmlHttp.open("post", "/MyProject_Demo_one/seller_servlet/seller_checkstorename?storename=" + storename);	//设置请求
				xmlHttp.onreadystatechange = checkstorenameCallback;	//设置回调函数
				xmlHttp.send(null);	//发送请求
				document.getElementById("text2").innerHTML = "正在验证，请稍后";
			}
		}
		//storename回调函数
		function checkstorenameCallback(){
			if(xmlHttp.readyState == 4){	//数据返回完毕
				if(xmlHttp.status == 200){	//HTTP操作正常
					var text = xmlHttp.responseText;	//接受返回内容
					if(text == "true"){
						document.getElementById("text2").innerHTML = "恭喜!该店名可以注册";
						flag2 = true;	//可以提交表单
					}else{
						document.getElementById("text2").innerHTML = "店名重复!请重新输入";
						flag2 = false;	//无法提交表单
					}
				}
			}
		}
		//检查邮箱
		function checkemail(email){
			if(email == ""){
				document.getElementById("text3").innerHTML = "邮箱不能为空!";
				flag3 = false;	//无法提交表单
			}else{
				document.getElementById("text3").innerHTML = "请保证您的邮箱正确!";
				flag3 = true;	//表单可以提交
			}
		}
		//检查密码是否为空
		function checkpassword1(password){
			if(password == ""){
				document.getElementById("text4").innerHTML = "密码不能为空!";
				flag4 = false;	//无法提交表单
			}else{
				document.getElementById("text4").innerHTML = "请确认密码!";
				document.getElementById("text5").innerHTML = "请再次输入密码!";
				flag4 = true;	//表单可以提交
			}
		}
		//检查表达是否可以提交
		function checkForm(){
			return flag1&&flag2&&flag3&&flag4&&flag5;
		}
		</script>
		<link rel="stylesheet" type="text/css" href="../css/register.css">
		<meta charset="UTF-8">
		<title>卖家注册</title>
	</head>
	<body>
		<div align="center" class="log0">&nbsp; 
			<span class="login_span">卖家注册</span>
		</div>
		<br />
		<br />
		<div class="log1">
			<form action="/MyProject_Demo_one/seller_servlet/seller_register_servlet" method="post" onsubmit="return checkForm()">
				<div class="form_left">
				
					<img class="register" src="../img/register.jpg">
	
	 				<div>
	 					<span>用户名：</span> <input type="text" name="username" placeholder="username" onblur="checkusername(this.value)"/>
	 				</div>
	
	 				<div>
	 					<span>店铺名称：</span> <input type="text" name="storename" placeholder="storename" onblur="checkstorename(this.value)"/>
	 				</div>
	
	 				<div>
	 					<span>邮箱：</span> <input type="email" name="email"placeholder="email" onblur="checkemail(this.value)"/>
	 				</div>
	
	 				<div>
	 					<span>密码：</span> <input type="password" name="password" id="password" placeholder="password" onblur="checkpassword1(this.value)"/>
	 				</div>
	
	 				<div> 
	 					<span>密码确认：</span> <input type="password" name="password2" id="password2" placeholder="password" onkeyup="checkpassword()"/>
	 				</div>
	
	 				<div>
	 					<span>验证码:</span> <input type="text" name="validate" placeholder="validate" id="validate"/>
	 				</div>
	
					<div>
						<input type="submit" value="注册"  class="submit" />
					</div>
				</div>
				<div class="form_right">				
					<div>
						<msg id="text1">请输入用户名</msg>
					</div>
					<div>
						<msg id="text2">请输入店铺名称</msg>
					</div>
					<div>
						<msg id="text3">请输入邮箱</msg>
					</div>
					<div>
						<msg id="text4">请输入密码</msg>
					</div>
					<div>
						<msg id="text5"></msg>
					</div>
					<div>
						<img alt="该浏览器不支持验证码" src="../Repetition/validate.jsp" class="validate" onClick="refresh()" name="imgValidate" />
					</div>
				</div>
			</form>
		</div>
		<div class="log2">
			<a href="sellerLogin.jsp" class="a_back">返回登陆页面</a>
		</div>
		<div class="log3">
			<%@include file="../Repetition/footer.jsp" %>
		</div>
	</body>
</html>
