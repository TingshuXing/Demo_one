package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import goods.Goods;

public class Goods_change_dao {
	public boolean change_goods(Goods goods, String oldName) {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			Statement stat = conn.createStatement();
			String sql = "update goods set goodsName = '" + goods.getGoodsName() + "',goodsPrice = '" + goods.getGoodsPrice() + "',goodsText = '" + goods.getGoodsText() + "' " +
					"where goodsName = '" + oldName + "'";
			int i = stat.executeUpdate(sql);
			stat.close();
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
