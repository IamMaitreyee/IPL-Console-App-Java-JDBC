package JDBC_IPL_Oct23;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDbCong {

	public static Connection getSqlConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ipl";
			String username = "root";
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
