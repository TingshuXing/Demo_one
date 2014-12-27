package seller_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import seller_servlet.Seller;


public class Seller_login_dao {
	public boolean seller_login(Seller seller){
		String username = seller.getUsername();	//得到表单提交的username
		String password = seller.getPassword();	//得到表单提交的password
		Connection conn = null;
		try {
			//建立数据库连接
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Eshop";
			conn = DriverManager.getConnection(url);
			String sql = "select * from seller where username = '" + username + "' and password = '" + password + "'";
			Statement stat = conn.createStatement();
			ResultSet rs = null;
			rs = stat.executeQuery(sql);
			if(rs.next()){	//判断是否匹配
				return true;
			}else{
				return false;
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
		return false;
	}
}
