package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateDoctorServlet
 */
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorServlet() {
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
		//doGet(request, response);
		String email = request.getParameter("email");
		String d_insCovered=request.getParameter("d_insCovered");
		String d_specialization=request.getParameter("d_specialization");
		String d_addressLine1=request.getParameter("d_addressLine1");
		String d_addressLine2=request.getParameter("d_addressLine2");
		String d_city=request.getParameter("d_city");
		String d_state=request.getParameter("d_state");
		String d_country=request.getParameter("d_country");
		String d_zipCode=request.getParameter("d_zipCode");
		String d_phone=request.getParameter("d_phone");
		
		HttpSession session	= request.getSession();
		
		Doctor doc = new Doctor();
		
		doc.setEmailId(email);
		doc.setInsuranceCovered(d_insCovered);
		doc.setSpecialization(d_specialization);
		doc.setAddress1(d_addressLine1);
		doc.setAddress2(d_addressLine2);
		doc.setCity(d_city);
		doc.setState(d_state);
		doc.setCountry(d_country);
		doc.setZipCode(d_zipCode);
		doc.setPhoneNumber(d_phone);
		
		String sql="update doctor set insurances_covered=?,specialization=?,addressline1=?,addressline2=?,city=?,state=?,country=?,zipcode=?,phone_number=? where email_id=?";
		
		int i = DaoDoctor.updateDoctor(doc,sql);
		System.out.println("Dong:"+i);
		if(i!=0){
			session.setAttribute("d_insCovered", d_insCovered);
			session.setAttribute("d_specialization", d_specialization);
			session.setAttribute("d_addressLine1", d_addressLine1);
			session.setAttribute("d_addressLine2", d_addressLine2);
			session.setAttribute("d_city", d_city);
			session.setAttribute("d_state", d_state);
			session.setAttribute("d_zipCode", d_zipCode);
			session.setAttribute("d_country", d_country);
			session.setAttribute("d_phone", d_phone);	
			
			//this "SuccessUP" is the feedback to the doc in /viewappointments.jsp or whatever this Servlet may lead to
			request.setAttribute("SuccessUP", "User Updated secessfully");
			getServletContext().getRequestDispatcher("/UpdateDoctor.jsp").forward(request, response);
		}else{
			System.out.println("No");
			request.setAttribute("SuccessUP", "User not Updated");
			getServletContext().getRequestDispatcher("/UpdateDoctor.jsp").forward(request, response);
		}
	}

}
