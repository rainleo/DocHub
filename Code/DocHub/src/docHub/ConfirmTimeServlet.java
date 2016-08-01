package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmTimeServlet
 */
public class ConfirmTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int doctor_id=Integer.parseInt(request.getParameter("doctor_id"));
		
		String date_apt=request.getParameter("date_apt");
		
		String slot = request.getParameter("slots"); 
		System.out.println(slot);
		String slots[]=slot.split(",");
		for(int i=0;i<slots.length;i++)
		System.out.println("slota:"+slots[i]);
		
		AppointmentDAO app=new AppointmentDAO();

		if(app.isScheduleExist(doctor_id, date_apt))
			app.updateDoctorSchedule(slots, doctor_id, date_apt);
		else
			app.insertDoctorSchedule(slots, doctor_id, date_apt);
		
		 request.setAttribute("date_apt",date_apt);
		 request.getRequestDispatcher("ThankAvailability.jsp").forward(request, response);
	}

}
