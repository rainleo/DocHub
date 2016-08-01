<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Patient History</title>
<link href="css/registertest.css" rel="stylesheet">
</head>
<body>

<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertDoctor.html" %>
</div>

<div class="form">
	<form action="OpenAppointment.jsp" method="get">
		<h1>Patient History</h1>
		<hr>
		<input type="submit" class="button" value="Go Back" /><br><br><br>


<div class="tableform">
<table>
	<%
	ArrayList<Integer> Horder_list = (ArrayList<Integer>)session.getAttribute("Horder_list");
    HashMap<Integer, String> Hid_name = (HashMap<Integer, String>)session.getAttribute("Hid_name");
	HashMap<Integer, String> Hid_date= (HashMap<Integer, String>)session.getAttribute("Hid_date");
	HashMap<Integer, String> Hid_feed = (HashMap<Integer, String>)session.getAttribute("Hid_feed");

    if(Horder_list.size()>0) {
    	
    	%>
    	<tr><th>Doctor Name:</th>
		<th>Date:</th>
    	<th>Feedback:</th>
    	</tr>
    	
    	<%
    for(Integer i:Horder_list) {
    	String id = i.toString();%>

		
    		
    	<tr>
    	<td><textarea rows="5" readonly><%=Hid_name.get(i)%></textarea></td>
    	<td><textarea rows="5" readonly><%=Hid_date.get(i)%></textarea></td>
    	<td><textarea cols="50" rows="5" readonly><%=Hid_feed.get(i)%></textarea></td>
    	</tr> 
	<%
   	}
    %><table><%
    } else {
    %>
    <span>No History available</span>
	<%
	} 
	%>
</div>


</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>