function refresh(){	//买家和卖家注册界面的验证码刷新
		imgValidate.src = "../Repetition/validate.jsp";
}

function checkpassword() {	//买家和卖家注册界面验证两个密码输入是否一致
	var password = document.getElementById("password");
	var password2 = document.getElementById("password2");
	if(password.value == password2.value){
		var text5 = document.getElementById("text5");
		text5.innerHTML = "输入正确~";
		flag5 = true;	//表单可以提交
	}else{
		var text5 = document.getElementById("text5");
		text5.innerHTML = "两次密码输入不同!";
		flag5 = false; //表达无法提交
	}
}

