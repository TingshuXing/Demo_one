package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import goods.Goods;

public class Goods_add_dao {
	public boolean add_goods(Goods goods) {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "insert into goods(goodsName,goodsPrice,goodsText) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setString(2, goods.getGoodsPrice());
			ps.setString(3, goods.getGoodsText());
			int i = ps.executeUpdate();
			ps.close();
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
