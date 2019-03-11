<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studyopen</title>


	<!--datepicker-->    
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script type="text/javascript">
	$(function() {
	    $( "#studyopendate" ).datepicker({
	    });
	});
	$(function() {
	    $( "#studyperiod" ).datepicker({
	    });
	});
	</script>
	<!-- 
	<script type="text/javascript">
		function fnGetCate(param) {
			var $target = $("select[name='st_code']");
			
			$target.empty();
			if(param==""){
				$target.append("<option value="">선택</option>");
				return;
			}
			
			$.ajax ({
				type="post",
				url ="/view/study/studyopen.jsp",
				async : false,
				data:{st_code:param},
				dataType : "json",
				success : function(data) {
					if(data.length ==0) {
						$target.append("<opction value="">선택</option>");
					} else {
						$(data).each(function(i){
							$target.append("<option value="+data[i].st_code+">"+data[i].st_name+"</option>");
							
						});
					}
				}, error:function(xhr){
					console.log(xhr.responseText);
					alert("잠시 후 다시 이용해주세요.")
					return;
				}
				
			});
			
		} 
	</script> -->
	
	
	
</head>	
<body>
	<h3>스터디 개설하기</h3>
	<hr>
	<div>	
	<form action="/study/open" method="post" class="form-horizontal">
	
	
		<label for="study_name" >스터디제목 <input type="text" id="study_name" name="study_name" /> </label>
		<br><br>
		<label for="st_code"> 카테고리 
							<select name="st_catecode" id="st_catecode" onchange="fnGetCate(this.value);">
								<option value="">1차분류</option>
								<option value="1">IT·프로그래밍</option>
								<option value="2">디자인</option>
								<option value="3">콘텐츠 제작</option>
								<option value="4">자격증</option>
								<option value="5">취업</option>
								<option value="6">외국어</option>
								<option value="7">음악</option>
								<option value="8">뷰티</option>
								<option value="9">수능</option>
							</select>
							
							<select name="st_code" id="st_code">
						
							</select>
		</label>
		<br><br>
		<label for="study_region" > 지역  </label>  
				<input type="checkbox" name="study_region" value="서울" /> 서울 
				<input type="checkbox" name="study_region" value="인천" /> 인천
				<input type="checkbox" name="study_region" value="분당" /> 분당
				<input type="checkbox" name="study_region" value="수원" /> 수원
				<input type="checkbox" name="study_region" value="시흥" /> 시흥
				<input type="checkbox" name="study_region" value="대구" /> 대구
				<input type="checkbox" name="study_region" value="대전" /> 대전
				<input type="checkbox" name="study_region" value="부산" /> 부산
				<input type="checkbox" name="study_region" value="김포" /> 김포   
		<br><br>
		<label for="study_time"> 시간대 </label>
				<input type="checkbox" name="study_time" value="전시간가능" /> 전시간 가능 
				<input type="checkbox" name="study_time" value="주중 시간무관" /> 주중 시간무관
				<input type="checkbox" name="study_time" value="주중 오전" /> 주중 오전 
				<input type="checkbox" name="study_time" value="주중 오후" /> 주중 오후
				<input type="checkbox" name="study_time" value="주말 시간무관" /> 주말 시간무관
				<input type="checkbox" name="study_time" value="주말 오전" /> 주말 오전	
		 		<input type="checkbox" name="study_time" value="주말 오후" /> 주말 오후
		<br><br>
		<label for="study_freq"> 스터디 횟수<input type="text" id="study_freq" name="study_freq" placeholder="횟수를 입력해주세요" /> 회</label>
		<br><br>
		<label> 모집인원 
				<select name="study_min" id="study_min">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
				</select> ~ 
				<select name="study_max" id="study_max">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
				</select>
		</label>
		<br><br>
		<label for="study_gender"> 성별 
			<input type="checkbox" name="study_gender" value="무관" /> 무관			
			<input type="checkbox" name="study_gender" value="여자" /> 여자
			<input type="checkbox" name="study_gender" value="남자" /> 남자
		</label>
		<br><br>
		<label> 스터디기간
			<input type="text" name="study_opendate" id="studyopendate" > ~ <input type="text" name="study_period" id="studyperiod"> 
		</label>
		<br><br>
		<label> 상세 내용 
				<textarea name="study_detail" cols="50" row="15" placeholder="하고싶은말을 자유롭게 작성해주세요" > </textarea>  
		</label>
		<br><br>
	</form>
	</div>

	<div class="col-sm-offset-4">
			<button type="button" id="btnJoin" class="btn btn-primary">등록</button>
			<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	</div>


</body>
</html>