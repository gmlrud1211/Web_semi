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


<h4 style="text-align: center;">목표 생성</h4>
<hr>	




<!-- 
<div class="form-group">
				<label for="study_freq" class="col-sm-3 col-sm-offset-1 control-label"> 스터디 횟수  </label>
				<div class="col-sm-5">
					<input type="text" id="study_freq" name="study_freq" placeholder="횟수를 입력해주세요" /> 회
				</div>
			</div>

 -->
	
	<form class="container">
		<div class="form-group">
			<label for="a_ddate" class="col-sm-3 col-sm-offset-1 control-label">목표 마감일</label>
			<div class="col-sm-5">
				<input type="text" name="a_ddate" id="achivedate" />
			</div>
		</div>
		<div class="form-group">
			<label for="a_ddate" class="col-sm-3 col-sm-offset-1 control-label">목표 제목</label>
			<div class="col-sm-5">
				<input type="text" name="a_title" />
			</div>
		</div>
		<div class="form-group">
			<label for="a_ddate" class="col-sm-3 col-sm-offset-1 control-label">세부 목표</label>
			<div class="col-sm-5">
				<input type="text" name="a_title" />
			</div>
		</div>
	</form>
	
		
			