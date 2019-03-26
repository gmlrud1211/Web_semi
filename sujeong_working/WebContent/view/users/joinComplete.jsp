<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/member.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">


$(document).ready(function() {
	// 메인페이지 연결
	$("#btnMain").click(function() {
		location.href('/main')
	});
	
	// 로그인 페이지 연결
	$("#btnLogin").click(function() {
		location.href('/users/login')
	});
});

</script>

</head>
<body>

<div class="container" >
	
	<h1 align="center" style="padding: 15px;">회원가입 완료!</h1>
	<hr style="margin-top: 30px; margin-bottom: 50px" >
	<h3 align="center">회원가입을 축하합니다 :) </h3>
	
	<div class="container" style="text-align:center; margin-top:70px;">
		<button type="button" id="btnLogin" class="btn btn-primary btn-mm">로그인하기</button>
		<button type="button" id="btnMain" class="btn btn-warning btn-mm">메인으로가기</button>
	</div>
</div>
</body>
</html>