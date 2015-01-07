package seller_servlet;

import goods.Goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller_dao.Goods_delete_dao;

public class goods_delete extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public goods_delete() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods goods = new Goods(); // 新建一个Goods对象
		goods.setGoodsName(request.getParameter("goodsName")); // 将卖家输入的新的商品名称放入新建的goods对象中
		goods.setGoodsPrice(request.getParameter("goodsPrice")); // 将卖家输入的新的商品价格放入新建的goods对象中
		Goods_delete_dao goods_delete_dao = new Goods_delete_dao();
		boolean bool = goods_delete_dao.delete_goods(goods); // 将新商品信息存入数据库
		if (bool) {
			response.sendRedirect("/MyProject_Demo_one/sellerView/deleteSuccess.jsp");
		} else {
			response.sendRedirect("/MyProject_Demo_one/sellerView/deleteFail.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
