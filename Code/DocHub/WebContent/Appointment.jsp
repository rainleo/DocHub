<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,docHub.Doctor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule an appointment</title>

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



<%
Doctor dr=new Doctor();
dr=(Doctor)request.getAttribute("doc");


%>


<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertPatient.html" %>
</div>


<div class="form">

<form action="CheckAppontmentServlet" method="post" name="tstest">
<h1>Appointment Scheduling</h1>
<hr>
<input type="hidden" name="doctor_id" id="doctor_id" value=<%=dr.getDoctorId()%>>
<input type="Text" id="datepicker" placeholder="Select date" style="text-align:center;background: transparent;" name="datepicker" class="searchBar" readonly="readonly" <%if(request.getAttribute("first")!=null) {%> value=<%=request.getAttribute("date") %><%} %>>
<input type="submit" value="Check" class="button" style="width:90px;height:30px;">

</form>
</div>
<%if(request.getAttribute("first")!=null)
	{
	@SuppressWarnings("unchecked")
	ArrayList<Boolean> res=(ArrayList<Boolean>)request.getAttribute("slots");
	%>
<div class="form2">
<form action="BookAppontmentServlet" method="post">

<input type="hidden" value=<%=request.getAttribute("date_apt") %> name="date_apt" id="date_apt">
<input type="hidden" name="slot" id="slot"> 
<input type="hidden" name="time" id="time"> 
<%

if(res.size()>0)
{
 %>

<br><textarea name="desc" id="desc" placeholder="Check up Details" style="width:300px;height:50px;"></textarea><br><br><br><br>
<input value="08AM-09AM" id="slot1" onClick="clickFunction(this.id)" <%if(res.get(0)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button" <%} %>>
<input value="09AM-10AM" id="slot2" onClick="clickFunction(this.id)" <%if(res.get(1)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button" <%} %>>
<input value="10AM-11AM" id="slot3" onClick="clickFunction(this.id)" <%if(res.get(2)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button" <%} %>>
<input value="11AM-12PM" id="slot4" onClick="clickFunction(this.id)" <%if(res.get(3)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button" <%} %>>
<input value="12PM-01PM" id="slot5" onClick="clickFunction(this.id)" <%if(res.get(4)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button" <%} %>>
<input value="01PM-02PM" id="slot6" onClick="clickFunction(this.id)" <%if(res.get(5)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button"<%} %>>
<input value="02PM-03PM" id="slot7" onClick="clickFunction(this.id)" <%if(res.get(6)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button"<%} %>>
<input value="03PM-04PM" id="slot8" onClick="clickFunction(this.id)" <%if(res.get(7)){ %>class="buttongreen" type="submit"<%}else{ %>class="buttongray" type="button"<%} %>><br>

<input type="hidden" id="doctor_id" name="doctor_id"  value=<%=dr.getDoctorId()%>>

</form>
</div>
<%} 
else
{
	%>
	<br><div>No slots available for the selected date. Please contact the doctor for emergency.</div>
	
	<%
}
	}
%>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>