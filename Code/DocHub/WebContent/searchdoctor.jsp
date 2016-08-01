<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Doctor</title>
<link href="css/registertest.css" rel="stylesheet">

<script>
function submitMyForm(){
	 document.forms["ViewAppointmentServlet"].submit();
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
</form>
	
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>