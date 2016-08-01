package docHub;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckAppontmentServlet
 */
public class CheckAppontmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAppontmentServlet() {
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
		
        AppointmentDAO AppDao=new AppointmentDAO();
        ArrayList<Boolean> slot_array=new ArrayList<Boolean>();
        System.out.println(date_apt);
        System.out.println(doctor_id);
        slot_array=AppDao.getDoctorTime(date_apt, doctor_id);
        //System.out.println(slot_array.get(0));
        ArrayList<String> slots=new  ArrayList<String>();
        
      //  if(slot_array.size()>0)
      //  slots=initSlots(slot_array);
       
        Doctor dr=new Doctor();
        
        dr= AppDao.getDoctorDetails(doctor_id);
        int first=1;
        request.setAttribute("first",first);
        //System.out.println(slots.get(0));
        request.setAttribute("date_apt", date_apt);
        
        request.setAttribute("doc",dr);
        request.setAttribute("slots", slot_array);
        request.setAttribute("date", date_apt);
		request.getRequestDispatcher("Appointment.jsp").forward(request, response);
        //System.out.println(date_apt);
        
	}
	
	public ArrayList<String> initSlots(ArrayList<Boolean> slot_array)
	{
		ArrayList<String> freeSlots=new ArrayList<String>();
		if(slot_array.get(0))
			freeSlots.add("09AM-10AM");
		if(slot_array.get(1))
			freeSlots.add("10AM-11AM");
		if(slot_array.get(2))
			freeSlots.add("11AM-12PM");
		if(slot_array.get(3))
			freeSlots.add("12PM-01PM");
		if(slot_array.get(4))
			freeSlots.add("02PM-03PM");
		if(slot_array.get(5))
			freeSlots.add("03PM-04PM");
		if(slot_array.get(6))
			freeSlots.add("04PM-05PM");
		if(slot_array.get(7))
			freeSlots.add("05PM-06PM");
		
		return freeSlots;
	}

}
