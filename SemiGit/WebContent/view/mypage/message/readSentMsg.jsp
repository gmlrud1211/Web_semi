<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지확인</title>
<!-- Theme main style -->
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/bootstrap-theme.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-default" style="margin: 5px;border: none; box-shadow: none;">
  <div class="panel-heading" style="background: transparent; border: none;">
	<div>
	<span>
	    <strong>보낸사람: ${msg.sender_name }</strong>
    </span>
    <span>
	    <strong style="float: right;">받는사람: ${msg.receiver_name }</strong>
	 </span>
	</div>
	<span style="float: right;">보낸 날짜: ${msg.m_date }</span>
  </div>
  <div class="panel-body">
    ${msg.m_comment }
  </div>
  <div style="margin: 15px; float: right;">

  <button onclick="self.close();">닫기</button>

  </div>
</div>


</body>
</html>