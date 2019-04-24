<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리 - 1대1문의</title>

<style>

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("table").on("click", "tr", function() {
		//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
		var nb_no = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/oneandboard/view?one_no="+one_no);
	});
	
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/oneandboard/write";
	});
	
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
    <jsp:include page="/view/layout/header.jsp" /></div>

<div id="menu" style="height:100%;width:20%;float:left;">

  <jsp:include page="/view/layout/sidebar.jsp" /> </div>

<div id="content" style="background-color#EEEEEE;height:100%;width:77%;float:left;">

<h3>1대1문의</h3>
<hr>

<table class="table table-hover table-striped table-condensed">
<thead>
<tr>
<th style="width: 10%">번호</th>
<th style="width: 20%">질문</th>
<th style="width: 20%">작성자</th>
<th style="width: 10%">작성일</th>
<th style="width: 10%">상태</th>
<th style="width: 10%">답변작성</th>
<!-- <th style="width: 10%">다운로드</th> -->

</tr>
</thead>

<tbody>
<c:forEach items="${oboardlist }" var="oboardlist">
<tr>
<td>${oboardlist.one_no }</td>
<td><a href="/oneandboard/view?one_no=${oboardlist.one_no }">${oboardlist.one_title }</a></td>
<td>${oboardlist.u_name }</td>
<td>${oboardlist.one_date }</td>
<td>${oboardlist.one_status }</td>

<td><c:choose>
   <c:when test="${oboardlist.one_status eq 'n' }">
   <a href="/oneandboard/write?one_no=${oboardlist.one_no }" style="color:blue;">
       답변등록</a></c:when>
   
   <c:when test="${oboardlist.one_status eq 'y'}"> </c:when>
</c:choose> </td>

<%-- <td><a href="/oneandboard/file/down?file_no=${oboarlist.file_no }"><img src="/images/down.png" alt="다운" /></a></td> --%>


</tr>
</c:forEach>
</tbody>
</table>

<jsp:include page="/view/layout/oneandboardpaging.jsp" />
      

<br>

<div class='text-center' style="clear:both;">
  <FORM name='search' method='post' action='/oneandboard/search'>
   
      <SELECT name='type'> <!-- 검색 컬럼 -->
       
        <OPTION id='title'  value='title'>제목</OPTION>
        <OPTION id='writer' value='writer'>작성자</OPTION>
        <OPTION id="content" value='content'>내용</OPTION>
        <OPTION id="status" value='status'>답변상태</OPTION>
      </SELECT>
      <input type='text' name='word'  placeholder="특수문자는 사용할수 없습니다."> 
            <button type='submit' id="searBtn">검색</button>    
    
  </FORM>
   <DIV class='menu_line' style='clear: both;'></DIV>

</DIV>

<div class='text-center' style="clear:both;">
  
  
</DIV>


</div>


<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>












<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



