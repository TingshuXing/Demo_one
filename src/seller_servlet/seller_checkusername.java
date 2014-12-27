package seller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller_dao.Seller_checkusername_dao;

import buyer_dao.Buyer_checkusername_dao;

public class seller_checkusername extends HttpServlet {

	public seller_checkusername() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");	//获取输入的username
		Seller_checkusername_dao seller_checkusername_dao = new Seller_checkusername_dao();
		String bool = seller_checkusername_dao.seller_checkusername(username);	//调用DAO中的检查username是否存在方法
		out.print(bool);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
