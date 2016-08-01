/**
 * 
 */

function myFunction()
{
	var fname=document.getElementById("firstName");
	var lname=document.getElementById("lastName");
	var gender=document.getElementById("genderRadio");
	
	var isError=true;
	
	if(!alpha(fname))
		{
		document.getElementById("fnameError").innerHTML="Invalid First Name";
		isError=false;
		}

	
	
	return isError;
	
}

function alphanumeric(input)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(input.value.match(letters))  
{  
	
return true;  
}  
else  
{    
	alert(document.form("register").action);
document.getElementById("register").action="Invalid";
return false;  

}  
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

