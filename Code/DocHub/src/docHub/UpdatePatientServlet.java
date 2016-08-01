package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdatePatientServlet
 */
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
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
		String email = request.getParameter("email");
		String insurProvider=request.getParameter("p_insProvider");
		String insuranceId=request.getParameter("p_insId");
		String addressline1=request.getParameter("p_addressLine1");
		String addressline2=request.getParameter("p_addressLine2");
		String city=request.getParameter("p_city");
		String state=request.getParameter("p_state");
		String country=request.getParameter("p_country");
		String zipcode=request.getParameter("p_zipCode");
		String phone=request.getParameter("p_phone");
		
		HttpSession session	= request.getSession();
		
		Patient pat=new Patient();
		
		pat.setEmailId(email);
		pat.setInsurance(insurProvider);
		pat.setInsuranceId(insuranceId);;
		pat.setAddress1(addressline1);
		pat.setAddress2(addressline2);
		pat.setCity(city);
		pat.setState(state);
		pat.setCountry(country);
		pat.setZipCode(zipcode);
		pat.setPhoneNumber(phone);
		
		
		String sql="update patient set insurance_provider=?,insurance_id=?,addressline1=?,addressline2=?,city=?,state=?,country=?,zipcode=?,phone_number=? where email_id=?";
		
		int i = DaoPatient.updatePatient(pat,sql);
		
		if(i!=0){
			session.setAttribute("p_insProvider", insurProvider);
			session.setAttribute("p_insId", insuranceId);
			session.setAttribute("p_addressLine1", addressline1);
			session.setAttribute("p_addressLine2", addressline2);
			session.setAttribute("p_city", city);
			session.setAttribute("p_state", state);
			session.setAttribute("p_zipCode", zipcode);
			session.setAttribute("p_country", country);
			session.setAttribute("p_phone", phone);	
			
			request.setAttribute("SuccessUP", "User Updated secessfully");
			getServletContext().getRequestDispatcher("/searchdoctor.jsp").forward(request, response);
		}else{
			request.setAttribute("SuccessUP", "User not Updated");
			getServletContext().getRequestDispatcher("/searchdoctor.jsp").forward(request, response);
		}
	
	}

}
