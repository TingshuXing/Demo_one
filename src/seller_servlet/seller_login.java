package seller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller_dao.Seller_login_dao;
import util.md_five;

public class seller_login extends HttpServlet {

	public seller_login() {
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
		// 新建一个Seller对象
		Seller seller = new Seller();
		String newPassword;
		try {
			newPassword = md_five.addPassword(request.getParameter("password"));
			seller.setPassword(newPassword); // 将表单提交过来的password放入对象中
		} catch (Exception e) {
			e.printStackTrace();
		}
		seller.setUsername(request.getParameter("username")); // 将表单提交过来的username放入对象中
		// 新建一个Dao对象
		Seller_login_dao seller_login_dao = new Seller_login_dao();
		// 调用Dao对象的检查用户名密码是否匹配的方法,返回true表示匹配,反之则不匹配
		boolean bool = seller_login_dao.seller_login(seller);
		if (bool) { // 用户名密码匹配
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("seller", seller); // 将用户信息放入session
			String name = "a";
			session.setAttribute("login1", name);
			response.sendRedirect("/MyProject_Demo_one/sellerView/loginSuccess.jsp"); // 跳转到登陆成功界面
		} else { // 用户名密码不匹配
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", false);
			response.sendRedirect("/MyProject_Demo_one/sellerView/loginFail.jsp"); // 跳转到登陆失败界面
		}
	}

	public void init() throws ServletException {
	}

}
