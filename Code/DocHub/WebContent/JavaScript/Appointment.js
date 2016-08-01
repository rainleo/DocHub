/**
 * 
 */
function clickFunction(clicked_id)
{
	//alert(document.getElementById("parentid").value);

	document.getElementById("slot").value=clicked_id;
	document.getElementById("time").value=document.getElementById(clicked_id).value;
	//document.getElementById("dateid2").value=clicked_id;
	//alert(document.getElementById("parentid").value);
}