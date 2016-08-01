package docHub;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookAppontmentServlet
 */
public class BookAppontmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppontmentServlet() {
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
		
		String time=request.getParameter("time");
		String slot=request.getParameter("slot");
		String description=request.getParameter("desc");
		 String date_apt=request.getParameter("date_apt");
		int doctor_id=Integer.parseInt(request.getParameter("doctor_id"));
		HttpSession session=request.getSession();
		int patient_id=(Integer)session.getAttribute("userid");
		System.out.println("TIME:"+time);
		Doctor dr=new Doctor();
		AppointmentDAO AppDao=new AppointmentDAO();
		dr=AppDao.getDoctorDetails(doctor_id);
		
		/*
		 String date_apt=request.getParameter("date_apt");

		Doctor dr=new Doctor();
		AppointmentDAO AppDao=new AppointmentDAO();
		String slot=AppDao.getSlot(time);
		
		dr=AppDao.getDoctorDetails(doctor_id);
		AppDao.insertAppointment(date_apt,doctor_id,patient_id,slot,time,description);
		AppDao.updateDoctorSlot(slot,doctor_id,date_apt);
		try
		{
			String msg="<html><body><h4>Hi Varun,<br><br>Thank you for booking an appointment at DocHub<br>Your appointment details:-</h4><br>"
					+ "<table border=2><tr><th>Doctor Name</th><th>Doctor Specialization</th><th>Doctor Contact</th><th>Appointment Date</th><th>Appointment Time</th></tr>"
					+ "<tr><td>"+dr.getFirstname()+"</td><td>"+dr.getSpecialization()+"</td><td>"+dr.getPhoneNum()+"</td><td>"+date_apt+"</td><td>"+time+"</td><tr></table></body></html>";
		//String msg="Thank you for booking an appointment at DocHub\n Your appointment details:- \nDoctor Name:"+dr.getFirstname()+"\nDate:"+date_apt+"\nTime:"+time;
		Send_Email.sendEmail("smtp.gmail.com", "587", "dochub2016@gmail.com", "dochubse", "vnarayanan@albany.edu", "--------Appointment Confirmation---------",msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		*/
		 //int first=1;
	      request.setAttribute("doc",dr);
	      request.setAttribute("slot",slot);
	      request.setAttribute("time",time);
	      request.setAttribute("description",description);
	      request.setAttribute("date_apt",date_apt);
	      request.setAttribute("patient_id",patient_id);
	        //System.out.println(slots.get(0));
	       // request.setAttribute("slots", slots);
		request.getRequestDispatcher("ConfirmAppointment.jsp").forward(request, response);
		
	}

}
