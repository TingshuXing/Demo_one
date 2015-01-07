package seller_servlet;

import goods.Goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller_dao.Goods_change_dao;


public class goods_change extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public goods_change() {
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
		goods.setGoodsText(request.getParameter("goodsText")); // 将卖家输入的新的商品简介放入新建的goods对象中
		Goods_change_dao goods_change_dao = new Goods_change_dao();
		String oldName = request.getParameter("goodsOldName");	//将卖家输入的旧的商品名称赋给oldName
		boolean bool = goods_change_dao.change_goods(goods,oldName); // 将新商品信息存入数据库
		if (bool) {
			response.sendRedirect("/MyProject_Demo_one/sellerView/changeSuccess.jsp");
		} else {
			response.sendRedirect("/MyProject_Demo_one/sellerView/changeFail.jsp");
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
