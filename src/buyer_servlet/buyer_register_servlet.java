package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.md_five;

import buyer_dao.Buyer_register_dao;

public class buyer_register_servlet extends HttpServlet {

	public buyer_register_servlet() {
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
		if(validate.equals(validate2)){		//验证验证码是否正确
			Buyer buyer = new Buyer();
			try {	//密码加密
				String newPassword = md_five.addPassword(request.getParameter("password"));
				buyer.setPassword(newPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			buyer.setUsername(request.getParameter("username"));
			buyer.setNickname(request.getParameter("nickname"));
			buyer.setEmail(request.getParameter("email"));
			Buyer_register_dao buyer_register_dao = new Buyer_register_dao();
			boolean bool = buyer_register_dao.addBuyer(buyer);
			if(bool){	
				response.sendRedirect("/MyProject_Demo_one/buyerView/registerSuccess.jsp");
			}else{		
				response.sendRedirect("/MyProject_Demo_one/buyerView/registerFail.jsp");
			}
		}else{
			response.sendRedirect("/MyProject_Demo_one/buyerView/validateFail.jsp");			
		}
	}

	public void init() throws ServletException {
	}

}
