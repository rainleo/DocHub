package docHub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import docHub.Patient1;


public class DaoPatient {
	private static Connection connect() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dochub","root","virgo");
			//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


public static ResultSet LoginUser(Patient1 m, String sql) {
		
		ResultSet rs = null;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, m.getEmail());
			ps.setString(2, m.getPass());
			
			
			
			rs= ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}

	
	public static int updatePatient(Patient pat, String sql) {
		int i=0;
		//sql="update patient set insurance_provider=?,insurance_id=?,addressline1=?,addressline2=?,city=?,state=?,country=?,zipcode=?,phone_number=? where email_id=?";
		Connection con=connect();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, pat.getInsurance());
			ps.setString(2, pat.getInsuranceId());
			ps.setString(3, pat.getAddress1());
			ps.setString(4, pat.getAddress2());
			ps.setString(5, pat.getCity());
			ps.setString(6, pat.getState());
			ps.setString(7, pat.getCountry());
			ps.setString(8, pat.getZipCode());
			ps.setString(9, pat.getPhoneNum());
			ps.setString(10, pat.getEmailId());

			
			
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return i;
	}

}
