package seller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller_dao.Seller_register_dao;


public class seller_register_servlet extends HttpServlet {

	public seller_register_servlet() {
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
		String validate = request.getParameter("validate");		//得到提交的验证码
		//获取session中的验证码
		HttpSession session = request.getSession();
		String validate2 = (String)session.getAttribute("randStr");
		if(validate.equals(validate2)){
			Seller seller = new Seller();
			seller.setUsername(request.getParameter("username"));
			seller.setStorename(request.getParameter("storename"));
			seller.setEmail(request.getParameter("email"));
			seller.setPassword(request.getParameter("password"));
			Seller_register_dao seller_register_dao = new Seller_register_dao();
			boolean bool = seller_register_dao.addSeller(seller);
			if(bool){	
				response.sendRedirect("/MyProject_Demo_one/sellerView/registerSuccess.jsp");
			}else{		
				response.sendRedirect("/MyProject_Demo_one/sellerView/registerFail.jsp");
			}
		}else{
			response.sendRedirect("/MyProject_Demo_one/sellerView/validateFail.jsp");
		}
	}

	public void init() throws ServletException {
	}

}
