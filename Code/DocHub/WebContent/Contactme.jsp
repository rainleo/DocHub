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

<%HttpSession sess2	= request.getSession();
String user=(String)sess2.getAttribute("user_type");

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
<h1>Contact</h1>
<hr>

<table>
                    <tr><td>Chandana Ravella</td></tr>
                       <tr><td> Email:-cravella@albany.edu</td></tr>
                    <tr><td>Dong Chen</td></tr>
                   <tr><td> Email:-dchen@albany.edu</td></tr>
                   <tr><td>Saurabh Singh</td></tr>
                    <tr><td>Email:-ssingh22@albany.edu</td></tr>
                    <tr><td>Sneha Banala</td></tr>
                   <tr><td> Email:-sbanala@albany.edu</td></tr>
                    <tr><td>Swapnil Jadhav</td></tr>
                   <tr><td> Email:-sjadhav@albany.edu</td></tr>
                    <tr><td>Varun Narayanan </td></tr>
                   <tr><td> Email:-vnarayanan@albany.edu</td></tr>
       </table>

</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>