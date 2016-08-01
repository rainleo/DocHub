<%@ page language="java" import="java.util.HashMap,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointments</title>
<link href="css/registertest.css" rel="stylesheet">
<script type="text/javascript">

function one() 
{
	
	document.getElementById("txt").style.display = "block";
	document.getElementById("feedback").style.display = "block";
	document.getElementById("sub").style.display = "block";
	
	}

function MyFunction(app_id)
{
	var id = app_id;
	//alert("hi");
	document.getElementById("appt_id").value = id;	

	//alert(app_id);

}
function MyF2(app_id)
{
	var id = app_id;
	//alert("hi");
	document.getElementById("patient_id").value = id;

}
</script>
</head>
<body>

<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertDoctor.html" %>
</div>

	<%String err=(String)session.getAttribute("err_search");
		if(err!=null) 
			out.print(err);
	request.getSession().removeAttribute("err_search");%>
	
	<div class="form">
	<h1>Appointment</h1>
		<hr>
	<div class="tableform">
	<table>
	<% 
	int x=-1;
	String uid=null;
	ArrayList<Integer> order_lis = (ArrayList<Integer>)session.getAttribute("order_lis");
    HashMap<Integer, String> id_nam = (HashMap<Integer, String>)session.getAttribute("id_nam");
	HashMap<Integer, Integer> id_appi = (HashMap<Integer, Integer>)session.getAttribute("id_appi");
	HashMap<Integer, Integer> id_useri = (HashMap<Integer, Integer>)session.getAttribute("id_useri");

	HashMap<Integer, String> id_dat = (HashMap<Integer, String>)session.getAttribute("id_dat");
	HashMap<Integer, String> id_tim = (HashMap<Integer, String>)session.getAttribute("id_tim");
	HashMap<Integer, String> id_des = (HashMap<Integer, String>)session.getAttribute("id_des");

    if(order_lis.size()>0){
    	%>
    	<tr>
    		<th>Patient Name</th>
    		<th>date</th>
    		<th>time</th>
    		<th>Description</th>

    	</tr>
    	<%
    for(Integer i:order_lis) {
    	String idd = i.toString();
    	uid = id_useri.get(i).toString();
    	x=i;
  	%>

    	<tr>
    	    <td><%=id_nam.get(i) %></td>    	
    		<td><%=id_dat.get(i) %></td> 
    		<td><%=id_tim.get(i).toString() %></td>
    		<td><%=id_des.get(i) %></td>
    	</tr>
    	<%} %>
    	</table>
    	</div>
    	<br>
    	<div style="width:330px;height:40px">
    	<div style="float:left">
    		 <form action="ViewAppointmentServlet" method="post">
    		<input class="button"  type="submit" value="Cancel" onclick="MyFunction(i)">
       		<input type="hidden" id="appt_id" name="appt_id"  value="<%=x %>" />
		    		
		
		</form>
		</div>
		
		<div style="float:left">
		<form action="PatientHistoryServlet" method="get">
		
		<input type="submit" class="button" value="History">
		<input type="hidden" id="patient_id" name="patient_id"  value="<%=uid %>" />
		
		</form>	 	
		
		</div>
		
		<div style="float:right">
		<input type="button" class="button" value="Feedback" onclick="one()">
		
		</div>	
		</div> 	
			
		<form action="FeedbackServlet" method="get">
		
		<label id="txt" style="display: none">Give Feedback : </label>
		<textarea id ="feedback" rows="5" cols="50" name="feedback" style="display: none"> </textarea>
  		<input type="submit" class="button" id="sub" value="Post" onclick="MyFunction(x)" style="display: none" />
		<input type="hidden" id="appt_id" name="appt_id"  value="<%=x %>" />
		<input type="hidden" id="patient_id" name="patient_id"  value="<%=uid %>" />
		
		</form>	
		
	<%} %>

</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>