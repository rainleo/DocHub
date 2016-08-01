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
HttpSession sess3	= request.getSession();	
//dr=(Doctor)request.getAttribute("doc");
dr.setDoctorId((Integer)sess3.getAttribute("userid"));
//dr.setFirstname("Swapnil");
//dr.setLastname("J");
//dr.setEmailId("swapnil@mail.com");
//dr.setLicenseNumber("HGH3773877");
//dr.setPhoneNumber("4849838122");

%>


<div class="form">
<form action="DisplayTimeServlet" method="post" name="tstest">
<h1>Update Schedule</h1>
<hr>
		
<input type="hidden" name="doctor_id" id="doctor_id" value=<%=dr.getDoctorId()%>>
<input type="Text" id="datepicker" placeholder="Select date" name="datepicker" style="text-align:center;background: transparent;" readonly="readonly" class="searchBar" <%if(request.getAttribute("second")!=null) {%> value=<%=request.getAttribute("date") %><%} %>>
<input type="submit" class="button" value="SET TIME" style="width:90px;height:30px;">

</form>
</div>

<%if(request.getAttribute("first")!=null)
	{
	@SuppressWarnings("unchecked")
	ArrayList<Boolean> slots=(ArrayList<Boolean>)request.getAttribute("slots");

	%>
	
<div class="form2">
<form action="EnterTimeServlet" method="post">

<input type="hidden" value=<%=request.getAttribute("date_apt") %> name="date_apt" id="date_apt">
<input type="hidden" id="doctor_id" name="doctor_id"  value=<%=dr.getDoctorId()%>>
<input type="checkbox" name="slot" value="slot1" class="box" <%if(slots.get(0)){ %> checked="checked" <%} %>><span class="convText">09AM-10AM</span><BR>
<input type="checkbox" name="slot" value="slot2" class="box" <%if(slots.get(1)){ %> checked="checked" <%} %>><span class="convText">10AM-11AM</span><BR>
<input type="checkbox" name="slot" value="slot3" class="box" <%if(slots.get(2)){ %> checked="checked" <%} %>><span class="convText">11AM-12PM</span><BR>
<input type="checkbox" name="slot" value="slot4" class="box" <%if(slots.get(3)){ %> checked="checked" <%} %>><span class="convText">12PM-01PM</span><BR>
<input type="checkbox" name="slot" value="slot5" class="box" <%if(slots.get(4)){ %> checked="checked" <%} %>><span class="convText">02PM-03PM</span><BR>
<input type="checkbox" name="slot" value="slot6" class="box" <%if(slots.get(5)){ %> checked="checked" <%} %>><span class="convText">03PM-04PM</span><BR>
<input type="checkbox" name="slot" value="slot7" class="box" <%if(slots.get(6)){ %> checked="checked" <%} %>><span class="convText">04PM-05PM</span><BR>
<input type="checkbox" name="slot" value="slot8" class="box" <%if(slots.get(7)){ %> checked="checked" <%} %>><span class="convText">05PM-06PM</span><BR><BR><BR><BR>
<input type="submit" class="button" value="SUBMIT" style="width:90px;height:30px;">
</form>
</div>
<%} 


%>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>


</body>

</html>