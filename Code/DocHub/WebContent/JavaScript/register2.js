
/**
 * 
 */

function myFunction()
{
	var fname=document.getElementById("firstName");
	var lname=document.getElementById("lastName");
	var gender=document.getElementById("genderRadio");
	var dob=document.getElementById("dob");
	var email=document.getElementById("email");
	var password=document.getElementById("password");
	var confirmPassword=document.getElementById("confirmPassword");
	var secQuestion=document.getElementById("secQuestion");
	var secAnswer=document.getElementById("secAnswer");
	
	
	var isError=true;
	//alert(confirmPassword.value==password.value);
	if(!alpha(fname))
	{
	
	document.getElementById("fnameError").innerHTML="First Name should not contain special characters.";
	isError=false;
	
	}
	else
		document.getElementById("fnameError").innerHTML="";
	
	//return isError;
	
	if(!alpha(lname))
	{
	document.getElementById("lnameError").innerHTML="Last Name should not contain special characters.";
	isError=false;
	
	}
	else
		document.getElementById("lnameError").innerHTML="";


	
	if(!validateDate(dob))
	{
	document.getElementById("dobError").innerHTML="Invalid Format. Enter MM/DD/YYYY";
	isError=false;
	
	}
	else
		document.getElementById("dobError").innerHTML="";
	//return isError;
	
	if(!ValidateEmail(email))
	{
	document.getElementById("emailError").innerHTML="Invalid Email Address";
	isError=false;
	
	}
	else
		document.getElementById("emailError").innerHTML="";
	//return isError;
	
	if(!(alphanumeric(password) && password.value.length>5))
	{
	
	document.getElementById("passwordError").innerHTML="Password should not contain special characters.Min 6 chars.";
	isError=false;
	
	}
	else
		document.getElementById("passwordError").innerHTML="";
	//return isError;
	
	if(!(confirmPassword.value==password.value))
	{
	document.getElementById("confirmPasswordError").innerHTML="Password do not match";
	isError=false;
	
	}
	else
		document.getElementById("confirmPasswordError").innerHTML="";
	//return isError;
	
	
	if(secQuestion.value.length<1)
	{
	document.getElementById("secQuestionError").innerHTML="Please enter a Security Question";
	isError=false;
	
	}
	else
		document.getElementById("secQuestionError").innerHTML="";
	//return isError;
	
	if(secAnswer.value.length<1)
	{
	document.getElementById("secAnswerError").innerHTML="Please enter a Security Answer";
	isError=false;
	
	}
	else
		document.getElementById("secAnswerError").innerHTML="";
	
	
	//alert(isError);
	return isError;
}

function myfunctionDoc()
{
	var isError=true;
	
	var d_licenceNo=document.getElementById("d_licenceNo");
	var d_insCovered=document.getElementById("d_insCovered");
	var d_specialization=document.getElementById("d_specialization");
	var d_addressLine1=document.getElementById("d_addressLine1");
	var d_addressLine2=document.getElementById("d_addressLine2");
	var d_city=document.getElementById("d_city");
	var d_state=document.getElementById("d_state");
	var d_country=document.getElementById("d_country");
	var d_zipCode=document.getElementById("d_zipCode");
	var d_phone=document.getElementById("d_phone");
	
	
	if(!alphanumeric(d_licenceNo))
	{
	document.getElementById("d_licenceNoError").innerHTML="License Number should not contain special characters.";
	isError=false;
	
	}
	else
		document.getElementById("d_licenceNoError").innerHTML="";
	//return isError;
	
	if(!alpha(d_insCovered))
	{
	document.getElementById("d_insCoveredError").innerHTML="Invalid Insurance";
	isError=false;
	
	}
	else
		document.getElementById("d_insCoveredError").innerHTML="";
	//return isError;
	
	if(d_specialization.value=="dropdown")
	{
	document.getElementById("d_specializationError").innerHTML="Please select a Specialization";
	isError=false;
	
	}
	else
		document.getElementById("d_specializationError").innerHTML="";
	//return isError;
	
	
	if(d_addressLine1.value.length<1)
	{
	document.getElementById("d_addressLine1Error").innerHTML="Please enter your Address";
	isError=false;
	
	}
	else
		document.getElementById("d_addressLine1Error").innerHTML="";
	//return isError;
	
	
	
	if(!alpha(d_city))
	{
	document.getElementById("d_cityError").innerHTML="Please enter a valid City";
	isError=false;
	
	}
	else
		document.getElementById("d_cityError").innerHTML="";
	//return isError;
	
	if(!alpha(d_state))
	{
	document.getElementById("d_stateError").innerHTML="Please enter a valid State";
	isError=false;
	
	}
	else
		document.getElementById("d_stateError").innerHTML="";
	//return isError;
	
	if(!alpha(d_country))
	{
	document.getElementById("d_countryError").innerHTML="Please enter a valid Country";
	isError=false;

	}
	else
		document.getElementById("d_countryError").innerHTML="";
	//return isError;
	
	if(!numeric(d_zipCode))
	{
	document.getElementById("d_zipCodeError").innerHTML="Please enter a valid Zipcode";
	isError=false;

	}
	else
		document.getElementById("d_zipCodeError").innerHTML="";
	//return isError;
	
	if(!numeric(d_phone))
	{
	document.getElementById("d_phoneError").innerHTML="Please enter a valid Phone Number";
	isError=false;

	}
	else
		document.getElementById("d_phoneError").innerHTML="";
	
	
	return isError;
}

function myfunctionPat()
{
	var p_insProvider=document.getElementById("p_insProvider");
	var p_insId=document.getElementById("p_insId");
	var p_addressLine1=document.getElementById("p_addressLine1");
	var p_addressLine2=document.getElementById("p_addressLine2");
	var p_city=document.getElementById("p_city");
	var p_state=document.getElementById("p_state");
	var p_country=document.getElementById("p_country");
	var p_zipCode=document.getElementById("p_zipCode");
	var p_phone=document.getElementById("p_phone");
	
	if(!alpha(p_insProvider))
	{
	document.getElementById("p_insProviderError").innerHTML="Invalid Insurance Provider";
	isError=false;
	}
	else
		document.getElementById("p_insProviderError").innerHTML="";
	
	//return isError;
	
	if(!alphanumeric(p_insId))
	{
	document.getElementById("p_insIdError").innerHTML="Invalid Insurance ID";
	isError=false;
	}
	else
		document.getElementById("p_insIdError").innerHTML="";
	
	//return isError;
	
	
	if(p_addressLine1.value.length<1)
	{
	document.getElementById("p_addressLine1Error").innerHTML="Please enter your Address";
	isError=false;
	
	}
	else
		document.getElementById("p_addressLine1Error").innerHTML="";
	//return isError;
	
	
	//return isError;
	
	if(!alpha(p_city))
	{
	document.getElementById("p_cityError").innerHTML="Please enter a valid City";
	isError=false;
	}
	else
		document.getElementById("p_cityError").innerHTML="";
	
	//return isError;
	
	if(!alpha(p_state))
	{
	document.getElementById("p_stateError").innerHTML="Please enter a valid State";
	isError=false;
	}
	else
		document.getElementById("p_stateError").innerHTML="";
	
	//return isError;
	
	if(!alpha(p_country))
	{
	document.getElementById("p_countryError").innerHTML="Please enter a valid Country";
	isError=false;
	}
	else
		document.getElementById("p_countryError").innerHTML="";
	
	//return isError;
	
	if(!numeric(p_zipCode))
	{
	document.getElementById("p_zipCodeError").innerHTML="Please enter a valid Zipcode";
	isError=false;
	}
	else
		document.getElementById("p_zipCodeError").innerHTML="";
	
	//return isError;
	
	if(!numeric(p_phone))
	{
	document.getElementById("p_phoneError").innerHTML="Please enter a valid Phone Number";
	isError=false;
	}
	else
		document.getElementById("p_phoneError").innerHTML="";
	
	return isError;
}


function alphanumeric(input)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(input.value.match(letters))  
return true;
else
return false;   
} 

function alpha(input)  
{   
var letters = /^[a-zA-Z]+$/;  
if(input.value.match(letters))  
{  
return true;  
}  
else  
{    
return false;  
}  
} 

function numeric(input)  
{   
var letters = /^[0-9]+$/;  
if(input.value.match(letters))  
{  
return true;  
}  
else  
{    
return false;  
}  

} 
function validateDate(testdate)
{
    var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
    if(testdate.value.match(date_regex))
    	{
    	return true;
    	}
    else
    	{
    	return false;
    	}
    
}
	
function ValidateEmail(mail)   
{  
	var email_regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
 if (mail.value.match(email_regex))  
  {  
    return (true)  
  }  
    //alert("You have entered an invalid email address!")  
    return (false)  
}  	
	
	







