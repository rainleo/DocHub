package docHub;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String user_type = (String) request.getSession().getAttribute("user_type");
		int doc_id = (Integer) request.getSession().getAttribute("userid");
		int p_id = Integer.parseInt(request.getParameter("patient_id"));
				
				
				
		String feedback = request.getParameter("feedback");
		int app_id = Integer.parseInt(request.getParameter("appt_id"));
		
		System.out.println("docid : " + doc_id + app_id + feedback);
		try {
			
			PatientHistory.postFeedback(doc_id, app_id, feedback);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		ViewAppointment.Search(user_type,doc_id);
		
		AppointmentDetails details = new AppointmentDetails();
		HashMap<Integer, String> id_name = details.getId_name();
		HashMap<Integer, String> id_date = details.getId_date();
		HashMap<Integer, String> id_time = details.getId_time();
		HashMap<Integer, String> id_desc = details.getId_desc();
		HashMap<Integer, Integer> id_appid = details.getId_appid();
		HashMap<Integer, Integer> id_userid = details.getId_userid();

		ArrayList<Integer> order_list = details.getOrder_list();
		
		System.out.println("reddy");

		request.getSession().setAttribute("id_name",id_name);
		request.getSession().setAttribute("id_date", id_date);
		request.getSession().setAttribute("id_time",id_time);
		request.getSession().setAttribute("id_desc", id_desc);
		request.getSession().setAttribute("id_userid", id_userid);

		request.getSession().setAttribute("id_appid",id_appid);
		request.getSession().setAttribute("order_list",order_list);
		
		request.getSession().setAttribute("patient_id",p_id);
		getServletContext().getRequestDispatcher("/PatientHistoryServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
