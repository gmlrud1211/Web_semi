<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 페이지</title>

<style>

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("table").on("click", "tr", function() {
		//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
		var u_no = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/usersmanage/view?u_no="+u_no);
	});
	
	//글쓰기 버튼 이벤트
	$("#btnWrite").click(function() {
		location.href = "/usersmanage/write";
	});
	
	//회원 삭제 이벤트
	$("#delete").click(function() {
		$(location).attr("href", "/usersmanage/delete?u_no="+u_no);
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
    <jsp:include page="/view/layout/header.jsp" />
    </div>

<div id="menu" style="height:100%;width:20%;float:left;">
<jsp:include page="/view/layout/sidebar.jsp" /> </div>

<div id="content" style="height:100%;width:77%;float:left;">

<h3>회원관리</h3>
<hr>

<table class="table table-hover table-striped table-condensed">
<thead>
<tr>
<th style="width: 10%">회원번호</th>
<th style="width: 30%">회원이름</th>
<th style="width: 20%">가입일</th>
<th style="width: 10%">상세</th>
<th style="width: 10%">탈퇴처리</th>

</tr>
</thead>

<tbody>
<c:forEach items="${userslist }" var="userslist">
<tr>
<td>${userslist.u_no }</td>
<td>${userslist.u_name }</td>
<td><fmt:formatDate value="${userslist.u_regdate }" pattern="yyyy-MM-dd"/></td>
<td><a onclick="window.open('/usersmanage/view?u_no=${userslist.u_no }','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');" style="color:blue;">조회</a></td>
<td id="delete"><a href="/usersmanage/delete?u_no=${userslist.u_no }" style="color:red;">삭제</a></td>

</tr>
</c:forEach>
</tbody>
</table>

<jsp:include page="/view/layout/userspaging.jsp" />
      
<br>

<div class='text-center' style="clear:both;">
  <FORM name='search' method='post' action='/usersmanage/search'>
   
      <SELECT name='type'> <!-- 검색 컬럼 -->
       
        <OPTION id='no'  value='no'>회원번호</OPTION>
        <OPTION id='name' value='name'>이름</OPTION>
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



