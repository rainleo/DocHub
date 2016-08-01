<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<form action="${initParam['posturl']}" method="POST">
		<input type="hidden" name="upload" value="1"/>
		<input type="hidden" name="return" value="${initParam['returnurl']}"/>
		<input type="hidden" name="cmd" value="_cart"/>
		<input type="hidden" name="business" value="${initParam['business']}"/>
		
		<input type="text" name="item_name_1" value="Appointment fee"/>
		<input type="hidden" name="amount_1" value="10">10$
		<input type="submit" value="Pay with Paypal"/>
		
	</form>
		
</body>
</html>