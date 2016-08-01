package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPatientServlet
 */
public class RegisterPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPatientServlet() {
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
		String user=request.getParameter("user");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		String secQuestion=request.getParameter("secQuestion");
		String secAnswer=request.getParameter("secAnswer");
		String insurProvider=request.getParameter("p_insProvider");
		String insuranceId=request.getParameter("p_insId");
		
		String addressline1=request.getParameter("p_addressLine1");
		String addressline2=request.getParameter("p_addressLine2");
		String city=request.getParameter("p_city");
		String state=request.getParameter("p_state");
		String country=request.getParameter("p_country");
		String zipcode=request.getParameter("p_zipCode");
		String phone=request.getParameter("p_phone");
		
		
		Patient pat=new Patient();
		pat.setFirstname(fname);
		pat.setLastname(lname);
		pat.setDateOfBirth(dob);
		pat.setEmailId(email);
		pat.setGender(gender);
		pat.setPassword(password);
		pat.setSecurityQuestion(secQuestion);
		pat.setSecurityAnswer(secAnswer);
		pat.setInsurance(insurProvider);
		pat.setInsuranceId(insuranceId);;
		pat.setAddress1(addressline1);
		pat.setAddress2(addressline2);
		pat.setCity(city);
		pat.setState(state);
		pat.setCountry(country);
		pat.setZipCode(zipcode);
		pat.setPhoneNumber(phone);
		
		RegisterDAO regdao=new RegisterDAO();
		regdao.insertPatient(pat);
		
		request.getRequestDispatcher("PLogin.jsp").forward(request, response);
		
		
	}

}
