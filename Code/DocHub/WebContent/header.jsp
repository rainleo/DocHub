<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.logout a:visited {
    background-color: white;
    color: #173e43;

    margin-top:25px;
   
	font-size:12px;
    font-family:Monospace;
}


.logout a:hover {
    background-color: red;
}
</style>
</head>
<body>
<!--<img src="img/logo1.png" alt="Mountain View" style="width:100px;height:75px;float:left;"> -->
<%
HttpSession sess	= request.getSession();
String name=(String)sess.getAttribute("fname");

%>
<div class="head1">
<img src="css/images/doctor.jpg" alt="Doc" style="width:100px;height:75px;float:left;">
<img src="css/images/logo.png" alt="DocHub" style="width:200px;height:75px;float:left;"><br>
<img src="css/images/life.gif" align="middle" alt="DocHub" style="width:700px;height:35px;float:center;">


<a class="logout" style="width:80px;height:30px;float:right;" href="/DocHub/LogoutServlet">Log Out</a>

</div>
</body>
</html>