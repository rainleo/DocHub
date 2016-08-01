<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link href="css/registertest.css" rel="stylesheet">
</head>

<body>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertPatient.html" %>
</div>

<div class="form">
<h1>Payment Info</h1>
<hr>
	<form action="${initParam['posturl']}" method="POST">
		<input type="hidden" name="upload" value="1"/>
		<input type="hidden" name="return" value="${initParam['returnurl']}"/>
		<input type="hidden" name="cmd" value="_cart"/>
		<input type="hidden" name="business" value="${initParam['business']}"/>
		
		<input type="hidden" name="item_name_1" value="Appointment fee"/>
		<input type="hidden" name="amount_1" value="10">
	
	<span>Your Insurance does not match the doctor's insurance carrier.</span><br><br><br><br>
	


<div>
<div style="width:300px;height:250px;float:right">

<table>
	<tr><td><h2>We value your Privacy</h2></td></tr>
    <tr><td><p>We will not sell or distribute your contact information. Read our Privacy Policy. <a href="Policy">read...</a></p></td></tr>
  	<tr><td><hr></td></tr>
    <tr><td><h2>Billing Enquiries</h2></td></tr>
    <tr><td><p>Do not hesitate to reach our support team if you have any queries. <a href="dochub2016@gmail.com">dochub@gmail.com</a></p></td></tr>
</table>
</div>

<div style="width:300px;height:250px;float:left; border-right: 1px solid gray;">
		<table>
			<tr><td><h2>Order Summary</h2></td></tr>
			<tr><td><h3>Appointment Fee | $26.5</h3></td></tr>
			<tr><td ><input type="hidden" type="text" name="item_name_1" value="Appointment fee"/></td></tr>
			<tr><td><input type="hidden" name="amount_1" value="26.5"></td></tr>
			<tr><td><input type="image" src="images/paypal.png" width="165" height="74" value="Pay with Paypal"/></td></tr>
		</table>
</div>
</div>
	</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>