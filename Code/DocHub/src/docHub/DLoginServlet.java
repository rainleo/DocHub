package docHub;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DLoginServlet
 */
public class DLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.retrive all the parameters from JSP page
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		if(email.equals(null)||email==""||pass.equals(null)||pass==""){
			request.setAttribute("msgg", "All Fields are mandatory");
			getServletContext().getRequestDispatcher("/DLogin.jsp").forward(request, response);
		}else{
			
		//2.set all values in Model class' object
			Doctor1 m = new Doctor1();
			m.setEmail(email);
			m.setPass(pass);
			
			String sql="select * from doctor where email_id=? and pass=?";
			
			
			//3. call a method in Dao to select data form table
			HttpSession session	= request.getSession();	
			ResultSet rs = DaoDoctor.LoginUser(m,sql);
			
			try {
				if(rs.next()){
					session.setAttribute("user_type", "doctor");
					session.setAttribute("userid", rs.getInt(1));
					session.setAttribute("fname", rs.getString(2));
					session.setAttribute("lname", rs.getString(3));
					session.setAttribute("gender", rs.getString(4));
					session.setAttribute("dob", rs.getString(5));
					session.setAttribute("email", rs.getString(6));
					session.setAttribute("pass", rs.getString(7));
					session.setAttribute("seques", rs.getString(8));
					session.setAttribute("seanws", rs.getString(9));
					
					session.setAttribute("d_phone", rs.getString(10));
					session.setAttribute("d_addressLine1", rs.getString(11));
					session.setAttribute("d_addressLine2", rs.getString(12));
					session.setAttribute("d_city", rs.getString(13));
					session.setAttribute("d_state", rs.getString(14));
					session.setAttribute("d_country", rs.getString(15));
					session.setAttribute("d_zipCode", rs.getString(16));
					session.setAttribute("d_insCovered", rs.getString(17));
					session.setAttribute("d_licenseNumber", rs.getString(18));
					session.setAttribute("d_specialization", rs.getString(19));
					
					//the viewappointments.jsp can use all the attributes listed above just like PLoginServlet doing to the 'searchdoctor.jsp' page
					//and viewappointments.jsp should have one more navigator (href)for doctor to 'update info' and it can link to UpdateDoctor.jsp
					//I have sent the my modified searchdoctor.jsp as a reference 
					
					getServletContext().getRequestDispatcher("/ViewAppointmentServlet").forward(request, response);
				}else{
					request.setAttribute("msgg", "E-mail/Password do not match");
					getServletContext().getRequestDispatcher("/DLogin.jsp").forward(request, response);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}