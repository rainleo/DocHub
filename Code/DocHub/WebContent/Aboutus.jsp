<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/registertest.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Me</title>
</head>
<body>

<div class="header">
<%@ include file="header.jsp" %>
</div>

<%HttpSession sess4	= request.getSession();
String user=(String)sess4.getAttribute("user_type");

if(user.equals("patient"))
{
%>

<div class="nav">
<%@ include file="insertPatient.html" %>
</div>
<%} else
{%>
<div class="nav">
<%@ include file="insertDoctor.html" %>
</div>
<%} %>


<div class="form">
<h1>About Us</h1>
<hr>
<span>We created DocHub to solve patient problems,</span>
 <span>beginning with online appointment-booking and we have not stopped building since.</span>
<span>  With DocHub, you can see doctors open appointment times and book instantly online,</span>
  <span> make informed choices with verified reviews, and stay on top of important checkups with tailored reminders. </span>
  <span> And those pesky waiting room forms? Fill them out online, just once, and keep them forever.</span>


</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>