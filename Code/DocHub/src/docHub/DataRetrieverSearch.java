package docHub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataRetrieverSearch {

	public static void search(String doctor_name, String specialization) {
		HashMap<Integer, String> ids_names = new HashMap<Integer, String>();
		HashMap<Integer, String> ids_specia = new HashMap<Integer, String>();
		HashMap<Integer, ArrayList<String>> ids_details = new HashMap<Integer, ArrayList<String>>();
		ArrayList<Integer> order_list = new ArrayList<Integer>();
		ArrayList<String> details_list = new ArrayList<String>();
		
		System.out.println("before "+ doctor_name);
		String doc_name = doctor_name.trim();
		System.out.println("after "+ doc_name);
		String first_name = null;
		String last_name = null;
		
		
		ResultSet result = null;
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		//PreparedStatement pstmt = null;
		if(conn!=null)
		try{
			if(doc_name!="" && !(specialization.equals("none"))){
				String sql = null;
				PreparedStatement pstmt = null;
				if(doc_name.contains(" ")) {
					String[] parts = doc_name.split(" ");
					first_name = parts[0]; 
					last_name = parts[1];
					System.out.println("first "+ first_name + "    last :" + last_name);
					sql = "select * from doctor where first_name=? and last_name=? and specialization=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, first_name);
					pstmt.setString(2, last_name);
					pstmt.setString(3, specialization);
				} else {
				System.out.println("both are given");
				sql = "SELECT * FROM doctor WHERE (first_name=? or last_name=?) and specialization=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, doc_name);
				pstmt.setString(2, doc_name);
				pstmt.setString(3, specialization);
				}
				result = pstmt.executeQuery();
			} else if(doc_name=="" && (specialization.equals("none"))) {
				System.out.println("both are not given");
				String sql = "select * from doctor";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				result = pstmt.executeQuery();
			}
			else if(doc_name=="") {
				System.out.println("name is null");
				String sql = "select * from doctor where specialization=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, specialization);
				result = pstmt.executeQuery();
			} else if(specialization.equals("none")) {
				String sql = null;
				PreparedStatement pstmt = null;
				if(doc_name.contains(" ")) {
					String[] parts = doc_name.split(" ");
					first_name = parts[0]; 
					last_name = parts[1];
					System.out.println("first "+ first_name + "    last :" + last_name);
					sql = "select * from doctor where first_name=? and last_name=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, first_name);
					pstmt.setString(2, last_name);
				} else {
				System.out.println("only name");
				sql = "select * from doctor where first_name=? or last_name=?" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, doc_name);
				pstmt.setString(2, doc_name);
				}
				result = pstmt.executeQuery();
			} else;
			System.out.println("outside if-else");
			while(result.next()) {
				int id = result.getInt("doctor_id");
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				String specia = result.getString("specialization");
				String phone_number = result.getString("phone_number");
				String addressline1 = result.getString("addressline1");
				String addressline2	= result.getString("addressline2");
				String state = result.getString("state");
				String city = result.getString("city");
				String country = result.getString("country");
				String zipcode = result.getString("zipcode");
				String insurances_covered = result.getString("insurances_covered");
				
				
				String name = fname+" "+lname;
				
				details_list.add(name);
				details_list.add(specia);
				details_list.add(phone_number);
				details_list.add(addressline1);
				details_list.add(addressline2);
				details_list.add(state);
				details_list.add(city);
				details_list.add(country);
				details_list.add(zipcode);
				details_list.add(insurances_covered);
				
				ids_details.put(id, details_list);
				
				order_list.add(id);
				ids_names.put(id, name);
				ids_specia.put(id, specia);
			}
			SearchDetails details = new SearchDetails();
			details.setIds_details(ids_details);
			details.setOrder_list(order_list);
			details.setIds_names(ids_names);
			details.setIds_specia(ids_specia);
			
			System.out.println(result);
		} catch(SQLException e) {
			System.out.println("In search"+e);
		}
		DM.close();	
	}
}
