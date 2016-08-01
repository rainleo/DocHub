package docHub;

import java.sql.*;
public class RegisterDAO {
	
	public boolean emailCheck(String email,String user)
	{
		String sql;
		boolean isExist=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		if(user.equals("doctor"))
			sql="select email_id from doctor where email_id=?";
		else
			sql="select email_id from patient where email_id=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, email);
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
			isExist=true;
		else
			isExist=false;
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return isExist;
	}
	
	public void insertPatient(Patient p)
	{
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="insert into patient(first_name,last_name,gender,dob,email_id,pass,security_question,sec_answer,phone_number,addressline1,addressline2,city,state,country,zipcode,insurance_provider,insurance_id)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, p.getFirstname());
		preparedStmt.setString(2, p.getLastname());
		preparedStmt.setString(3, p.getGender());
		preparedStmt.setString(4, p.getDateOfBirth());
		preparedStmt.setString(5, p.getEmailId());
		preparedStmt.setString(6, p.getPassword());
		preparedStmt.setString(7, p.getSecurityQuestion());
		preparedStmt.setString(8, p.getSecurityAnswer());
		preparedStmt.setString(9, p.getPhoneNum());
		preparedStmt.setString(10, p.getAddress1());
		preparedStmt.setString(11, p.getAddress2());
		preparedStmt.setString(12, p.getCity());
		preparedStmt.setString(13, p.getState());
		preparedStmt.setString(14, p.getCountry());
		preparedStmt.setString(15, p.getZipCode());
		preparedStmt.setString(16, p.getInsurance());
		preparedStmt.setString(17, p.getInsuranceId());

		
		
		preparedStmt.execute();
	    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void insertDoctor(Doctor d)
	{
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		
		String sql="insert into doctor(first_name,last_name,gender,dob,email_id,pass,security_question,sec_answer,phone_number,addressline1,addressline2,city,state,country,zipcode,insurances_covered,license_number,specialization)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, d.getFirstname());
		preparedStmt.setString(2, d.getLastname());
		preparedStmt.setString(3, d.getGender());
		preparedStmt.setString(4, d.getDateOfBirth());
		preparedStmt.setString(5, d.getEmailId());
		preparedStmt.setString(6, d.getPassword());
		preparedStmt.setString(7, d.getSecurityQuestion());
		preparedStmt.setString(8, d.getSecurityAnswer());
		preparedStmt.setString(9, d.getPhoneNum());
		preparedStmt.setString(10,d.getAddress1());
		preparedStmt.setString(11, d.getAddress2());
		preparedStmt.setString(12, d.getCity());
		preparedStmt.setString(13, d.getState());
		preparedStmt.setString(14, d.getCountry());
		preparedStmt.setString(15, d.getZipCode());
		preparedStmt.setString(16, d.getInsuranceCovered());
		preparedStmt.setString(17, d.getLicenseNumber());
		preparedStmt.setString(18, d.getSpecialization());
		
		
		
		
		preparedStmt.execute();
	    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
