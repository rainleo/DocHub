<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript" src="JavaScript/register2.js">
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( "#dob" ).datepicker({changeMonth:true,changeYear: true,yearRange:"-50:+0"});
  });
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
<form action="RegisterServlet" method="post" onsubmit="return myFunction()">
<h1>Registration: Step 1 of 2</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
<table>

<%if(request.getAttribute("email")!=null) {%>
<tr><td><div id="error"><%=request.getAttribute("email") %> already exist</div></td></tr>
<%} %>
<tr>
<td><label for="Select">Select:</label><input type="radio" name="PatientRadio" value="patient" name="regTyperadio" checked="checked">Patient
<input type="radio" name="PatientRadio" value="doctor" name="regTyperadio">Doctor</td>
</tr>

<tr><td><label for="firstName">First Name:*</label><input type="text" name="firstName" id="firstName"></td><td><div id ="fnameError"></div></td></tr>
<tr><td><label for="lastName">Last Name:*</label><input type="text" name="lastName" id="lastName"></td><td><div id ="lnameError"></div></td></tr>
<tr>

<td><label>Gender:</label><input type="radio" name="genderRadio" value="male" id="genderRadio" checked="checked">Male
<input type="radio" name="genderRadio" value="female" id="genderRadio">Female</td>
<td><div id ="genderError"></div></td>
</tr>
<tr><td><label for="dob">DOB:*</label><input type="text" name="dob" id="dob" readonly="readonly"></td><td><div id ="dobError"></div></td></tr>
<tr><td><label for="email">Email:*</label><input type="text" name="email" id="email"></td><td><div id ="emailError"></div></td></tr>
<tr><td><label for="password">Password:*</label><input type="password" name="password" id="password"></td><td><div id ="passwordError"></div></td></tr>
<tr><td><label for="confirmPassword">Confirm Password:*</label><input type="password" name="confirmPassword" id="confirmPassword"></td><td><div id ="confirmPasswordError"></div></td></tr>
<tr><td><label for="secQuestion">Security Question:*</label><input type="text" name="secQuestion" id="secQuestion"></td><td><div id ="secQuestionError"></div></td></tr>
<tr><td><label for="secAnswer">Security Answer:*</label><input type="text" name="secAnswer" id="secAnswer"></td><td><div id ="secAnswerError"></div></td></tr>
<tr><td><input class="button" type="submit" value="NEXT" ></td></tr><tr>
</table>
</div>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>