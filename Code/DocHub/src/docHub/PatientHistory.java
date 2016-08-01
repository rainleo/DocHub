package docHub;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientHistory {

public static void getHistory(Integer patient_id) {
		
		HashMap<Integer, String> Hid_name = new HashMap<Integer, String>();
		HashMap<Integer, String> Hid_date = new HashMap<Integer, String>();
		HashMap<Integer, String> Hid_feed = new HashMap<Integer, String>();
		ArrayList<Integer> Horder_list = new ArrayList<Integer>();
		
		
		String fname = null;
		String lname = null;
		
		ResultSet result = null;
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		PreparedStatement pstmt = null;
		if(conn!=null)
		try{
			
			
				String sql = null;
				sql = "select * from feedback where patient_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, patient_id);
				result = pstmt.executeQuery();
				
				while(result.next()) {
					
					int id = result.getInt("appt_id");
					int d_id = result.getInt("doctor_id");
					String date = result.getString("date");
					String feedback = result.getString("feedback");
					//System.out.println("appt id:"+id);
					//System.out.println("date:"+date);
					//System.out.println("pati id:"+d_id);
					//System.out.println("id:"+feedback);				
					
					sql = "select first_name,last_name from doctor where doctor_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, patient_id);
					ResultSet rs = pstmt.executeQuery();
					String name=null;
					
					while(rs.next()) {
						
						fname = rs.getString("first_name");
						lname = rs.getString("last_name");
						name = fname+" "+lname;
					}
					
					System.out.println("name:"+name);
					
					Horder_list.add(id);
					Hid_name.put(id, name);
					Hid_date.put(id, date);
					Hid_feed.put(id, feedback);
					
					}
				
				HistoryDetails details = new HistoryDetails();
				details.setHorder_list(Horder_list);
				details.setHid_date(Hid_date);
				details.setHid_name(Hid_name);
				details.setHid_feed(Hid_feed);
				

				
				System.out.println("in dao list size " + Horder_list.size());

		} catch(SQLException e) {
			System.out.println("In search"+e);
		}
		DM.close();	
	}
	
	public static void postFeedback(Integer doc_id, int app_id, String feedback) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("have to give feedback ");
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();

		//PreparedStatement pstmt = null;
		if(conn!=null) {
			
			int p_id =0;
			
			PreparedStatement p = conn.prepareStatement("select * from appointment where appt_id=? ");
			p.setInt(1, app_id);
			ResultSet rs2 = p.executeQuery();
			if(rs2.next()) {
				p_id = rs2.getInt("patient_id");				
			}
			
			PreparedStatement ps = conn.prepareStatement("insert into feedback(appt_id,patient_id,doctor_id,date,feedback)"+"values(?,?,?,?,?)");
			ps.setInt(1, app_id);
			ps.setInt(2, p_id);
			ps.setInt(3, doc_id);
			ps.setDate(4, getCurrentDate());
			ps.setString(5, feedback);			
			ps.execute();
	
			String sql="delete from appointment where appt_id=?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, app_id);
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DM.close();
		
		
	}
	
	private static Date getCurrentDate() {
	    java.util.Date date = new java.util.Date();
	    return new Date(date.getTime());
	}
}
