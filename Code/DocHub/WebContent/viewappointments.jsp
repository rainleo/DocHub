<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointments</title>
<link href="css/common.css" rel="stylesheet">
<script type="text/javascript">
function MyFunction(app_id)
{
	var id = app_id;
	//alert("hi");
	document.getElementById("appt_id").value = id;
	//alert(app_id);

}

</script>
</head>
<body>
<div class="header">
<div style="float:right" >
            
    </div>
<h1 class="for_head">DocHub</h1>
</div>

<div class="nav">
	<a href="searchdoctor.jsp" class="menu">Search Doctor</a><br>
	<a href="aboutus.jsp" class="menu">About us</a><br>
	<a href="viewappointments.jsp" class="menu" onclick="submitMyForm()">View appointments</a><br>
	<a href="contactus.jsp" class="menu">Contact us</a><br>
	<a href="help.jsp" class="menu">Help</a><br>
	<a href="Welcome.html" class="menu">Log Out</a><br>
</div>

<div class="section">
	<%String err=(String)session.getAttribute("err_search");
		if(err!=null) 
			out.print(err);
	request.getSession().removeAttribute("err_search");%>
	
	
	<table class="section"  border="1">
	<% 
	ArrayList<Integer> order_list = (ArrayList<Integer>)session.getAttribute("order_list");
    HashMap<Integer, String> id_name = (HashMap<Integer, String>)session.getAttribute("id_name");
	HashMap<Integer, Integer> id_appid = (HashMap<Integer, Integer>)session.getAttribute("id_appid");
	HashMap<Integer, String> id_date= (HashMap<Integer, String>)session.getAttribute("id_date");
	HashMap<Integer, String> id_time = (HashMap<Integer, String>)session.getAttribute("id_time");
	HashMap<Integer, String> id_desc = (HashMap<Integer, String>)session.getAttribute("id_desc");

    if(order_list.size()>0){
    	%>
    	<tr>
    		<td><u>Name</u></td>
    		<td><u>date</u></td>
    		<td><u>time</u></td>
    		<td><u>Description</u></td>
    		
    	</tr>
    	<%
    for(Integer i:order_list) {
    	String id = i.toString();%>
    	<form action="ViewAppointmentServlet" method="post">
    	
    	<tr>
    	    <td><%=id_name.get(i) %></td>    	
    		<td><%=id_date.get(i) %></td> 
    		<td><%=id_time.get(i).toString() %></td>
    		<td><%=id_desc.get(i) %></td>
    		
    		<td><input type="submit" value="Cancel" id=<%=i %> onclick="MyFunction(this.id)"></td>
		</tr>
		<% 	
   	}}
    //request.getSession().removeAttribute("ids_specia");
	//request.getSession().removeAttribute("ids_names");
	//request.getSession().removeAttribute("order_list");
	%>
	
		    		<input type="hidden" id="appt_id" name="appt_id"  value="" />
		    		
		
		</form>
		
   </table>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>