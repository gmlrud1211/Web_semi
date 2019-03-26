<%@page import="dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./layout/header.jsp"/>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"> </script>

<script type="text/javascript">

$(document).ready(function() {
	
	// 카테고리 별 스터디 첫번째 요소 액티브
	$("[id=1]").attr('class', 'tabs active');
	
	// 초기 상태 스터디 숨김처리
	$("#Category_Study li").hide();
	$("#Category_Study #momo1").show();
	
	$('li.tabs').click(function() {
		
		var tab_id = $(this).attr('id');
		var category_code = tab_id;
		
		$.ajax({
			type: "post"
			, url: "/study/category"
			, data: {
				"category_code":category_code, 
				}
			, dataType: "html"
			, success: function(data){
				
				// 상단 탭 처리 
				$('ul.tabs').removeClass('active');
				$('.study_contents').removeClass('active');

				$(this).addClass('active');
				
				$('li.tabs').removeClass('active');
				$('li.tabs').addClass('tabs');
				
				$("#"+tab_id).addClass('active');
				
				$("#study_contents").html(data);
				
			}
			, error: function(e) {
				alert("스터디 정보를 가져오는데 실패했습니다");
				console.log(e);
			}
		});
	})
	
	$("#btnMoreBoard").click(function (){
		location.href = "/board/list";
	})
});


</script>
<style>

.tab-study_contents.active{
	display: inherit;
}

li {
	font-size:12px;
}

#title {
	margin-top: 50px;
	margin-bottom : 25px;
}


button {
	background-color: #F67280;
}

#category_study a {
	color: black;
}

.nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover{
	background-color: #F67280 !important;
	color: white !important;
}

.h3, h3 {
	font-weight: 600;

}

#study_name{
	font-size: 15px;
	color: #4888ca;
}

#deadline {
	color: tomato;
	
}

</style>


<html>


<!-- 배너영역 -->
<script>
	$(document).ready(function(){
		
	})
</script>

<!-- 카테고리 별 최신 스터디  시작-->
<div class="container" id="title">
	<h3>NEW ! 최신 스터디</h3><h5>카테고리 별 최신스터디입니다</h5>
</div>
<div class="container" id="category_study">
	<div role="tabpanel">

	<!-- tab 영역 -->
	<ul class="nav nav-pills nav-justified" id="tablist">
		<c:forEach var="cate" items="${cateList}" varStatus="i">
			<li role="presentation" class="tabs" id=<c:out value="${cate.st_catecode}"/>>
				<a href="#tab" role="tab" data-toggle="tab"><c:out value="${cate.st_catename}" /></a>
			</li>
		</c:forEach>
	</ul>
	<!-- 스터디 정보 영역 -->
	<div class="tab-content">
		<div id="study_contents" role="tabpanel" class="tab-panel"> 
			<div class="container" id="Category_Study">
				<ul style="list-style:none; overflow: hidden; margin-top: 30px;">
				<c:forEach var="studyList" items="${StudyList_cate}" varStatus="i">
					<li style="float:left; width:33.333%; margin-bottom:40px" id=momo<c:out value="${studyList.st_catecode }"/>>
						<p><img src="/images/product/1.jpg"></p>
						<%-- <p><img src="/cos/upload/<c:out value="${mystudy.file_storedname}" /></a>"></p>  --%>
						<p><a href="#" id=study_name style="color:#4888ca; font-size:15px"><c:out value="${studyList.study_name}"/></a></p>
						<p><c:out value="${studyList.st_cate}"/> > <c:out value="${studyList.st_subcate}"/> </p> 
						<p>[지역] <c:out value="${studyList.study_region}" /></p>
						<p>희망 스터디 빈도 : <c:out value="${studyList.study_freq}" /></p>
						<p>스터디 시간  : <c:out value="${studyList.study_time}" /></p>
						<p>모집마감 : <c:out value="${studyList.study_opendate}" /></p>
					</li>	
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	</div>
</div>
<!-- 카테고리 별 최신 스터디  끝-->

<!-- 나의 맞춤스터디  시작-->
<div class="container" id="title">
	<h3>나의 맞춤스터디</h3><h5>관심사에 맞는 스터디를 추천해드려요!</h5>
</div>
<div class="container" id="my_Study">

	<ul style="list-style:none; overflow: hidden">
		<c:forEach var="mystudy" items="${myStudy}" varStatus="i" begin="1" end="9">
		<li style="float:left; width:33.333%; margin-bottom:40px">
			<p><img src="/images/product/1.jpg"></p>
<%-- 		<p><img src="/cos/upload/<c:out value="${mystudy.file_storedname}" /></a>"></p>  --%>
			<p><a href="#" id=study_name><c:out value="${mystudy.study_name}" /></a></p>
			<p><c:out value="${mystudy.st_cate}"/> > <c:out value="${mystudy.st_subcate}"/> </p> 
			<p>[지역] <c:out value="${mystudy.study_region}" /></p>
			<p>희망 스터디 빈도 : <c:out value="${mystudy.study_freq}" /></p>
			<p>스터디 시간  : <c:out value="${mystudy.study_time}" /></p>
			<p>모집마감 : <c:out value="${mystudy.study_opendate}" /></p>
		</li>	
		</c:forEach>
	</ul>
	
</div>
<!-- 나의 맞춤스터디  끝-->

<!-- 모집마감 임박 스터디 -->
<div class="container" id="title">
	<h3>모집마감 임박스터디</h3><h5>망설이면 마감됩니다 서둘러 신청하세요!</h5>
</div>
<div class="container" id="deadline_study">
	<ul style="list-style:none; overflow: hidden">
		<c:forEach var="hurrystudy" items="${hurryStudy}" varStatus="i" begin="1" end="6">
		<li style="float:left; width:33.333%; margin-bottom:40px">
			<p><img src="/images/product/1.jpg"></p>
			<p><a href="#" id=study_name><c:out value="${hurrystudy.study_name}" /></a></p>
			<p id="deadline" class="blinkEle">모집마감 : <c:out value="${hurrystudy.study_opendate}" /></p>
			<p><c:out value="${hurrystudy.st_cate}"/> > <c:out value="${hurrystudy.st_subcate}"/> </p> 
			<p>[지역] <c:out value="${hurrystudy.study_region}" /></p>
			<p>희망 스터디 빈도 : <c:out value="${hurrystudy.study_freq}" /></p>
			<p>스터디 시간  : <c:out value="${hurrystudy.study_time}" /></p>
		</li>	
		</c:forEach>
	</ul>
</div>
<!--  모집마감 임박 스터디  끝-->

<!-- 베스트 게시글 -->
<div class="container" id="title">
	<h3>이번주 베스트 게시글</h3><h5>가장 추천을 많이 받은 게시글입니다</h5>
</div>
<div class="container" id="best_board">
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
				List<Board> list = (List) request.getAttribute("bestBoard");
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
						<a href="/board/detail?b_no=<%=list.get(i).getB_no()%>"> <%=list.get(i).getB_title() %>
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
	<div style="text-align:center; padding:25px">
		<button type="button" id="btnMoreBoard" class="btn btn-mm" style="color:#ffffff; background:#F67280">더 많은 게시글 보기</button>
	</div>

</div>

<!-- 베스트 게시글 끝-->
<jsp:include page="./layout/footer.jsp"/>

</html>

