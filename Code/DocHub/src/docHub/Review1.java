package docHub;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Review1
 */
//@WebServlet("/Review1")
public class Review1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String review = request.getParameter("review");
		int id = Integer.parseInt(request.getParameter("id"));
		String Doctor_name=null;
		DataConnectionManager DM1 =  new DataConnectionManager();
		Connection conn1 = DM1.getConnection();
		try{
			Statement st  = conn1.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM doctor WHERE doctor_id = '"+id+"'");
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
		PreparedStatement pstmt1;
		ArrayList<String> data = new ArrayList<String>();
		try {
			pstmt1 = conn.prepareStatement("INSERT INTO reviewfeed(doctor_id,timefeed,content) VALUES(?, ?, ?)");
			pstmt1.setString(3,  review);
			pstmt1.setInt(1,  id);
			pstmt1.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

			int i = pstmt1.executeUpdate();
			
			System.out.println("HI:"+id);
			Statement st  = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM reviewfeed WHERE doctor_id = '"+id+"' ORDER BY timefeed DESC");
			System.out.println("HI:"+id);
			while(rs.next()){
				data.add(rs.getString("content"));
				
			}
			DM.close();
			
			
			
			
		}catch(SQLException s){
			s.printStackTrace();
		}
		System.out.println("HI:"+id);
		request.setAttribute("id", id);
		request.setAttribute("review", data);
		System.out.println("HI:"+id);
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
