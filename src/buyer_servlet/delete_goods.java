package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyer_dao.Delete_goods;

public class delete_goods extends HttpServlet {

	public delete_goods() {
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
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO-8859-1"),"UTF-8");	//获取要删除的商品名称
		HttpSession session = request.getSession();
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		String userName = buyer.getUsername();	//获取用户的username
		Delete_goods delete_goods = new Delete_goods();
		boolean bool = delete_goods.delete_goods(goodsName,userName);
		if(bool){
			response.sendRedirect("/MyProject_Demo_one/buyerView/deleteSuccess.jsp");
		}else{
			response.sendRedirect("/MyProject_Demo_one/buyerView/deleteFail.jsp");
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
