package docHub;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DReviewServlet
 */
//@WebServlet("/DReviewServlet")
public class DReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int doctor_id;
		if(request.getSession().getAttribute("user_type").equals("patient")){
	 doctor_id =Integer.parseInt(request.getParameter("doctor_id"));
		}
		else {
			doctor_id=(Integer)request.getSession().getAttribute("userid");
		}
		System.out.println(doctor_id);
		String Doctor_name=null;
		DataConnectionManager DM1 =  new DataConnectionManager();
		Connection conn1 = DM1.getConnection();
		try{
			Statement st  = conn1.createStatement();
			ResultSet rs = st.executeQuery("select * from doctor where doctor_id = '"+doctor_id+"'");
			while(rs.next()){
				Doctor_name = rs.getString("first_name");
				Doctor_name = Doctor_name+ " "+ rs.getString("last_name");
			}
			DM1.close();
		}
		catch(SQLException e){
		e.printStackTrace();
		}
		request.setAttribute("Doctor_name", Doctor_name);
		DataConnectionManager DM =  new DataConnectionManager();
		Connection conn = DM.getConnection();
		ArrayList<String> review = new ArrayList<String>();
		try{
		Statement st  = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from reviewfeed where doctor_id = '"+doctor_id+"' order by timefeed desc");
		
		while(rs.next()){
			review.add(rs.getString("content"));
			
		}
		DM.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		request.setAttribute("id", doctor_id);
		request.setAttribute("review", review);
		RequestDispatcher rd = request.getRequestDispatcher("DReview.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
