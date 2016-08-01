package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmAppServlet
 */
public class ConfirmAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmAppServlet() {
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
		HttpSession session=request.getSession();
		String time=request.getParameter("time");
		String description=request.getParameter("description");
		int doctor_id=Integer.parseInt(request.getParameter("doctor_id"));
		int patient_id=Integer.parseInt(request.getParameter("patient_id"));;
		String pat_ins=(String)session.getAttribute("p_insProvider");
		String date_apt=request.getParameter("date_apt");
		String slot=request.getParameter("slot");
		String p_email=(String)session.getAttribute("email");
		String p_fname=(String)session.getAttribute("fname");
		Doctor dr=new Doctor();
		AppointmentDAO AppDao=new AppointmentDAO();
//		String slot=AppDao.getSlot(time);
		//boolean isCovered=AppDao.isInsCovered(pat_ins,dr.getInsuranceCovered());
		dr=AppDao.getDoctorDetails(doctor_id);
		AppDao.insertAppointment(date_apt,doctor_id,patient_id,slot,time,description);
		AppDao.updateDoctorSlot(slot,doctor_id,date_apt);
		try
		{
			String msg="<html><body><h4>Hi "+p_fname+",<br><br>Thank you for booking an appointment at DocHub<br>Your appointment details:-</h4><br>"
					+ "<table border=2><tr><th>Doctor Name</th><th>Doctor Specialization</th><th>Doctor Contact</th><th>Appointment Date</th><th>Appointment Time</th></tr>"
					+ "<tr><td>"+dr.getFirstname()+"</td><td>"+dr.getSpecialization()+"</td><td>"+dr.getPhoneNum()+"</td><td>"+date_apt+"</td><td>"+time+"</td><tr></table></body></html>";
		//String msg="Thank you for booking an appointment at DocHub\n Your appointment details:- \nDoctor Name:"+dr.getFirstname()+"\nDate:"+date_apt+"\nTime:"+time;
		Send_Email.sendEmail("smtp.gmail.com", "587", "dochub2016@gmail.com", "dochubse",p_email, "--------Appointment Confirmation---------",msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		request.setAttribute("doc",dr);
	    request.setAttribute("time",time);
	    request.setAttribute("description",description);
	    request.setAttribute("date_apt",date_apt);
	    request.setAttribute("patient_id",patient_id);
	    System.out.println(pat_ins);
	    System.out.println(dr.getInsuranceCovered());
	    
	    if(pat_ins.equals(dr.getInsuranceCovered()))
	    request.getRequestDispatcher("ThankBooking.jsp").forward(request, response);
	    else
	    request.getRequestDispatcher("payment1.jsp").forward(request, response);	
	}

}
