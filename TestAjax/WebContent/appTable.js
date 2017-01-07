$(document).ready(function() {
//Stops the submit request
$("#myAjaxRequestForm").submit(function(e){
e.preventDefault();
});

//checks for the button click event
$("#myButton").click(function(e){

//get the form data and then serialize that
dataString = $("#myAjaxRequestForm").serialize();

//get the form data using another method 
var countryCode = $("input#countryCode").val(); 
dataString = "countryCode=" + countryCode;

//make the AJAX request, dataType is set to json
//meaning we are expecting JSON data in response from the server
$.ajaxSetup({cache: false});
$.ajax({
type: "POST",
url: "CountryInformation",
data: dataString,
dataType: "json",
cache: false,
headers: {
    'Cache-Control': 'no-cache, no-store, must-revalidate', 
    'Pragma': 'no-cache', 
    'Expires': '0'
  },

//if received a response from the server
success: function( data, textStatus, jqXHR) {
//our country code was correct so we have some information to display
if(data.success){
	console.log(data);
	var $table = $("<table id='tbl1' class='ct-active' border='medium'>").appendTo($("#somediv"));
	$.each(data.countryInfo, function(index, countryInfo){
		$("<tr>").appendTo($table)
		.append($("<td>").text(countryInfo.C_NAME))      
        .append($("<td>").text(countryInfo.C_CODE))
        .append($("<td>").text(countryInfo.SERIAL_NO));
       
		
	});
	
	var $dropDownList = $("<select id='select1' onchange='showContinent(this.value)' class='ct-active' border='medium'>").appendTo($("#dropDownList"));
	$.each(data.countryInfo, function(index, countryInfo){
		$("<option>").appendTo($dropDownList).text(countryInfo.C_NAME);
	});
}
//display error message
else {
$("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
}
},

//If there was no resonse from the server
error: function(jqXHR, textStatus, errorThrown){
console.log("Something really bad happened " + textStatus);
$("#ajaxResponse").html(jqXHR.responseText);
},

//capture the request before it was sent to server
beforeSend: function(jqXHR, settings){
//adding some Dummy data to the request
settings.data += "&dummyData=whatever";
//disable the button until we get the response
$('#myButton').attr("disabled", true);
$("#tbl1").remove();

$("#select1").remove();
$("#select2").remove();
},

//this is called after the response or error functions are finsihed
//so that we can take some action
complete: function(jqXHR, textStatus){
//enable the button 
$('#myButton').attr("disabled", false);
}

}); 
});
});


function showContinent(value){
//$(document).ready(function() {
	//Stops the submit request
	$(document).on('change','#select1',function(e){
	e.preventDefault();
	});
	console.log(value);
	//checks for the button click event
	$(document).on('change','#select1',function(e){

	//get the form data and then serialize that
	dataString = $("#select1").serialize();

	//get the form data using another method 
	var countryCode = $("select#select1").val(); 
	console.log("Ritesh"+countryCode);
	dataString = "countryCode=" + countryCode;

	//make the AJAX request, dataType is set to json
	//meaning we are expecting JSON data in response from the server
	$.ajaxSetup({cache: false});
	$.ajax({
	type: "POST",
	url: "CountryInformation",
	data: dataString,
	dataType: "json",
	cache: false,
	headers: {
	    'Cache-Control': 'no-cache, no-store, must-revalidate', 
	    'Pragma': 'no-cache', 
	    'Expires': '0'
	  },

	//if received a response from the server
	success: function( data, textStatus, jqXHR) {
		//alert("DDD");
	//our country code was correct so we have some information to display
	if(data.success){
		console.log(data);
		
		$(".select2").remove();
		var $dropDownList2 = $("<select id='select2' class='select2'>").appendTo($("#dropDownList2"));
		$.each(data.countryInfo, function(index, countryInfo){
			$("<option>").appendTo($dropDownList2).text(countryInfo.C_NAME);
			console.log(countryInfo.C_NAME);
			console.log(countryInfo.C_CODE);
			
		});
	}
	//display error message
	else {
	$("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
	}
	},

	//If there was no resonse from the server
	error: function(jqXHR, textStatus, errorThrown){
	console.log("Something really bad happened " + textStatus);
	$("#ajaxResponse").html(jqXHR.responseText);
	},

	//capture the request before it was sent to server
	beforeSend: function(jqXHR, settings){
	//adding some Dummy data to the request
	settings.data += "&dummyData=whatever";
	//disable the button until we get the response
	$('#select1').attr("disabled", true);
	//$("#tbl1").remove();
	//$("select#select2").remove();
	//$(".select2").remove();
	//$(document).
	},

	//this is called after the response or error functions are finsihed
	//so that we can take some action
	complete: function(jqXHR, textStatus){
	//enable the button 
	$('#select1').attr("disabled", false);
	
	}

	}); 
	});
//	});
}