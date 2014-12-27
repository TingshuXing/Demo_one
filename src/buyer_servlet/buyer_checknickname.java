package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer_dao.Buyer_checknickname_dao;
import buyer_dao.Buyer_checkusername_dao;

public class buyer_checknickname extends HttpServlet {

	public buyer_checknickname() {
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
		String nickname = new String(request.getParameter("nickname").getBytes("ISO-8859-1"),"UTF-8");	//获取输入的nickname
		Buyer_checknickname_dao buyer_checknickname_dao = new Buyer_checknickname_dao();
		String bool = buyer_checknickname_dao.buyer_checknickname(nickname);	//调用DAO中的检查nickname是否存在方法
		out.print(bool);
	}

	public void init() throws ServletException {
	}

}
