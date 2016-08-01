package docHub;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryDetails {

	private static HashMap<Integer, String> Hid_name;
	private static HashMap<Integer, String> Hid_date;
	private static HashMap<Integer, String> Hid_feed;
	private static ArrayList<Integer> Horder_list = new ArrayList<Integer>();
	
	public static HashMap<Integer, String> getHid_name() {
		return Hid_name;
	}
	public static void setHid_name(HashMap<Integer, String> hid_name) {
		Hid_name = hid_name;
	}
	public static HashMap<Integer, String> getHid_date() {
		return Hid_date;
	}
	public static void setHid_date(HashMap<Integer, String> hid_date) {
		Hid_date = hid_date;
	}
	public static HashMap<Integer, String> getHid_feed() {
		return Hid_feed;
	}
	public static void setHid_feed(HashMap<Integer, String> hid_feed) {
		Hid_feed = hid_feed;
	}
	public static ArrayList<Integer> getHorder_list() {
		return Horder_list;
	}
	public static void setHorder_list(ArrayList<Integer> horder_list) {
		Horder_list = horder_list;
	}

	
}
