<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studyopen</title>
</head>
<body>


<div>
	<h3>스터디 개설 페이지</h3>
	<hr>
	
	<form action="/study/open" method="post" class="form-horizontal">
	
	
		<label for="study_name" >스터디제목 <input type="text" id="study_name" name="study_name" /> </label>
		<br>
		<label for="st_code">카테고리 
							<select name="st_code" id="st_code">
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
							
							<select name="st_catecode" id="st_catecode">
								<option value="">2차분류</option>
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
		</label>
		<br>
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
		<label for="study_tiem"> 시간대</label>
				<input type="checkbox" name="study_time" value="전시간가능" /> 전시간 가능 
				<input type="checkbox" name="study_time" value="주중 시간무관" /> 주중 시간무관
				<input type="checkbox" name="study_time" value="주중 오전" /> 주중 오전 
				<input type="checkbox" name="study_time" value="주중 오후" /> 주중 오후
				<input type="checkbox" name="study_time" value="주말 시간무관" /> 주말 시간무관
				<input type="checkbox" name="study_time" value="주말 오전" /> 주말 오전	
		 		<input type="checkbox" name="study_time" value="주말 오후" /> 주말 오후
		<br><br>
		<label for="study_freq"> 시간대</label>
		 		<input /> 		 
		 
		 
	</form>
	
</div>



</body>
</html>