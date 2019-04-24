<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고게시글  관리 페이지</title>

<style>

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("table").on("click", "tr", function() {
		//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
		var u_no = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/report/view?b_no="+b_no);
	});
	
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/report/write";
	});
	
	//회원 삭제 이벤트
// 	$("#del").click(function() {
// 		$(location).attr("href", "/report/delete?rp_no="+rp_no);
// 	});
	
	
});
</script>


<style type="text/css">

th{
text-align: center !important;
}

th, td:not(:nth-child(2)) {
	text-align: center;
}
td {
	border-left: 1px solid white;
	border-right: 1px solid white;
}

#btnBox {
	text-align: right;
}
</style></head>

<body>


<div id="header" style="height:10%;" >
    <jsp:include page="/view/layout/header.jsp" />
    </div>

<div id="menu" style="height:100%;width:20%;float:left;">

  <jsp:include page="/view/layout/sidebar.jsp" /> </div>

<div id="content" style="background-color;height:100%;width:77%;float:left;">

<h3>신고게시글 관리 </h3>
<hr>
<!-- <form action="/report/delete" method="post"> -->
<table class="table table-hover table-striped table-condensed">
<thead>
<tr>
<th style="width: 10%">번호</th>
<th style="width: 20%">신고글</th>
<th style="width: 10%">신고자</th>
<th style="width: 10%">작성자</th>
<th style="width: 10%">신고날짜</th>
<!-- <th style="width: 10%">접수상태</th> -->
<th style="width: 10%">삭제처리</th>
<th style="width: 10%">삭제</th>

</tr>
</thead>

<tbody>
<c:forEach items="${reportlist }" var="reportlist">
<tr>
<td>${reportlist.rp_no }</td>
<td><a href="/board/detail?b_no=${reportlist.b_no } ">${reportlist.b_title }</a></td>
<td>${reportlist.u_name }</td>
<td>${reportlist.u_name }</td>
<td><fmt:formatDate value="${reportlist.rp_date }" pattern="yyyy-MM-dd"/></td>
<%-- <td>${reportlist.rp_status }</td> --%>
<td>${reportlist.re_yesno }</td>

<td id="delete"><a href="/report/delete?rp_no=${reportlist.rp_no } " style="color:red;">삭제</a></td>

</tr>
</c:forEach>
</tbody>
</table>
<!-- </form> -->

<jsp:include page="/view/layout/reportpaging.jsp" />
      
<br>

<div class='text-center' style="clear:both;">
  <FORM name='search' method='post' action='/report/search'>
   
      <SELECT name='type'> <!-- 검색 컬럼 -->
       
        <OPTION id='title'  value='title'>제목</OPTION>
        <OPTION id="content" value='content'>내용</OPTION>
        <OPTION id='reporter' value='reporter'>신고자</OPTION>
        <OPTION id='writer' value='writer'>작성자</OPTION>
        <OPTION id="status" value='status'>삭제처리</OPTION>
      </SELECT>
      <input type='text' name='word'  placeholder="특수문자는 사용할수 없습니다."> 
            <button type='submit' id="searBtn">검색</button>    
    
  </FORM>
   <DIV class='menu_line' style='clear: both;'></DIV>

</DIV>

</div>

<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>










<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



