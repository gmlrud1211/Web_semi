<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리 - 공지사항</title>

<jsp:include page="/view/layout/header.jsp" />


<script type="text/javascript">
$(document).ready(function() {
	$("table").on("click", "tr", function() {
		//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
		var nb_no = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/noticeboard/adminview?nb_no="+nb_no);
	});
	
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/noticeboard/write";
		

	});
	
	//공지사항 삭제 이벤트
	$("#delete").click(function() {
		$(location).attr("href", "/noticeboard/delete?nb_no="+nb_no);
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
	background: white !important;
}
</style></head>

<body>


<div id="menu" style="height:100%;width:20%;float:left;">

  <jsp:include page="/view/layout/sidebar.jsp" /> </div>

<div id="content" style="padding:20px; border-left: 1px solid #D8D8D8; height:100%;width:77%;float:left;">


<div id="btnBox" style="margin-top : 2%; margin-right:2%; float:right;">
 <button id="btnWrite" class="btn btn-primary">등록</button>
</div>


<div>
<h3>게시판 관리 - 공지사항</h3>
<br>
</div>
<hr>
<table class="table table-hover table-striped table-condensed">
<thead>
<tr>
<th style="width: 10%">번호</th>
<th style="width: 20%">제목</th>
<th style="width: 20%">작성자</th>
<th style="width: 10%">조회수</th>
<th style="width: 10%">작성일</th>
<th style="width: 10%">수정 </th>
<th style="width: 10%">삭제</th>

</tr>
</thead>

<tbody>
<c:forEach items="${nboardlist }" var="nboardlist">
<tr>
<td>${nboardlist.nb_no }</td>
<td><a href="/noticeboard/adminview?nb_no=${nboardlist.nb_no }">${nboardlist.nb_title }</a></td>
<td>관리자</td>
<td>${nboardlist.nb_count }</td>
<td><fmt:formatDate value="${nboardlist.nb_date }" pattern="yyyy-MM-dd"/></td>
<td id="modify"><a href="/noticeboard/modify?nb_no=${nboardlist.nb_no }" style="color:blue;">수정</a></td>
<td id="delete"><a href="/noticeboard/delete?nb_no=${nboardlist.nb_no } "  style="color:red;">삭제</a></td>
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



<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>












<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



