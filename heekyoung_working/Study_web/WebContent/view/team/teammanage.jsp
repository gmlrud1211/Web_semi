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
			
	});
</script>
		



<h3 style="text-align: center;">스터디룸 관리<small> &laquo;목표관리&raquo; </small></h3>
<hr>	

	
	<div id="btnBox" class="btn pull-right">
		<button id="btnEnroll" class="btn btn-sm" style="color:#ffffff; background:#F67280">새로운 목표 등록</button>
	</div>
	