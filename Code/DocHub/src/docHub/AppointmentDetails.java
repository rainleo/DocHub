package docHub;

import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentDetails {
	private static ArrayList<Integer> order_list = new ArrayList<Integer>();
	private static HashMap<Integer, String> id_name = new HashMap<Integer, String>();
	private static HashMap<Integer, Integer> id_appid = new HashMap<Integer, Integer>();
	private static HashMap<Integer, String> id_date;
	private static HashMap<Integer, String> id_time;
	private static HashMap<Integer, String> id_desc;
	private static HashMap<Integer, Integer> id_userid;
	
	
	public static ArrayList<Integer> getOrder_list() {
		return order_list;
	}
	public static void setOrder_list(ArrayList<Integer> order_list) {
		AppointmentDetails.order_list = order_list;
	}
	public static HashMap<Integer, String> getId_name() {
		return id_name;
	}
	public static void setId_name(HashMap<Integer, String> id_names) {
		AppointmentDetails.id_name = id_names;
	}
	public static HashMap<Integer, Integer> getId_appid() {
		return id_appid;
	}
	public static void setId_appid(HashMap<Integer, Integer> id_appid) {
		AppointmentDetails.id_appid = id_appid;
	}
	public static HashMap<Integer, String> getId_date() {
		return id_date;
	}
	public static void setId_date(HashMap<Integer, String> id_date) {
		AppointmentDetails.id_date = id_date;
	}
	public static HashMap<Integer, String> getId_time() {
		return id_time;
	}
	public static void setId_time(HashMap<Integer, String> id_time) {
		AppointmentDetails.id_time = id_time;
	}
	public static HashMap<Integer, String> getId_desc() {
		return id_desc;
	}
	public static void setId_desc(HashMap<Integer, String> id_desc) {
		AppointmentDetails.id_desc = id_desc;
	}
	public static HashMap<Integer, Integer> getId_userid() {
		return id_userid;
	}
	public static void setId_userid(HashMap<Integer, Integer> id_userid) {
		AppointmentDetails.id_userid = id_userid;
	}
	

}
