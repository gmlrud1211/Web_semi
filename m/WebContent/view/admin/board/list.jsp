<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리 - 자유게시판</title>

<jsp:include page="/view/layout/header.jsp" />

<style>
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("table").on("click", "tr", function() {
			//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
			var nb_no = $(this).children("td").eq(0).text();

			$(location).attr("href", "/admin/board/view?b_no=" + b_no);
		});

		//글쓰기 버튼 이벤트
		$("#btnWrite").click(function() {
			location.href = "/board/write";
		});

		//공지사항 삭제 이벤트
		$("#delete").click(function() {
			$(location).attr("href", "/board/delete?b_no=" + b_no);
		});

	});
</script>

<style type="text/css">
a:link {
	color: black;
	!
	important
}

a:visited {
	color: grey;
	!
	important
}

a:active {
	color: grey;
	!
	important
}

a:hover {
	color: blue;
	!
	important
}

a {
	text-decoration: none ! important
}
</style>


<style type="text/css">
th {
	text-align: center !important;
}

th, td:not (:nth-child(2) ) {
	text-align: center;
}

td {
	border-left: 1px solid white;
	border-right: 1px solid white;
}

#head {
	text-align: center !important;
}

#btnBox {
	text-align: right;
}
</style>
</head>

<body>


	<div id="menu" style="height: 100%; width: 20%; float: left;">
		<jsp:include page="/view/layout/sidebar.jsp" />
	</div>


	<div id="content" style="height: 100%; width: 77%; float: left;">

		<h3>자유게시판</h3>

		<hr>

		<table class="table table-hover table-striped table-condensed">
			<thead>
				<tr>
					<th style="width: 5%">번호</th>
					<th style="width: 7%">말머리</th>
					<th style="width: 40%">제목</th>
					<th style="width: 10%">작성자</th>
					<th style="width: 10%">작성일</th>
<!-- 					<th style="width: 10%">삭제</th> -->

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${boardlist }" var="boardlist">
					<tr>
						<td style="width: 5%" >${boardlist.b_no }</td>
						<td style="width: 7%" id="head">${boardlist.b_head }</td>
						<td style="width: 30%" ><a href="/admin/board/view?b_no=${boardlist.b_no }">${boardlist.b_title }</a></td>

						<td style="width: 10%" >${boardlist.u_name }</td>
						<td style="width: 10%"><fmt:formatDate value="${boardlist.b_date }"
								pattern="yyyy-MM-dd" /></td>

<!-- 						<td id="delete"><a -->
<%-- 							href="/board/delete?b_no=${boardlist.b_no } ">삭제</a></td> --%>
<!-- 					</tr> -->
				</c:forEach>
			</tbody>
		</table>

		<jsp:include page="/view/layout/boardpaging.jsp" />

		<br>

		<div class='text-center' style="clear: both;">
			<FORM name='search' method='post' action='/admin/board/search'>

				<SELECT name='type'>
					<!-- 검색 컬럼 -->

					<OPTION id='title' value='title'>제목</OPTION>
					<OPTION id='writer' value='writer'>작성자</OPTION>
					<OPTION id="content" value='content'>내용</OPTION>
				</SELECT> <input type='text' name='word' placeholder="특수문자는 사용할수 없습니다.">
				<button type='submit' id="searBtn">검색</button>

			</FORM>
			<DIV class='menu_line' style='clear: both;'></DIV>

		</DIV>

	</div>

	<div style="clear: both;">
		<jsp:include page="/view/layout/footer.jsp" />
	</div>












	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>