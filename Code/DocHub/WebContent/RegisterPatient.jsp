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
<%@ include file="headerno.jsp" %>
</div>

<div class="nav">
<%@ include file="insert.html" %>
</div>


<div class="form">
<form action="RegisterPatientServlet" method="post" onsubmit="return myfunctionPat()">
<h1>Registration: Step 2 of 2</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
<table>
<tr><td><label for="p_insProvider">Insurance Provider:</label><input type="text" name="p_insProvider" id="p_insProvider"></td><td><div id ="p_insProviderError"></div></td></tr>
<tr><td><label for="p_insId">Insurance ID:</label><input type="text" name="p_insId" id="p_insId"></td><td><div id ="p_insIdError"></div></td></tr>
<tr><td><label for="p_addressLine1">Address Line 1:</label><input type="text" name="p_addressLine1" id="p_addressLine1"></td><td><div id ="p_addressLine1Error"></div></td></tr>
<tr><td><label for="p_addressLine2">Address Line 2:</label><input type="text" name="p_addressLine2" id="p_addressLine2"></td><td><div id ="p_addressLine2Error"></div></td></tr>
<tr><td><label for="p_city">City:</label><input type="text" name="p_city" id="p_city"></td><td><div id ="p_cityError"></div></td></tr>
<tr><td><label for="p_state">State:</label><input type="text" name="p_state" id="p_state"></td><td><div id ="p_stateError"></div></td></tr>
<tr><td><label for="p_country">Country:</label><input type="text" name="p_country" id="p_country"></td><td><div id ="p_countryError"></div></td></tr>
<tr><td><label for="p_zipCode">ZipCode:</label><input type="text" name="p_zipCode" id="p_zipCode"></td><td><div id ="p_zipCodeError"></div></td></tr>
<tr><td><label for="p_phone">Phone:</label><input type="text" name="p_phone" id="p_phone"></td><td><div id ="p_phoneError"></div></td></tr>

<tr><td><input type="hidden" name="user" value=<%=request.getAttribute("user")%>></td></tr>
<tr><td><input type="hidden" name="fname" value=<%=request.getAttribute("fname")%>></td></tr>
<tr><td><input type="hidden" name="lname" value=<%=request.getAttribute("lname")%>></td></tr>
<tr><td><input type="hidden" name="dob" value=<%=request.getAttribute("dob")%>></td></tr>
<tr><td><input type="hidden" name="gender" value=<%=request.getAttribute("gender")%>></td></tr>
<tr><td><input type="hidden" name="email" value=<%=request.getAttribute("email")%>></td></tr>
<tr><td><input type="hidden" name="password" value=<%=request.getAttribute("password")%>></td></tr>
<tr><td><input type="hidden" name="secQuestion" value=<%=request.getAttribute("secQuestion")%>></td></tr>
<tr><td><input type="hidden" name="secAnswer" value=<%=request.getAttribute("secAnswer")%>></td></tr>


<tr><td><input class="button" type="submit" value="SUBMIT"></td></tr>
</table>
</div>
</form>
</div>
<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>