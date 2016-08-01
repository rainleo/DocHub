package docHub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String user=request.getParameter("PatientRadio");
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("genderRadio");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String secQuestion=request.getParameter("secQuestion");
		String secAnswer=request.getParameter("secAnswer");
		//System.out.println(gender);
		RegisterDAO regdao=new RegisterDAO();
		boolean alreadyExist=regdao.emailCheck(email, user);
		
		if(!alreadyExist)
		{
		if(user.equals("doctor"))
		{
			request.setAttribute("user", user);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("dob", dob);
			request.setAttribute("email", email);
			request.setAttribute("gender", gender);
			request.setAttribute("password", password);
			request.setAttribute("secQuestion", secQuestion);
			request.setAttribute("secAnswer", secAnswer);
			
			request.getRequestDispatcher("RegisterDoctor.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("user", user);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("secQuestion", secQuestion);
			request.setAttribute("secAnswer", secAnswer);
			
			request.getRequestDispatcher("RegisterPatient.jsp").forward(request, response);
		}
		}
		else
		{
			
			
			request.setAttribute("email", email);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
