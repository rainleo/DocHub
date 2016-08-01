package docHub;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchDetails {
	private static ArrayList<Integer> order_list = new ArrayList<Integer>();
	private static HashMap<Integer, String> ids_names = new HashMap<Integer, String>();
	private static HashMap<Integer, ArrayList<String>> ids_details = new HashMap<Integer, ArrayList<String>>();
	private static HashMap<Integer, String> ids_specia;


	public static HashMap<Integer, String> getIds_names() {
		return ids_names;
	}

	public static void setIds_names(HashMap<Integer, String> ids_names) {
		SearchDetails.ids_names = ids_names;
	}

	public void setOrder_list(ArrayList<Integer> order_list) {
		// TODO Auto-generated method stub
		SearchDetails.order_list = order_list;
	}

	public static ArrayList<Integer> getOrder_list() {
		return order_list;
	}

	public HashMap<Integer, String> getIds_specia() {
		// TODO Auto-generated method stub
		return ids_specia;
	}

	public static void setIds_specia(HashMap<Integer, String> ids_specia) {
		SearchDetails.ids_specia = ids_specia;
	}

	public void setIds_details(HashMap<Integer, ArrayList<String>> ids_details) {
		// TODO Auto-generated method stub
		SearchDetails.ids_details = ids_details;
		
	}

	public static HashMap<Integer, ArrayList<String>> getIds_details() {
		return ids_details;
	}
	
	
}
