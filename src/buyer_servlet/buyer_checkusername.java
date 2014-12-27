package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer_dao.Buyer_checkusername_dao;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class buyer_checkusername extends HttpServlet {

	public buyer_checkusername() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");	//获取输入的username
		Buyer_checkusername_dao buyer_checkusername_dao = new Buyer_checkusername_dao();
		String bool = buyer_checkusername_dao.buyer_checkusername(username);	//调用DAO中的检查username是否存在方法
		out.print(bool);
	}

	public void init() throws ServletException {
	}

}
