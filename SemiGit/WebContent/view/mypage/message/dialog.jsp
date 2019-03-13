<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Dialog - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#dialog" ).dialog();
  } );
  </script>
</head>
<body>
<div id="startbutton">쪽지목록</div>
<div id="loadingScreen"></div>
<script>
$(document).ready(function(){
	$("#loadingScreen").dialog({
		autoOpen:false,
		dialogClass: "loadingScreenWindow",
		cloaseOnExcape:false,
		draggable: false,
		width: 200,
		minHeight: 60,
		modal: true,
		resizable: false,
		open: function(){},
		close: function(){}
	});
	
	$('#startbutton').on('click', startbuttonclick);
	
});

function openDialog(){
	$("#loadingScreen").html("Please wait...");
	$("#loadingScreen").dialog('open');
}

function closeDialog(){
	$("loadingScreen").dialog('close');
}

function startbuttonclick(){
	openDialog();
}


</script>
 
<div id="dialog" title="Basic dialog">
  <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div>
 
 
</body>
</html>