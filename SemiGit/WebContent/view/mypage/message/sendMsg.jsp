<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
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
    <h3 class="panel-title" style="font-size: 12px;"><strong>받는사람: ${sMsg.u_name }</strong></h3>
  </div>
  <div class="panel-body">
  	<form action="/mypage/message/send" method="post" onsubmit="self.close();">
  	  <textarea name="m_comment" rows="10" cols="45"></textarea>
  	  <input type="hidden" name="m_no" value="${sMsg.m_no }"/>
  	  <input type="hidden" name="sender_no" value="${sMsg.receiver_no }"/>
  	  <input type="hidden" name="receiver_no" value="${sMsg.sender_no }"/>
 	<div style="margin: 15px; float: right;">
  		<button type="button">닫기</button>
  		<button type="submit">보내기</button>
 	 </div>
  	</form>
  </div>
</div>


</body>
</html>