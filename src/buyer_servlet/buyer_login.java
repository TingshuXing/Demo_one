package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyer_dao.Buyer_login_dao;

public class buyer_login extends HttpServlet {

	public buyer_login() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//新建一个Buyer对象
		Buyer buyer = new Buyer();
		buyer.setUsername(request.getParameter("username"));	//将表单提交过来的username放入对象中
		buyer.setPassword(request.getParameter("password"));	//将表单提交过来的password放入对象中
		//新建一个Dao对象
		Buyer_login_dao buyer_login_dao = new Buyer_login_dao();
		//调用Dao对象的检查用户名密码是否匹配的方法,返回true表示匹配,反之则不匹配
		boolean bool = buyer_login_dao.buyer_login(buyer);
		if(bool){	//用户名密码匹配
			HttpSession session = request.getSession();
			session.setAttribute("buyer", buyer);	//将用户信息放入session
			response.sendRedirect("/MyProject_Demo_one/buyerView/loginSuccess.jsp");
		}else{	//用户名密码不匹配
			HttpSession session = request.getSession();
			response.sendRedirect("/MyProject_Demo_one/buyerView/loginFail.jsp");
		}	
	}

	public void init() throws ServletException {
	}

}
