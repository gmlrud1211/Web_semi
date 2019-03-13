<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.StudyBoard" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>팀별 자료실</title>
	
		<!-- jQuery 2.2.4 -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>	
			
		<!-- 부트스트랩 3.3.2 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
		<script type="text/javascript">
		$(document).ready(function() {
					
			//글쓰기 버튼 이벤트
			$("#btnWrite").click(function() {
				location.href ="/team/board/write";
			});
			
		});
		</script>
		
		
		
		
		<style>
			h3 {text-align : center;}
		</style>
		
	</head>
	
	<body>
		<h3>팀별 자료실</h3>
		<hr>		
		
		<div class="container">
		
		<table class="table table-hover table-striped table-condensed">
			<thead>
				<tr>
					<th style="width: 10%">번호</th>
					<th style="width: 45%">내용</th>
					<th style="width: 20%">작성일</th>
					<th style="width: 10%">다운로드</th>
					<th style="width: 20%">작성자</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${boardList }" var="studyboard">
					<tr>
						<td>${studyboard.sb_no }</td>
						<td>${studyboard.sb_content }</td>   
						<td><fmt:formatDate value="${studyboard.sb_date }" pattern="yyyy-MM-dd"/></td>
						<td><a href="/file/down?file_no=${studyboard.file_no }"><img src="/images/down.png" alt="다운" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
	
	<jsp:include page="../layout/paging.jsp"/>

	<div id="btnBox">
		<button id="btnWrite" class="btn btn-primary">게시글 작성</button>
	</div>
		
	</body>
</html>