package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Seller_checkusername_dao {
	public String seller_checkusername(String username){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//建立数据库连接
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "select * from seller where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				return "false";
			}else{
				return "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();	//关闭数据库连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "false";
	}
}
