package seller_dao;

import goods.Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Goods_find_dao {
	public ArrayList goods_find() {
		Connection conn = null;
		ArrayList goods = new ArrayList();
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "select goodsName,goodsPrice,goodsText from goods";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Goods goods1 = new Goods();
				goods1.setGoodsName(rs.getString("goodsName"));
				goods1.setGoodsPrice(rs.getString("goodsPrice"));
				goods1.setGoodsText(rs.getString("goodsText"));
				goods.add(goods1);
			}
			rs.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goods;
	}
}
