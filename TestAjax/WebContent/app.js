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
	var i;
	for(i=0; i<data.countryInfo.size;i++){
$("#ajaxResponse").html("");
$("#ajaxResponse").append("<b>Country Code:</b> " + data.countryInfo[i].code + "");
$("#ajaxResponse").append("<b>Country Name:</b> " + data.countryInfo[i].name + "");
$("#ajaxResponse").append("<b>Continent:</b> " + data.countryInfo[i].continent + "");
$("#ajaxResponse").append("<b>Region:</b> " + data.countryInfo[i].region + "");
$("#ajaxResponse").append("<b>Life Expectancy:</b> " + data.countryInfo[i].lifeExpectancy + "");
$("#ajaxResponse").append("<b>GNP:</b> " + data.countryInfo[i].gnp + "");
} 
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