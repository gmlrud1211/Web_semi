<%@page import="dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js">
	
</script>

<script type="text/javascript">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("table").on("click", "tr", function() {
			//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
			var boardno = $(this).children("td").eq(0).text();
			$(location).attr("href", "/board/detail?b_no=" + boardno);
		});
	});
</script>

<style type="text/css">
th, td:not (:nth-child(2) ) {
	text-align: center;
}

td {
	border-left: 1px solid white;
	border-right: 1px solid white;
}
</style>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	color: #333;
	margin: 15px 0;
}

h6 {
	text-align: center;
	color: #333;
	font-size: 14px;
}

h6.title {
	text-align: left;
}

h4 {
	text-align: center;
	color: #333;
	margin: 10px 0;
}

div {
	width: 800px;
	margin: 0 auto;
	margin-top: 30px;
}

table {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #e1e1e1;
	border-top: 3px solid #333
}

table thead {
	
}

table thead tr {
	
}
/*    table thead tr th{font-size:14px; color:blue; padding:10px 0; border:1px solid #e1e1e1} */
table tbody {
	
}

table>thead>tr>th {
	text-align: center;
}

table tbody tr td {
	border: 1px solid #e1e1e1;
	text-align: center;
	font-size: 10px;
	padding: 10px 0;
}

#btnBox {
	text-align: right;
}

#btnMain {
	text-align: left;
}
</style>

<body>
	<h2>자유게시판</h2>
	<h4>악플금지! 자유롭게 정보공유와 질문 해주세요.</h4>
	<hr>
	<div>
		<table class="table table-striped">
			<colgroup>
				<col width="8%">
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="13%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>말머리</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Board> list = (List) request.getAttribute("boardList");
				%>
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<!--  번호 	말머리	제목	작성자	작성일	조회수	추천수 -->

					<td><h6><%=list.get(i).getB_no()%></h6></td>
					<td><h6>
							[<%=list.get(i).getB_head()%>]
						</h6></td>
					<td><h6 class="title">
							<a href="/board/detail?b_no=<%=list.get(i).getB_no()%>">
								<%=list.get(i).getB_title()%>
							</a>
						</h6></td>
					<td><h6><%=list.get(i).getU_name()%></h6></td>
					<td><h6><%=list.get(i).getB_date()%></h6></td>
					<td><h6><%=list.get(i).getB_count()%></h6></td>
					<td><h6><%=list.get(i).getB_upcount()%></h6></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<!-- 페이징 처리  -->
		<jsp:include page="/view/layout/paging.jsp"></jsp:include>
		<!-- 검색창 영역  -->
		<jsp:include page="/view/layout/serarch.jsp"></jsp:include>
		
		<div id="btnBox">
			<a href="/main"><button type="button" id="btnMain" class="btn btn-warning">메인으로 돌아가기</button></a> 
			<a href="/board/write"><button type="button" id="btnWrite" class="btn btn-primary">글쓰기</button></a>
		</div>
	</div>
</body>
</html>