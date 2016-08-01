package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDoctorServlet
 */
public class RegisterDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDoctorServlet() {
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
		String insurCover=request.getParameter("d_insCovered");
		String licenceNo=request.getParameter("d_licenceNo");
		String specialization=request.getParameter("d_specialization");
		String addressline1=request.getParameter("d_addressLine1");
		String addressline2=request.getParameter("d_addressLine2");
		String city=request.getParameter("d_city");
		String state=request.getParameter("d_state");
		String country=request.getParameter("d_country");
		String zipcode=request.getParameter("d_zipCode");
		String phone=request.getParameter("d_phone");

		Doctor d=new Doctor();
		d.setFirstname(fname);
		d.setLastname(lname);
		d.setDateOfBirth(dob);
		d.setEmailId(email);
		d.setGender(gender);
		d.setPassword(password);
		d.setSecurityQuestion(secQuestion);
		d.setSecurityAnswer(secAnswer);
		d.setInsuranceCovered(insurCover);
		d.setLicenseNumber(licenceNo);
		d.setSpecialization(specialization);
		d.setAddress1(addressline1);
		d.setAddress2(addressline2);
		d.setCity(city);
		d.setState(state);
		d.setCountry(country);
		d.setZipCode(zipcode);
		d.setPhoneNumber(phone);
		
		RegisterDAO regdao=new RegisterDAO();
		regdao.insertDoctor(d);
		
		request.getRequestDispatcher("DLogin.jsp").forward(request, response);
		 

		
	}

}
