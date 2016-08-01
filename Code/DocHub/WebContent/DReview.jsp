<%@ page language="java" import="java.util.HashMap,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Reviews</title>
<link href="css/registertest.css" rel="stylesheet">

<script>
function submitMyForm(){
	 document.forms["ViewAppointmentServlet"].submit();
}
</script>
</head>
<body>

<%ArrayList<String> review = (ArrayList<String>)request.getAttribute("review");
int id = (Integer)request.getAttribute("id");
String Doctor_name = (String)request.getAttribute("Doctor_name");
%>



<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertDoctor.html" %>
</div>

<div class="form">
<form action="Review1" method="post">
<h1>Review - <%=Doctor_name%></h1>
<hr><hr>


<% 
if(review != null){
	Iterator it = review.iterator();
	while(it.hasNext()){
    out.print(it.next());
    %></br><hr>
<% 	}
}%>

</br>
</form></div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>