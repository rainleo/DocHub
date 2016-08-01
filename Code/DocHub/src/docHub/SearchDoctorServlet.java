package docHub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchDoctor
 */
@WebServlet("/SearchDoctorServlet")
public class SearchDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctorServlet() {
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
		String doc_name = request.getParameter("doctor_name").toString();
		String specialization = request.getParameter("specialization").toString();
		
		System.out.println(doc_name+", "+specialization);
		
		DataRetrieverSearch.search(doc_name, specialization);
		SearchDetails details = new SearchDetails();
		HashMap<Integer, String> ids_names = details.getIds_names();
		HashMap<Integer, String> ids_specia = details.getIds_specia();
		HashMap<Integer, ArrayList<String>> ids_details = details.getIds_details();
		ArrayList<Integer> order_list = details.getOrder_list();
		
		if(!(ids_names.size()>0)) {
			String error = "<h3>No doctors available with given filer values</h3>";
			request.getSession().setAttribute("err_search", error);
		}
		request.getSession().setAttribute("ids_details",ids_details);
		request.getSession().setAttribute("order_list", order_list);
		request.getSession().setAttribute("ids_names",ids_names);
		request.getSession().setAttribute("ids_specia", ids_specia);
		
	    response.sendRedirect("viewresults.jsp");

		int len = order_list.size();
	}

}
