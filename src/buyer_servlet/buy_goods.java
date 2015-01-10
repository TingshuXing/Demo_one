package buyer_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyer_dao.Buyer_goods_dao;

public class buy_goods extends HttpServlet {

	public buy_goods() {
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
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8");	//获取购买商品的名称
		String goodsPrice = new String(request.getParameter("goodsPrice").getBytes("ISO8859-1"),"UTF-8");	//获取购买商品的价格
		HttpSession session = request.getSession();
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		String userName = buyer.getUsername();	//获取用户的username
		Buyer_goods_dao buyer_goods_dao = new Buyer_goods_dao();
		boolean bool = buyer_goods_dao.add_goods(userName, goodsPrice, goodsName);
		if(bool){
			response.sendRedirect("/MyProject_Demo_one/buyerView/shopSuccess.jsp");
		}else{
			response.sendRedirect("/MyProject_Demo_one/buyerView/shopFail.jsp");
		}
	}

	public void init() throws ServletException {
	}

}
