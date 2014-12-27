package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import seller_servlet.Seller;


public class Seller_register_dao {
	public boolean addSeller(Seller seller) {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "insert into seller(username,storename,email,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, seller.getUsername());
			ps.setString(2, seller.getStorename());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPassword());
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
