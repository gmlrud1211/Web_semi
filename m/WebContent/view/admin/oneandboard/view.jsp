<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/view/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	$("#btnList").click(function() {
		$(location).attr("href", "/oneandboard/list");
	});
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/oneandboard/modify?one_no=${oboardview.one_no }");
	});
	$("#btnDelete").click(function() {
		$(location).attr("href", "/oneandboard/delete?one_no=${oboardview.one_no }");
	});
});
</script>

<div class="container">

<h3>1대1문의 상세보기</h3>
<hr>

<div>
<table class="table table-bordered">
<tr>
<td style="background-color : #D8D8D8;"class="info">글번호</td><td>${oboardview.one_no }</td>
<td style="background-color : #D8D8D8;"class="info">글제목</td><td>${oboardview.one_title }</td>
</tr>

<tr>
<td style="background-color : #D8D8D8;"class="info">아이디</td><td>${oboardview.u_id }</td>
<td style="background-color : #D8D8D8;"class="info">이름</td><td>${oboardview.u_name }</td>
</tr>


<tr>
<td style="background-color : #D8D8D8;"class="info">글내용</td><td colspan="3">${oboardview.one_content }</td>

</tr>

<tr>
<td style="background-color : #D8D8D8;"class="info">작성일</td><td colspan="4">${oboardview.one_date }</td>
</tr>

<tr>
<td style="background-color : #D8D8D8;"class="info">파일이미지</td><td colspan="4">
    <img src="/cos/upload/${oboardview.file_storedname }"/></td>
</tr>
</table>
</div>

<!-- 답변 부분   -->
<div>
<table class="table table-bordered">

 <tr>
   
   <td style="background-color : #D8D8D8;"class="info">답변내용</td><td colspan="5">
    <c:if test="${oboardview.one_anscontent eq null }">
           미등록 
    </c:if>
    
    <c:if test="${oboardview.one_anscontent ne null }">
    ${oboardview.one_anscontent }
    </c:if></td>
 </tr>


   <tr>
    <td style="background-color : #D8D8D8;" class="info">답변 날짜 </td><td colspan="5">
    <c:if test="${oboardview.one_ansdate  eq null }">
           미등록 
    </c:if>
    
    <c:if test="${oboardview.one_ansdate  ne null }">
    ${oboardview.one_date } 
    </c:if></td>
   </tr>
   




</table>
</div>

<!-- <div class="text-center">	 -->
<!-- 	<button id="btnList" class="btn btn-primary">목록</button> -->

<!-- 	<button id="btnDelete" class="btn btn-danger">삭제</button> -->
<!-- </div> -->
</div>

<jsp:include page="/view/layout/footer.jsp" />
















