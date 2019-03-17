<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<jsp:include page="../layout/header.jsp"/>    
<title>스터디룸 관리</title>

<script type="text/javascript">
	$(document).ready(function() {
					
		//글쓰기 버튼 이벤트
		$("#btnEnroll").click(function() {
			location.href ="/team/achive/write";
		});
		
		//스터디룸 정보 수정 이벤트
		$("#btnUpdate").click(function() {
			location.href ="/team/info/update";
		});
	});
</script>
		



<h3 style="text-align: center;">스터디룸 관리<small> &laquo;목표등록, 수정, 팀원 관리&raquo; </small></h3>
<hr>	
		
	<div id="btnBox" class="btn pull-right">
		<button id="" class="btn btn-sm" style="color:#ffffff; background:#F67280">팀원관리</button>
	</div>
	<div id="btnBox" class="btn pull-right">
		<button id="btnEnroll" class="btn btn-sm" style="color:#ffffff; background:#F67280">새로운 목표 등록</button>
	</div>
	<div id="btnBox" class="btn pull-right">
		<button id="btnUpdate" class="btn btn-sm" style="color:#ffffff; background:#F67280">스터디 정보 수정</button>
	</div>
	