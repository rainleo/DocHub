package docHub;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class ReviewServlet
 */
//@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		System.out.println(doctor_id);
		String Doctor_name=null;
		DataConnectionManager DM1 =  new DataConnectionManager();
		Connection conn1 = DM1.getConnection();
		try{
			Statement st  = conn1.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM doctor WHERE doctor_id = '"+doctor_id+"'");
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
		ResultSet rs = st.executeQuery("SELECT * FROM reviewfeed WHERE doctor_id = '"+doctor_id+"' ORDER BY timefeed DESC");
		
		while(rs.next()){
			review.add(rs.getString("content"));
			
		}
		DM.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		request.setAttribute("id", doctor_id);
		request.setAttribute("review", review);
		RequestDispatcher rd = request.getRequestDispatcher("Review.jsp");
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
