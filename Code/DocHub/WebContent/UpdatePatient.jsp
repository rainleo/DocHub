<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Patient</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript" src="JavaScript/register2.js">
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
<form action="UpdatePatientServlet" method="post" onsubmit="return myfunctionPat()">
<h1>Update Patient Info</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
<table>
<tr><td><label for="p_insProvider">Insurance Provider:*</label><input type="text" name="p_insProvider" value= "${p_insProvider}" id="p_insProvider"></td><td><div id ="p_insProviderError"></div></td></tr>
<tr><td><label for="p_insId">Insurance ID:*</label><input type="text" name="p_insId" value= "${p_insId}" id="p_insId"></td><td><div id ="p_insIdError"></div></td></tr>
<tr><td><label for="p_addressLine1">Address Line 1:*</label><input type="text" name="p_addressLine1" value= "${p_addressLine1}" id="p_addressLine1"></td><td><div id ="p_addressLine1Error"></div></td></tr>
<tr><td><label for="p_addressLine2">Address Line 2:</label><input type="text" name="p_addressLine2" value= "${p_addressLine2}" id="p_addressLine2"></td><td><div id ="p_addressLine2Error"></div></td></tr>
<tr><td><label for="p_city">City:*</label><input type="text" name="p_city" value= "${p_city}" id="p_city"></td><td><div id ="p_cityError"></div></td></tr>
<tr><td><label for="p_state">State:*</label><input type="text" name="p_state" value= "${p_state}" id="p_state"></td><td><div id ="p_stateError"></div></td></tr>
<tr><td><label for="p_country">Country:*</label><input type="text" name="p_country" value= "${p_country}" id="p_country"></td><td><div id ="p_countryError"></div></td></tr>
<tr><td><label for="p_zipCode">ZipCode:*</label><input type="text" name="p_zipCode" value= "${p_zipCode}" id="p_zipCode"></td><td><div id ="p_zipCodeError"></div></td></tr>
<tr><td><label for="p_phone">Phone:*</label><input type="text" name="p_phone" value= "${p_phone}" id="p_phone"></td><td><div id ="p_phoneError"></div></td></tr>

<tr><td><input type="hidden" name="patientid" value=<%=session.getAttribute("patientid")%>></td></tr>
<tr><td><input type="hidden" name="fname" value=<%=session.getAttribute("fname")%>></td></tr>
<tr><td><input type="hidden" name="lname" value=<%=session.getAttribute("lname")%>></td></tr>
<tr><td><input type="hidden" name="dob" value=<%=session.getAttribute("dob")%>></td></tr>
<tr><td><input type="hidden" name="gender" value=<%=session.getAttribute("gender")%>></td></tr>
<tr><td><input type="hidden" name="email" value=<%=session.getAttribute("email")%>></td></tr>
<tr><td><input type="hidden" name="pass" value=<%=session.getAttribute("pass")%>></td></tr>
<tr><td><input type="hidden" name="seques" value=<%=session.getAttribute("seques")%>></td></tr>
<tr><td><input type="hidden" name="seanws" value=<%=session.getAttribute("seanws")%>></td></tr>



<tr><td><input type="submit" class="button" value="Update"></td></tr>
</table>
</div>
</form>

</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>