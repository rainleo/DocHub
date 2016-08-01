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
 * Servlet implementation class PLoginServlet
 */
public class PLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.retrive all the parameters from JSP page
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		
		if(email.equals(null)||email==""||pass.equals(null)||pass==""){
			request.setAttribute("msgg", "All Fields are mandatory");
			getServletContext().getRequestDispatcher("/PLogin.jsp").forward(request, response);
		}else{
			
		//2.set all values in Model class' object
			Patient1 m = new Patient1();
			
			m.setEmail(email);
			m.setPass(pass);
		
			String sql="select * from patient where email_id=? and pass=? ";
			
			
			
			//3. call a method in Dao to select data form table
			//also set a session
			HttpSession session	= request.getSession();	
			ResultSet rs = DaoPatient.LoginUser(m,sql);
			
			//set session attributes from the database result set 
			try {
				if(rs.next()){
					session.setAttribute("user_type", "patient");
					session.setAttribute("userid", rs.getInt(1));
					session.setAttribute("fname", rs.getString(2));
					session.setAttribute("lname", rs.getString(3));
					session.setAttribute("gender", rs.getString(4));
					session.setAttribute("dob", rs.getString(5));
					session.setAttribute("email", rs.getString(6));
					session.setAttribute("pass", rs.getString(7));
					session.setAttribute("seques", rs.getString(8));
					session.setAttribute("seanws", rs.getString(9));
					
					session.setAttribute("p_phone", rs.getString(10));
					session.setAttribute("p_addressLine1", rs.getString(11));
					session.setAttribute("p_addressLine2", rs.getString(12));
					session.setAttribute("p_city", rs.getString(13));
					session.setAttribute("p_state", rs.getString(14));
					session.setAttribute("p_country", rs.getString(15));
					session.setAttribute("p_zipCode", rs.getString(16));
					session.setAttribute("p_insProvider", rs.getString(17));
					session.setAttribute("p_insId", rs.getString(18));
					
					
					//pass session attribute to searchdoctor.jsp
					//use any attributes search page may need
					getServletContext().getRequestDispatcher("/searchdoctor.jsp").forward(request, response);
					//searchdoctor.jsp should have one more navigator (href)for patient to 'update info' and it can link to UpdatePtient.jsp
					//I have sent the my modified searchdoctor.jsp as a reference 
					
					//*request.getRequestDispatcher("/searchdoctor.jsp").forward(request, response);
				}else{
					request.setAttribute("msgg", "E-mail/Password do not match");
					getServletContext().getRequestDispatcher("/PLogin.jsp").forward(request, response);
					
				}
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
	}

}