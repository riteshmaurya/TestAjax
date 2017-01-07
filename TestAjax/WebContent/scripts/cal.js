$(document).ready(function(){
	$("#datePicker").datepicker({
		changeMonth: true,
		changeYear: true
	});
	$("#slide_me").slider({
		value:0,
		min: 0,
		max: 100,
		step: 5,
		slide: function(event, ui){
			$("#inputVal").val(ui.value);
		}
	});
	$("#inputVal").val($("#slide_me").slider("value"));
	
});