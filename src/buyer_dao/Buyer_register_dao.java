package buyer_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import buyer_servlet.Buyer;

public class Buyer_register_dao {
	public boolean addBuyer(Buyer buyer){
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "insert into buyer(username,nickname,email,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, buyer.getUsername());
			ps.setString(2, buyer.getNickname());
			ps.setString(3, buyer.getEmail());
			ps.setString(4, buyer.getPassword());
			int i = ps.executeUpdate();
			ps.close();
			if(i == 1){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{	
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
