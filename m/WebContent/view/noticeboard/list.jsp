<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOMO 공지사항</title>

<jsp:include page="/view/layout/header.jsp" />


<script type="text/javascript">
$(document).ready(function() {
	$("table").on("click", "tr", function() {
		//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
		var nb_no = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/noticeboard/view?nb_no="+nb_no);
	});
	
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/noticeboard/write";
		

	});
	
	//공지사항 삭제 이벤트
	$("#delete").click(function() {
		$(location).attr("href", "/nboardList/delete?nb_no="+nb_no);
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

<div style="max-width:1170px; margin:0 auto; width:100%">
  <jsp:include page="/view/layout/mypage.jsp" /> 

<div id="content" style="padding:20px; border-left: 1px solid #D8D8D8;height:100%;width:75%;float:left;">


<div>
<h2>공지사항</h2>
<h4> 공지사항을 꼭 확인해주세요</h4>
</div>
<hr>
<table class="table table-hover table-striped table-condensed">
	<colgroup>
		<col width="10%">
		<col width="10%">
		<col width="*">
		<col width="10%">
		<col width="10%">
	</colgroup>

<thead>
<tr>
<th style="width: 10%">번호</th>
<th style="width: 20%">제목</th>
<th style="width: 20%">작성자</th>
<th style="width: 10%">조회수</th>
<th style="width: 10%">작성일</th>


</tr>
</thead>

<tbody>
<c:forEach items="${nboardlist }" var="nboardlist">
<tr>
<td>${nboardlist.nb_no }</td>
<td><a href="/noticeboard/view?nb_no=${nboardlist.nb_no }">${nboardlist.nb_title }</a></td>
<td>관리자</td>
<td>${nboardlist.nb_count }</td>
<td><fmt:formatDate value="${nboardlist.nb_date }" pattern="yyyy-MM-dd"/></td>

</tr>
</c:forEach>
</tbody>
</table>

<jsp:include page="/view/layout/noticeboardpaging.jsp" />
      
<br>

<div class='text-center' style="clear:both;">
  <FORM name='search' method='post' action='/noticeboard/search'>
   
      <SELECT name='type'> <!-- 검색 컬럼 -->
       
        <OPTION id="title" value='title'>제목</OPTION>
        <OPTION id="content" value='content'>내용</OPTION>
      
      </SELECT>
      <input type='text' name='word' placeholder="특수문자는 사용할수 없습니다."> 
            <button type='submit' id="searBtn" >검색</button>    
    

  </FORM>
  </DIV>
</div>

</div>

<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>












<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



