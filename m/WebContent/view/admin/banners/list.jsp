<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배너관리</title>



    <jsp:include page="/view/layout/header.jsp" />

<style>

</style>

<script type="text/javascript">
$(document).ready(function() {
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/banners/write";
	});
	
	//공지사항 삭제 이벤트
	$("#delete").click(function() {
		$(location).attr("href", "/banners/delete?bn_no="+bn_no);
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
	vertical-align: middle !important;
	
}

#btnBox {
	text-align: right;
}
</style></head>

<body>



<div id="menu" style="height:100%;width:20%;float:left;">
<jsp:include page="/view/layout/sidebar.jsp" /> </div>


<div id="content" style="height:100%;width:78%;float:left;">

<div id="btnBox" style=" float:right; margin:30px; " >
	<button id="btnWrite" class="btn btn-primary" style="color:#ffffff; background:#F67280;">등록</button>
</div>

<div style="margin:30px; ">
<h3>배너관리</h3>
</div>

<hr>

<div class="container" style="max-width:1063px;">

<div>
<table class="table table-bordered">
<colgroup>
	<col width="5%">
	<col width="15%">
	<col width="*">
	<col width="10%">
	<col width="10%">
</colgroup>
 <thead>
 <tr align="center"  style="color:white; background:#F67280; ">
  <th> 순서 </th>
  <th> 배너명</th>
  <th> 미리보기</th>
<!--   <th> 링크</th> -->
  <th> 관리</th>
</tr>
</thead>

<tbody>
<c:forEach items="${bannerslist }" var="bannerslist">
<tr>
<td>${bannerslist.bn_no }</td>
<td>${bannerslist.bn_title }</td>
<td><img src="/cos/upload/${bannerslist.file_storedname }" style="width:30%; height:30%"></td>
<!-- <td id="link"><a href="#">링크</a></td> -->

<td id="modify"><a href="/banners/modify?bn_no=${bannerslist.bn_no }"  
                  style="color:blue; ">수정</a><br><br>
<a href="/banners/delete?bn_no=${bannerslist.bn_no } " style="color:red;">삭제</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</div>

<jsp:include page="/view/layout/bannerspaging.jsp" />
      
<br>




</div>



<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>












<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



















