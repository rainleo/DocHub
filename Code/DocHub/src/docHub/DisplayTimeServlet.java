package docHub;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayTimeServlet
 */
public class DisplayTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTimeServlet() {
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
        String date_apt = request.getParameter("datepicker");
        AppointmentDAO app=new AppointmentDAO();
        
        
        ArrayList<Boolean> slots=new ArrayList<Boolean>();
        slots=app.getDoctorSchedule(doctor_id, date_apt);
      
       
        
        
        Doctor dr=new Doctor();
        
        dr= app.getDoctorDetails(doctor_id);
        int first=1,second=1;
        request.setAttribute("first",first);
        request.setAttribute("second",second);
        request.setAttribute("doc",dr);
        request.setAttribute("date", date_apt);
        request.setAttribute("date_apt", date_apt);

        request.setAttribute("slots",slots);
        request.getRequestDispatcher("EnterTimings.jsp").forward(request, response);
	}

}
