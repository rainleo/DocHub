<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,docHub.Doctor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript" src="JavaScript/Appointment.js"></script>
<script language="JavaScript" src="JavaScript/ts_picker.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( "#datepicker" ).datepicker({  minDate: 0, // your min date
        maxDate: '6d'
        });
  });
  </script>
</head>
<body>


<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertDoctor.html" %>
</div>

<%
Doctor dr=new Doctor();
//dr=(Doctor)request.getAttribute("doc");
dr.setDoctorId(1);
dr.setFirstname("Swapnil");
dr.setLastname("J");
dr.setEmailId("swapnil@mail.com");
dr.setLicenseNumber("HGH3773877");
dr.setPhoneNumber("4849838122");
String date_apt=request.getAttribute("date_apt").toString();

%>


<div class="form">
<form action="" method="post" name="tstest">
<h1>Schedule Updated</h1>
<hr>
<span>Schedule updated for <%=request.getAttribute("date_apt") %></span><br><br>

</form>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</div>
</body>
</html>