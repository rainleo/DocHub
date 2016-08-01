<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,docHub.Doctor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm appointment</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript" src="JavaScript/Appointment.js"></script>
<script language="JavaScript" src="JavaScript/ts_picker.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

</head>


<body>


<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertPatient.html" %>
</div>




<%
Doctor dr=new Doctor();
dr=(Doctor)request.getAttribute("doc");

String date_apt=request.getAttribute("date_apt").toString();
String patient_id=request.getAttribute("patient_id").toString();
String description=request.getAttribute("description").toString();
String time=request.getAttribute("time").toString();
String slot=request.getAttribute("slot").toString();
%>


<div class="form">
<form action="ConfirmAppServlet" method="post" name="tstest">
<h1>Review Appointment</h1>
<hr>
<input type="hidden" name="doctor_id" id="doctor_id" value=<%=dr.getDoctorId()%>>
<input type="hidden" name="date_apt" id="date_apt" value=<%=date_apt%>>
<input type="hidden" name="patient_id" id="patient_id" value=<%=patient_id%>>
<input type="hidden" name="description" id="description" value=<%=description%>>
<input type="hidden" name="time" id="time" value=<%=time%>>
<input type="hidden" name="slot" id="slot" value=<%=slot%>>


<table border=1>
<tr>
	<th>Doctor Name</th>
	<th>Doctor Specialization</th>
	<th>Doctor Contact</th>
	<th>Appointment Date</th>
	<th>Appointment Time</th>
</tr>
<tr>
	<td><%=dr.getFirstname()%></td>
	<td><%=dr.getSpecialization()%></td>
	<td><%=dr.getPhoneNum() %></td>
	<td><%=date_apt %></td>
	<td><%=time %></td>
</tr>
</table><br><br>

<button type="button" class="button" name="back" style="width:90px;height:30px;" onclick="history.back()">Cancel</button>
<input type="submit" class="button" value="Book" style="width:90px;height:30px;">

</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>