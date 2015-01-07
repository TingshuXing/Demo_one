package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import goods.Goods;

public class Goods_delete_dao {
	public boolean delete_goods(Goods goods) {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "delete from goods where goodsName= '" + goods.getGoodsName() + "' and goodsPrice='" + goods.getGoodsPrice() + "'";
			Statement stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
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
