package docHub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import docHub.Doctor1;

public class DaoDoctor {

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


public static ResultSet LoginUser(Doctor1 m, String sql) {
		
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

	
	public static int updateDoctor(Doctor doc, String sql) {
		int i=0;
		//sql="update doctor set insurances_covered=?,specialization=?,addressline1=?,addressline2=?,city=?,state=?,country=?,zipcode=?,phone_number=? where email_id=?";
		Connection con=connect();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, doc.getInsuranceCovered());
			ps.setString(2, doc.getSpecialization());
			ps.setString(3, doc.getAddress1());
			ps.setString(4, doc.getAddress2());
			ps.setString(5, doc.getCity());
			ps.setString(6, doc.getState());
			ps.setString(7, doc.getCountry());
			ps.setString(8, doc.getZipCode());
			ps.setString(9, doc.getPhoneNum());
			ps.setString(10, doc.getEmailId());

			
			
			
			ps.execute();
			i=1;
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		return i;
	}

}
