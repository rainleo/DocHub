package docHub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewAppointment {
	public static void Search(String user_type, Integer type_id) {
		
		HashMap<Integer, String> id_name = new HashMap<Integer, String>();
		HashMap<Integer, Integer> id_appid = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> id_userid = new HashMap<Integer, Integer>();
		HashMap<Integer, String> id_date = new HashMap<Integer, String>();
		HashMap<Integer, String> id_time = new HashMap<Integer, String>();
		HashMap<Integer, String> id_desc = new HashMap<Integer, String>();
		ArrayList<Integer> order_list = new ArrayList<Integer>();
		
		
		String fname = null;
		String lname = null;
		
		ResultSet result = null;
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		PreparedStatement pstmt = null;
		if(conn!=null)
		try{
			
			String sql = null;
			
			if(user_type=="doctor"){

				sql = "select * from appointment where doctor_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type_id);
				result = pstmt.executeQuery();
				
				while(result.next()) {
					
					int id = result.getInt("appt_id");
					int p_id = result.getInt("patient_id");
					String date = result.getString("date");
					String time = result.getString("slottime");
					String desc = result.getString("description");
					System.out.println("appt id:"+id);
					System.out.println("appt id:"+date);
					System.out.println("appt id:"+time);
					System.out.println("appt id:"+desc);				
					
					sql = "select first_name,last_name from patient where patient_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, p_id);
					ResultSet rs = pstmt.executeQuery();
					String name=null;
					
					while(rs.next()) {
						
						fname = rs.getString("first_name");
						lname = rs.getString("last_name");
						name = fname+" "+lname;
					}
					
					System.out.println("name:"+name);
					
					order_list.add(id);
					id_name.put(id, name);
					id_date.put(id, date);
					id_time.put(id, time);
					id_desc.put(id, desc);
					id_userid.put(id,p_id);
					}
				
				} else if(user_type=="patient") {
					
				System.out.println("patient");
				sql = "select * from appointment WHERE patient_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type_id);
				result = pstmt.executeQuery();
				
				while(result.next()) {
					int id = result.getInt("appt_id");
					int d_id = result.getInt("doctor_id");
					String date = result.getString("date");
					String time = result.getString("slottime");
					
					sql = "select first_name,last_name,specialization from doctor where doctor_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, d_id);
					ResultSet rs = pstmt.executeQuery();
					String name = null;
					String spec = null;
					while(rs.next()) {
						
						fname = rs.getString("first_name");
						lname = rs.getString("last_name");
						name = fname+" "+lname;
						spec = rs.getString("specialization");
					}										
					order_list.add(id);
					id_name.put(id, name);
					id_date.put(id, date);
					id_time.put(id, time);
					id_desc.put(id, spec);	
					id_userid.put(id,d_id);
					}												
				}
			
			AppointmentDetails details = new AppointmentDetails();
			details.setOrder_list(order_list);
			details.setId_name(id_name);
			details.setId_appid(id_appid);
			details.setId_date(id_date);
			details.setId_time(id_time);
			details.setId_desc(id_desc);
			details.setId_userid(id_userid);

			
			System.out.println(result);
		} catch(SQLException e) {
			System.out.println("In search"+e);
		}
		DM.close();	
	}
	public static void deleteAppointment(int appt_id, String user_type) {
		// TODO Auto-generated method stub
		System.out.println("have to delete rec");
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		int did = 0;
		int pid = 0;
		String pemailid = null;
		String demailid = null;
		String pfirst_name = null;
		String dfirst_name = null;
		String dspecialization = null;
		String app_date = null;
		String app_time = null;
		String app_slotid = null;

		if(conn!=null) { 
			String sql = "select * from appointment where appt_id=?";
			PreparedStatement pstmt;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, appt_id);
				pstmt.execute();
				ResultSet result = pstmt.executeQuery();
				if(result.next()) {
					did = result.getInt("doctor_id");
					pid = result.getInt("patient_id");
					app_date = result.getString("date");
					app_slotid = result.getString("slotid");
					app_time = result.getString("slottime");
					sql = "select first_name,email_id from patient where patient_id=?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, pid);
					pstmt.execute();
					result = pstmt.executeQuery();
					if(result.next()) {
						pemailid = result.getString("email_id");
						pfirst_name = result.getString("first_name");
					}
					sql = "select first_name,email_id,specialization from doctor where doctor_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, did);
					pstmt.execute();
					result = pstmt.executeQuery();
					if(result.next()) {
						demailid = result.getString("email_id");
						dfirst_name = result.getString("first_name");
						dspecialization = result.getString("specialization");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//PreparedStatement pstmt = null;
		if(conn!=null) {
			String sql="delete from appointment where appt_id=?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, appt_id);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!user_type.equals("doctor")) {
		if(conn!=null) {
			String sql="update doctorAvailability set "+app_slotid+"=1 where doctor_id=? and avdate=?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, did);
				pstmt.setString(2, app_date);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		DM.close();
		System.out.println("emailing after cancellation");
		try {
		System.out.println("email to patient");
		String msg="<html><body><h4>Hi "+pfirst_name+",<br><br>Cancel Confirmation from \"DocHub\"<br>Your canceled appointment details:-</h4><br>";
		msg = msg+"<table border=2><tr><th>Doctor Name</th><th>Doctor Specialization</th><th>Appointment Date</th><th>Appointment Time</th></tr>";
		msg = msg+"<tr><td>"+dfirst_name+"</td><td>"+dspecialization+"</td><td>"+app_date+"</td><td>"+app_time+"</td></tr></table></body></html>";
		//String msg="Thank you for booking an appointment at DocHub\n Your appointment details:- \nDoctor Name:"+dr.getFirstname()+"\nDate:"+date_apt+"\nTime:"+time;
		Send_Email.sendEmail("smtp.gmail.com", "587", "dochub2016@gmail.com", "dochubse", pemailid, "DocHub:Cancelled Appointment---------",msg);
		} catch(Exception e) {
		System.out.println(e);
		}
		try {
			System.out.println("email to doctor");
			String msg="<html><body><h4>Hi"+dfirst_name+",<br><br>Cancel Confirmation from \"DocHub\"<br>Your canceled appointment details:-</h4><br>";
			msg = msg+"<table border=2><tr><th>Patient Name</th><th>Appointment Date</th><th>Appointment Time</th></tr>";
			msg = msg+"<tr><td>"+pfirst_name+"</td><td>"+app_date+"</td><td>"+app_time+"</td></tr></table></body></html>";
			//String msg="Thank you for booking an appointment at DocHub\n Your appointment details:- \nDoctor Name:"+dr.getFirstname()+"\nDate:"+date_apt+"\nTime:"+time;
			Send_Email.sendEmail("smtp.gmail.com", "587", "dochub2016@gmail.com", "dochubse", demailid, "DocHub:Cancelled Appointment---------",msg);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void SearchbyAppt(Integer app_id) {

		HashMap<Integer, String> id_name = new HashMap<Integer, String>();
		HashMap<Integer, Integer> id_appid = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> id_userid = new HashMap<Integer, Integer>();
		HashMap<Integer, String> id_date = new HashMap<Integer, String>();
		HashMap<Integer, String> id_time = new HashMap<Integer, String>();
		HashMap<Integer, String> id_desc = new HashMap<Integer, String>();
		ArrayList<Integer> order_list = new ArrayList<Integer>(); 



		String fname = null;
		String lname = null;

		ResultSet result = null;
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		PreparedStatement pstmt = null;
		if(conn!=null)
		try{

		String sql = null;



		sql = "select * from appointment where appt_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, app_id);
		result = pstmt.executeQuery();

		while(result.next()) {

		int id = result.getInt("appt_id");
		int p_id = result.getInt("patient_id");
		String date = result.getString("date");
		String time = result.getString("slottime");
		String desc = result.getString("description");
		System.out.println("appt id:"+id);
		System.out.println("appt id:"+date);
		System.out.println("appt id:"+time);
		System.out.println("appt id:"+desc); 

		sql = "select first_name,last_name from patient where patient_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, p_id);
		ResultSet rs = pstmt.executeQuery();
		String name=null;

		while(rs.next()) {

		fname = rs.getString("first_name");
		lname = rs.getString("last_name");
		name = fname+" "+lname;
		}

		System.out.println("name:"+name);

		order_list.add(id);
		id_name.put(id, name);
		id_date.put(id, date);
		id_time.put(id, time);
		id_desc.put(id, desc);
		id_userid.put(id, p_id);
		}
		AppointmentDetails details = new AppointmentDetails();
		details.setOrder_list(order_list);
		details.setId_name(id_name);
		details.setId_appid(id_appid);
		details.setId_date(id_date);
		details.setId_time(id_time);
		details.setId_desc(id_desc);
		details.setId_userid(id_userid);


		System.out.println(result);
		} catch(SQLException e) {
		System.out.println("In search"+e);
		}
		DM.close(); 

		}
}
