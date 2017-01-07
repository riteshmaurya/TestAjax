

var pts=80;
var msg = "High score: <strong>"+pts+"</strong>";
/*$("img").click(function(){
	alert("image is clicked!!!" +msg);
	$("p").append(msg);
});*/

/*$(document).ready(function(){
	$("#btn01").click(function(){
		var text=returnValue(document.getElementById("custName").value);
		alert(text);
		
	});
	
});
*/
/*$(document).ready(function(){

	$("#img01").click(function(){
	var status =confirm("discount is 20%");
	if(status){
		alert("ok");
	}else{
		alert("try again");
	}
	});
	
});

function submitForm(){
alert("submitForm called");	
}

function returnValue(name){
	
	var userName=name;
	userName="Mr. "+userName;
	//alert("ssssdddd");
	return userName;
	
}

var p=function(){
	$document().ready(function(){
	
		alert("function expression");
		
	});
	return 10;
};

$(document).ready(function(){
	
	$("#btn01").click(function(){
		$("#form01").addClass("hover");
		$("#form01").removeClass("no-hover");
		$(this).hide;
		alert("Ssssss");
	});
	$("#btn02").click(function(){
		$("#form01").addClass("no-hover");
		$("#form01").removeClass("hover");
		
	});
});

*//*var planeObject = {
	engineManufacturer: 'Roles Royce',
	noOfEngine:"4",
	engineType: "jet",
	planeType: "passenger",
	getEngineManufacturer: function(){
		alert(this.engineManufacturer);
		},
};*/

/*function planeObject(engineManufacturer,noOfEngine,engineType,planeType){
	this.engineManufacturer=engineManufacturer;
	this.engineType=engineType;
}
var planeObject1= new planeObject("aaa","6","sss","dssd");
var arr1=new Array("AAA","BBB","CCC","DDD","EEE");
var index=$.inArray("CCC",arr1);
$(document).ready(function(){
	planeObject.getEngineManufacturer();
	alert(planeObject.noOfEngine);
	
	alert(planeObject1. engineType);
	alert(arr1[0]);
	alert(index);
});
*/
/*$(document).ready(function(){
	
function parse(document){
	$(document).find("book").each(function(){
		alert("reached till here");
		//code for reading xml
		$("#content").append(
		"<p>Title" + $(this).find("title").text() +
		"<br>Author" + $(this).find("author").text() +
		"<br>Type" + $(this).find("type").text() +
		"<br>Error" + $(this).find("error").text() + 
		"</p>"
		);
	});
}


});

*/

function getXMLData(){
$.ajax({
	url: "book.xml",
	dataType:"xml",
	cache:false,
	
	error:function(){alert("Something went wrong");},
	sucess:function(xml){
		$("#content").empty();
		$(xml).find("book").each(function(){
			alert("reached till here");
			var info = '<li>Name: ' + $(this).find("title").text() + ' ' + $(this).
			find("author").text() + '. Time: ' + $(this).find("type").text() + '</li>';
			alert("DDD");
			$("#content").append(info);
			//code for reading xml
		/*	$("#content").append(
			"<p>Title" + $(this).find("title").text() +
			"<br>Author" + $(this).find("author").text() +
			"<br>Type" + $(this).find("type").text() +
			"<br>Error" + $(this).find("error").text() + 
			"</p>"
			);*/
		});
	} ,
	
});
}

$(document).ready(function(){
	getXMLData();

});