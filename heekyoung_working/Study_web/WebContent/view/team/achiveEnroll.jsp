<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp"/>

	<title>새 목표 생성</title>
	
	<!--datepicker쓰기위한 jQuery-->  
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script type="text/javascript">

	$(function() {
	    $( "#achivedate" ).datepicker({

	    });
	    
	   	$( "#achivedate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	    
	});

	</script>

	<script type="text/javascript">
	
		$(document).ready(function() {
					
			//목표등록(추가) 버튼 
			$("#btnWrite").click(function() {
				$("form").submit();
			});

			
			var tag = "< input type='text' name='sub_name'/>" ;
				
			//세부목표 추가하는 버튼 이벤트
			$("#btnAdd").click(function() {
				$("#form-group1").apppend(tag);
				
			});
			
			/* 	"<div class='col-sm-4 col-sm-offset-1 contorl-label'>"+
			"<input type='text' name='sub_name' />"+
			"<button id='btnAdd' class='btn btn-sm' style='color:#ffffff; background:#F67280'>추가</button>"+
			"</div>" */
			
			
			$("#btnRemove").on("click", function() {
				$(this).perv().remove();
			});
			
		});
		</script>



<h4 style="text-align: center;"><small>목표설정</small></h4>
<hr>	



	
	<div class="container">
	
		<form action="/team/achive/write" method="post">
			<div class="form-group">
				<label for="a_ddate" class="col-sm-3 col-sm-offset-1 control-label">목표 마감일</label>
				<div class="col-sm-5">
					<input type="text" name="a_ddate" id="achivedate" />
				</div>
			</div>
			<br><br>
			
			<div class="form-group">
				<label for="a_titles" class="col-sm-3 col-sm-offset-1 control-label">목표 제목</label>
				<div class="col-sm-5">
					<input type="text" name="a_title" />
				</div>
			</div>
			<br><br>
			
		
			 <div class="form-group">
				<label for="sub_name" class="col-sm-3 col-sm-offset-1 control-label">세부 목표</label>
				<div class="col-sm-5">
					<input type="text" name="sub_name" />
					<button id="btnAdd" class="btn btn-sm" style="color:#ffffff; background:#F67280">추가</button>
				</div>
			</div>
			<br><br>
		
			
			
		</form>
	</div>
		
	
	<div id="btnBox" class="btn pull-right">
		<button id="btnWrite" class="btn btn-sm" style="color:#ffffff; background:#F67280">목표 등록!</button>
	</div>	
		
			