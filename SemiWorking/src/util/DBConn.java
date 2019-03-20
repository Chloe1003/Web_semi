package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	// DB ?���? ?���?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL =  "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "momo";
	private static final String PASSWORD = "admin2019";
	
	// DB ?���? 객체
	private static Connection conn = null;
	
	// private ?��?��?��
	private DBConn() { }
	
	// Connection 객체 반환 - Singleton Pattern
	public static Connection getConnection() {
		if(conn==null) {
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (ClassNotFoundException e ) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
