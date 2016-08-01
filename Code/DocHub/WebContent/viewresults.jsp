<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Results</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript">
function MyFunction(d_id)
{
	var id = d_id;
	//alert("hi");
	document.getElementById("doctor_id").value = id;
	//alert(d_id);

}
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
		
	%>

		
	

<div class="form">
<form action="SearchDoctorServlet" method="post">
<h1>Search</h1>
<hr>

<div class="tableform">
<table>
<tr><td><label for="search">Search by Name:</label><input type="text" name="doctor_name"/></td></tr>
<tr>
<td><label for="d_specialization">Specialization:</label>

<select name="specialization" id="specialization">
                <option value="none">--------SELECT--------</option>
                <option value="general">General Physician</option>
				<option value="cardiologist">Cardiologist</option>
				<option value="pediatrician">Pediatrician</option>
				<option value="ob/gyn">Ob/Gyn</option>
				<option value="dentist">Dentist</option>
				<option value="dermatologist">Dermatologist</option>
				<option value="ent">ENT</option>
</select></td>


</tr>
<tr><td><input type="submit" class="button" value="Search"/></td></tr>		
</table>
</div>
<%if(err!=null){ %>
<span><%=err %></span>
<%request.getSession().removeAttribute("err_search");} %>
</form>
</div>


	<br />
	



	<% HashMap<Integer, String> ids_names = (HashMap<Integer, String>)session.getAttribute("ids_names");
	ArrayList<Integer> order_list = (ArrayList<Integer>)session.getAttribute("order_list");
	HashMap<Integer, String> ids_specia = (HashMap<Integer, String>)session.getAttribute("ids_specia");
	HashMap<Integer, ArrayList<String>> ids_details = (HashMap<Integer, ArrayList<String>>)session.getAttribute("ids_details"); 
    if(order_list.size()>0){
    	%>
    	<div class="form2">
    	<form action="AppointmentServlet" method="post">
    	<table border=1>
    	<col width="200">
 		 <col width="200">
 		 
    	<tr>
    		<th>Doctor Name</th>
    		<th>Specialization</th>
    		<th>Link</th>
    		<th>Review</th>
    	</tr>
    	<%
    for(Integer i:order_list) {
    	String id = i.toString();%>
    	
    	
    	<tr>
    		<td><%=ids_names.get(i).toUpperCase() %></td>
    		<td><%=ids_specia.get(i).toUpperCase() %></td>
    		<td><input type="submit" class="button" value="Book" id=<%=i %> onclick="MyFunction(this.id)"></td>
    		<td><button class="button"><a href="/DocHub/ReviewServlet?doctor_id=<%=i %>" id=<%=i %>  onclick="MyFunction(this.id)">Review</a></button></td>
		</tr>
		<% 	
   	}}
    //request.getSession().removeAttribute("ids_specia");
	//request.getSession().removeAttribute("ids_names");
	//request.getSession().removeAttribute("order_list");
	%>
	
		    		
		    		
		
		
		
   </table>
   <input type="hidden" id="doctor_id" name="doctor_id"  value="" />
</form>
</div>
<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>