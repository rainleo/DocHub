<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Login</title>

<link href="css/registertest.css" rel="stylesheet">
</head>
<body>


<div class="header">
<%@ include file="headerno.jsp" %>
</div>

<div class="nav">
<%@ include file="insert.html" %>
</div>


<div class="form">
<form action="DLoginServlet" method="get">
	
	
<h1>Doctor Login</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
	<table>


<tr><td><div id="error">${msgg}</div></td></tr>



<tr>
<td><label for="email">Email:*</label>
<input type="text" name="email"/></td>
</tr>

<tr>
<td><label for="pass">Password:*</label>
<input type="password" name="pass"/></td>
</tr>

<tr>
<td><input class="button" type="submit" value="LOGIN"/></td>
</tr>

<tr>
<td></td>

</table>
</div>

</form>
	
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>