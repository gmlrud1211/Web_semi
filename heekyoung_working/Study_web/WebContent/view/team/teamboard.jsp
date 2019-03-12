<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<th style="width: 45%">제목</th>
					<th style="width: 20%">작성자</th>
					<th style="width: 20%">작성일</th>
					<th style="width: 10%">다운로드</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.boardno }</td>
						<td><a href="/board/view?boardno=${board.boardno }">${board.title }</a></td>
						<td>${board.writer }</td>
						<td>${board.hit }</td>
						<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
	
	<jsp:include page="../layout/paging.jsp"/>

	<div id="btnBox">
		<button id="btnWrite" class="btn btn-primary">글쓰기</button>
	</div>
		
	</body>
</html>