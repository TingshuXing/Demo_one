package seller_servlet;

import goods.Goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import seller_dao.Goods_add_dao;

public class goods_add extends HttpServlet {

	public goods_add() {
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
		Goods goods = new Goods(); // 新建一个Goods对象
		goods.setGoodsName((String)request.getParameter("goodsName")); // 将卖家输入的商品名称放入新建的goods对象中
		goods.setGoodsPrice((String)request.getParameter("goodsPrice")); // 将卖家输入的商品价格放入新建的goods对象中
		goods.setGoodsText((String)request.getParameter("goodsText")); // 将卖家输入的商品简介放入新建的goods对象中
		Goods_add_dao goods_add_dao = new Goods_add_dao();
		boolean bool = goods_add_dao.add_goods(goods); // 将商品信息存入数据库
		if (bool) {
			response.sendRedirect("/MyProject_Demo_one/sellerView/addSuccess.jsp");
		} else {
			response.sendRedirect("/MyProject_Demo_one/sellerView/addFail.jsp");
		}
	}

	public void init() throws ServletException {
	}

}
