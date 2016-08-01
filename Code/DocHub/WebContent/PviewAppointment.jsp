<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointments</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript">
function MyFunction(app_id)
{
	var id = app_id;
	//alert("hi");
	document.getElementById("appt_id").value = id;
	//alert(app_id);

}
//alert("hi");

</script>
</head>
<body>

<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertPatient.html" %>
</div>


	<%String err=(String)session.getAttribute("err_search");
		if(err!=null) 
			out.print(err);
	request.getSession().removeAttribute("err_search");%>
	
	
	
	<% 
	ArrayList<Integer> order_list = (ArrayList<Integer>)session.getAttribute("order_list");
    HashMap<Integer, String> id_name = (HashMap<Integer, String>)session.getAttribute("id_name");
	HashMap<Integer, Integer> id_appid = (HashMap<Integer, Integer>)session.getAttribute("id_appid");
	HashMap<Integer, String> id_date= (HashMap<Integer, String>)session.getAttribute("id_date");
	HashMap<Integer, String> id_time = (HashMap<Integer, String>)session.getAttribute("id_time");
	HashMap<Integer, String> id_desc = (HashMap<Integer, String>)session.getAttribute("id_desc");

	%>
    	<div class="form">
    	<form action="ViewAppointmentServlet" method="post">
    	<h1>My Appointments</h1>
	<hr>
	<%
	if(order_list.size()>0){
	   %>
	   <table border=2>
    	<col width="120">
    	<col width="120">
    	<col width="120">
    	<col width="120">
    	<tr>
    		<th>DoctorName</th>
    		<th>Date</th>
    		<th>Time</th>
    		<th>Specialization</th>
    			
    		
    	</tr>
	   <% 
	    for(Integer i:order_list) {
	    	String id = i.toString();
	%>
    	
    	<tr>
    	    <td><%=id_name.get(i) %></td>    	
    		<td><%=id_date.get(i) %></td> 
    		<td><%=id_time.get(i).toString() %></td>
    		<td><%=id_desc.get(i) %></td>
    		
		
    		 <td><input type="submit" class="button" value="Cancel" id=<%=i %> onclick="MyFunction(this.id)"></td>
    		
		</tr>
		
		<% 	
   	}
	%>
	</table>
	<%   
	}
    else
    {
    %>
    <span>No appointments available</span>
    <%
    }
    
   
    //request.getSession().removeAttribute("ids_specia");
	//request.getSession().removeAttribute("ids_names");
	//request.getSession().removeAttribute("order_list");
	%>
	
		    			    		
		      		
		    		
		 
		 <input type="hidden" id="appt_id" name="appt_id"  value="" />
		</form>
		
  
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>