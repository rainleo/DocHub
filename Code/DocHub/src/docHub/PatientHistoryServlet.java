package docHub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientHistoryServlet
 */
public class PatientHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_type = (String) request.getSession().getAttribute("user_type");
		int user_id = (Integer) request.getSession().getAttribute("userid");

		System.out.println("doC :" +user_type);
		//int userid = (Integer) request.getSession().getAttribute("patirnt_id");
		int patientid = 0;
		
		 if(user_type=="doctor") {
		patientid = Integer.parseInt(request.getParameter("patient_id"));
		System.out.println("p: "+patientid);
		} else {
			patientid = user_id;
		}
	
		PatientHistory.getHistory(patientid);

		HistoryDetails details = new HistoryDetails();
		HashMap<Integer, String> Hid_name = HistoryDetails.getHid_name();
		HashMap<Integer, String> Hid_date = details.getHid_date();
		HashMap<Integer, String> Hid_feed = details.getHid_feed();
		ArrayList<Integer> Horder_list = details.getHorder_list();
		System.out.println("list size " + Horder_list.size());
	
		request.getSession().setAttribute("Hid_name",Hid_name);
		request.getSession().setAttribute("Hid_date",Hid_date);
		request.getSession().setAttribute("Hid_feed",Hid_feed);
		request.getSession().setAttribute("Horder_list",Horder_list);
		
		
		
		 if(user_type=="doctor") {

			response.sendRedirect("DviewPatientHistory.jsp");
		 } else if (user_type=="patient") {
			 
			response.sendRedirect("PviewPatientHistory.jsp"); 
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in get");
		String user_type = (String) request.getSession().getAttribute("user_type");
		int userid = (Integer) request.getSession().getAttribute("userid");
		int appid = Integer.parseInt(request.getParameter("appt_id"));
		
		
		System.out.println("app: "+appid);
		ViewAppointment.SearchbyAppt(appid);
		
		AppointmentDetails details = new AppointmentDetails();
		HashMap<Integer, String> id_name = details.getId_name();
		HashMap<Integer, String> id_date = details.getId_date();
		HashMap<Integer, String> id_time = details.getId_time();
		HashMap<Integer, String> id_desc = details.getId_desc();
		HashMap<Integer, Integer> id_appid = details.getId_appid();
		HashMap<Integer, Integer> id_userid = details.getId_userid();

		ArrayList<Integer> order_list = details.getOrder_list();
		
		System.out.println("reddy");

		request.getSession().setAttribute("id_nam",id_name);
		request.getSession().setAttribute("id_dat", id_date);
		request.getSession().setAttribute("id_tim",id_time);
		request.getSession().setAttribute("id_des", id_desc);
		request.getSession().setAttribute("id_useri", id_userid);

		request.getSession().setAttribute("id_appi",id_appid);
		request.getSession().setAttribute("order_lis",order_list);

		
		if(user_type.equals("doctor")) {
		    response.sendRedirect("OpenAppointment.jsp");

		}
		
	}

}
