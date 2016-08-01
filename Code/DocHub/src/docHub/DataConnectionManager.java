/**
 * @author chandana
 *
 */
package docHub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataConnectionManager {
	public static final String URL = "jdbc:mysql://localhost/dochub";
	public static final String USER = "root";
	public static final String PASSWORD = "virgo";
	//public static final String URL = "jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb";
	//public static final String USER = "dochubse";
	//public static final String PASSWORD = "dochubse";
	
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static Connection c=null;
	
	public DataConnectionManager() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("In driver-CLASS");
		}
	}
	
	public Connection getConnection() {
		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(SQLException e) {
			System.out.println("couldn't connect to database");
			e.printStackTrace();
		}
		return c;
	}
	
	public void close() {
		if(c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
