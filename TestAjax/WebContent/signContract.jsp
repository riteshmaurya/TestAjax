<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" href="styles/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<link type="text/css" href="styles/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="all"
      href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/smoothness/jquery-ui.css"    />
 --><script src="scripts/jquery-1.8.3.js"></script>
<script src="scripts/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="cal.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#signCheck").attr('disabled',true);
});
function enableCheckBox(){
	
	var dataString = $("#datePicker").val();
	if(!(dataString==""||dataString==null)){
		console.log("called");
		$("#signCheck").removeAttr("disabled");
	}
}
function  isdateSelected(){
	var dataString = $("#datePicker").val();
	if(dataString==""||dataString==null){
	console.log("please slect date");	
		return false;
	}else{
		return true;
	}
	
}

function updateSignature(checked){	
	var p1= isdateSelected();
	 
	var dateSelected = $("input#datePicker").val(); 
	dataString = "dateSelected=" + dateSelected;
	
	console.log("datastring value::"+dataString);
	
	if(signCheck.checked && p1){
		console.log("ajax condition passed");
	console.log("value to be passed to server::"+dataString);
	$.ajax({
		type: "GET",
		url: "SignatureUpdated",
		data: dataString,
		dataType: "html",
		cache: false,
		headers:{
			'Cache-Control': 'no-cache, no-store, must-revalidate', 
		    'Pragma': 'no-cache', 
		    'Expires': '0'
		},
		success: function(data, textStatus, jqXHR) {
			console.log("ajax called");
			if(data!=null&& data==='updated'){
			console.log("data returned from server::"+data);	
			$("#ajaxResponse").html(data);
			}else {
				$("#ajaxResponse").html("<div><b>MW error. Please contact ITSS!</b></div>");
				console.log("data returned from server::"+data);
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("Something really bad happened " + textStatus);
			$("#ajaxResponse").html(jqXHR.responseText);
		},
		beforeSend: function(jqXHR, settings){
				//adding some Dummy data to the request
				settings.data += "&dummyData=whatever";
				//disable the button until we get the response
				//$('#myButton').attr("disabled", true);
		},	
	});
	}
	//console.log("sss");
	//alert("hi");
	

} 
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Contract Signing Date: <input type="text" name="signDate" id="datePicker" onchange="enableCheckBox()">
<br>
<br>

Update Signature: <input id="signCheck" name="signCheck" type="checkbox" onclick="updateSignature(checked)" Value="Hello">
<br>
<br>
<fieldset>
            <legend>Response from jQuery Ajax Request</legend>
                 <div id="ajaxResponse"></div>
        </fieldset>
</body>
</html>