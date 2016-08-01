package docHub;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnterTimeServlet
 */
public class EnterTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterTimeServlet() {
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
		String slots[] = request.getParameterValues("slot"); 
		 String date_apt=request.getParameter("date_apt");
		 
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<slots.length;i++)
		 {
			 sb.append(slots[i]);
			 sb.append(",");
		 }
		 String slot=sb.toString();
		 //System.out.println("slotb"+slot);
		if(slots.length>0)
		{
			
			/*	AppointmentDAO app=new AppointmentDAO();
			if(app.isScheduleExist(doctor_id, date_apt))
				app.updateDoctorSchedule(slots, doctor_id, date_apt);
			else
				app.insertDoctorSchedule(slots, doctor_id, date_apt);
			
			Doctor dr=new Doctor();
	        
	        dr= app.getDoctorDetails(doctor_id);
	        int second=1;
	        */
	       // request.setAttribute("second",second);
	        //request.setAttribute("doc",dr);
	       // request.setAttribute("date", date_apt);
	        request.setAttribute("date_apt", date_apt);
	        request.setAttribute("doctor_id",doctor_id);
	        request.setAttribute("slots", slot);
	        request.getRequestDispatcher("ConfirmAvailability.jsp").forward(request, response);
		}
		else
		{
			 request.getRequestDispatcher("/EnterTiming.jsp").forward(request, response);
		}
	}

}
