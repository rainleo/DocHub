package docHub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class AppointmentDAO {

	
	
	public Doctor getDoctorDetails(int id)
	{
		Doctor dr=new Doctor();
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		String sql="select * from doctor where doctor_id=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setInt(1, id);
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			dr.setFirstname(rs.getString("first_name"));
			dr.setLastname(rs.getString("last_name"));
			dr.setDoctorId(id);
			dr.setEmailId(rs.getString("email_id"));
			dr.setPhoneNumber(rs.getString("phone_number"));
			dr.setLicenseNumber(rs.getString("license_number"));
			dr.setSpecialization(rs.getString("specialization"));
			dr.setInsuranceCovered(rs.getString("insurances_covered"));
		}
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return dr;
	}
	
	public ArrayList<Boolean> getDoctorTime(String date,int doctor_id)
	{
		ArrayList<Boolean> slot_array=new ArrayList<Boolean>();
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		String sql="select * from doctorAvailability where avdate=? and doctor_id=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setInt(2, doctor_id);
	
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			slot_array.add(rs.getBoolean("slot1"));
			slot_array.add(rs.getBoolean("slot2"));
			slot_array.add(rs.getBoolean("slot3"));
			slot_array.add(rs.getBoolean("slot4"));
			slot_array.add(rs.getBoolean("slot5"));
			slot_array.add(rs.getBoolean("slot6"));
			slot_array.add(rs.getBoolean("slot7"));
			slot_array.add(rs.getBoolean("slot8"));
		}
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return slot_array;
	}
	
	public String getSlot(String time)
	{
		String slot=null;
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		String sql="select * from slots where times=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, time);
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		 slot=rs.getString("slotid");
		
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return slot;
	}
	
	public void insertAppointment(String date, int d_id, int p_id, String slot, String time, String desc)
	{
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="insert into appointment(doctor_id,patient_id,date,slotid,slottime,description)"+"values(?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(3, date);
		preparedStmt.setInt(1, d_id);
		preparedStmt.setInt(2, p_id);
		preparedStmt.setString(4, slot);
		preparedStmt.setString(5, time);
		preparedStmt.setString(6, desc);
		
		preparedStmt.execute();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void updateDoctorSlot(String slot, int d_id,String date)
	{
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="update doctorAvailability set "+slot+"=0 where doctor_id=? and avdate=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		//preparedStmt.setString(1, slot);
		preparedStmt.setInt(1, d_id);
		preparedStmt.setString(2, date);

		
		preparedStmt.execute();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<Boolean> getDoctorSchedule(int did,String date)
	{
		ArrayList<Boolean> slots=new ArrayList<Boolean>();
		
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="select * from doctorAvailability where avdate=? and doctor_id=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setInt(2, did);
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			slots.add(rs.getBoolean("slot1"));
			slots.add(rs.getBoolean("slot2"));
			slots.add(rs.getBoolean("slot3"));
			slots.add(rs.getBoolean("slot4"));
			slots.add(rs.getBoolean("slot5"));
			slots.add(rs.getBoolean("slot6"));
			slots.add(rs.getBoolean("slot7"));
			slots.add(rs.getBoolean("slot8"));
		}
		else
		{
			slots.add(false);
			slots.add(false);
			slots.add(false);
			slots.add(false);
			slots.add(false);
			slots.add(false);
			slots.add(false);
			slots.add(false);
			
		}
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return slots;
	}
	
	public void insertDoctorSchedule(String[] slots,int did,String date)
	{
		try
		{
		ArrayList<String> slotArray= new ArrayList<String>(Arrays.asList(slots));

		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
	
		String sql="insert into doctorAvailability(doctor_id,avdate,slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8)"+"values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setInt(1, did);
		preparedStmt.setString(2, date);
		preparedStmt.setBoolean(3,slotArray.contains("slot1"));
		preparedStmt.setBoolean(4,slotArray.contains("slot2"));
		preparedStmt.setBoolean(5,slotArray.contains("slot3"));
		preparedStmt.setBoolean(6,slotArray.contains("slot4"));
		preparedStmt.setBoolean(7,slotArray.contains("slot5"));
		preparedStmt.setBoolean(8,slotArray.contains("slot6"));
		preparedStmt.setBoolean(9,slotArray.contains("slot7"));
		preparedStmt.setBoolean(10,slotArray.contains("slot8"));
		preparedStmt.execute();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void updateDoctorSchedule(String[] slots,int did,String date)
	{
		try
		{
		ArrayList<String> slotArray= new ArrayList<String>(Arrays.asList(slots));

		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="update doctorAvailability set slot1=?,slot2=?,slot3=?,slot4=?,slot5=?,slot6=?,slot7=?,slot8=? where doctor_id=? and avdate=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setInt(9, did);
		preparedStmt.setString(10, date);
		preparedStmt.setBoolean(1,slotArray.contains("slot1"));
		preparedStmt.setBoolean(2,slotArray.contains("slot2"));
		preparedStmt.setBoolean(3,slotArray.contains("slot3"));
		preparedStmt.setBoolean(4,slotArray.contains("slot4"));
		preparedStmt.setBoolean(5,slotArray.contains("slot5"));
		preparedStmt.setBoolean(6,slotArray.contains("slot6"));
		preparedStmt.setBoolean(7,slotArray.contains("slot7"));
		preparedStmt.setBoolean(8,slotArray.contains("slot8"));
		preparedStmt.execute();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public Boolean isScheduleExist(int did,String date)
	{
		Boolean exist=false;
	
		try
		{
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DocHub", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb","dochubse","dochubse");
		
		String sql="select * from doctorAvailability where avdate=? and doctor_id=?";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setInt(2, did);
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			exist=true;
		}
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return exist;
	}
}
