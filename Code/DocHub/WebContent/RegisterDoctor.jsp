<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Doctor</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript" src="JavaScript/register2.js">
</script>
</head>
<body>


<div class="header">
<%@ include file="headerno.jsp" %>
</div>

<div class="nav">
<%@ include file="insert.html" %>
</div>


<div class="form">
<form action="RegisterDoctorServlet" method="post" onsubmit="return myfunctionDoc()" >
<h1>Registration: Step 2 of 2</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
<table>

<tr><td><label for="d_licenceNo">License Number:*</label><input type="text" name="d_licenceNo" id="d_licenceNo"></td><td><div id ="d_licenceNoError"></div></td></tr>
<tr><td><label for="d_insCovered">Insurance Covered:*</label><input type="text" name="d_insCovered" id="d_insCovered"></td><td><div id ="d_insCoveredError"></div></td></tr>
<tr>
<td><label for="d_specialization">Specialization:*</label>

<select name="d_specialization" id="d_specialization">
                <option value="dropdown">--------SELECT--------</option>
                <option value="dentist">Dentist</option>
                <option value=dermatologist>Dermatologist</option>
                <option value="general">General Physician</option>
                <option value="ent">ENT Specialist</option>
                <option value="cardiologist">Cardiologist</option>
                <option value="ob/gyn">OB/GYN</option>
                <option value="pediatrician">Pediatrician</option>
</select></td>
<td><div id ="d_specializationError"></div></td>

</tr>

<tr><td><label for="d_addressLine1">Address Line 1:*</label><input type="text" name="d_addressLine1" id="d_addressLine1"></td><td><div id ="d_addressLine1Error"></div></td></tr>
<tr><td><label for="d_addressLine2">Address Line 2:</label><input type="text" name="d_addressLine2" id="d_addressLine2"></td><td><div id ="d_addressLine2Error"></div></td></tr>
<tr><td><label for="d_city">City:*</label><input type="text" name="d_city" id="d_city"></td><td><div id ="d_cityError"></div></td></tr>
<tr><td><label for="d_state">State:*</label><input type="text" name="d_state" id="d_state"></td><td><div id ="d_stateError"></div></td></tr>
<tr><td><label for="d_country">Country:*</label><input type="text" name="d_country" id="d_country"></td><td><div id ="d_countryError"></div></td></tr>
<tr><td><label for="d_zipCode">ZipCode:*</label><input type="text" name="d_zipCode" id="d_zipCode"></td><td><div id ="d_zipCodeError"></div></td></tr>
<tr><td><label for="d_phone">Phone:*</label><input type="text" name="d_phone" id="d_phone"></td><td><div id ="d_phoneError"></div></td></tr>

<tr><td><input type="hidden" name="user" value=<%=request.getAttribute("user")%>></td></tr>
<tr><td><input type="hidden" name="fname" value=<%=request.getAttribute("fname")%>></td></tr>
<tr><td><input type="hidden" name="lname" value=<%=request.getAttribute("lname")%>></td></tr>
<tr><td><input type="hidden" name="dob" value=<%=request.getAttribute("dob")%>></td></tr>
<tr><td><input type="hidden" name="gender" value=<%=request.getAttribute("gender")%>></td></tr>
<tr><td><input type="hidden" name="email" value=<%=request.getAttribute("email")%>></td></tr>
<tr><td><input type="hidden" name="password" value=<%=request.getAttribute("password")%>></td></tr>
<tr><td><input type="hidden" name="secQuestion" value=<%=request.getAttribute("secQuestion")%>></td></tr>
<tr><td><input type="hidden" name="secAnswer" value=<%=request.getAttribute("secAnswer")%>></td></tr>

<tr><td><input class="button" type="button" value="BACK" Onclick="history.back()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="button" value="SUBMIT"></td></tr>
</table>
</div>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>