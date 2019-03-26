<%@page import="java.util.ArrayList"%>
<%@page import="dto.Study"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <jsp:include page="/view/layout/meta.jsp"></jsp:include> --%>
<jsp:include page="/view/layout/junheader.jsp"></jsp:include>
<script type="text/javascript">
	function button1_click(cate, reg, time, gender) {
		//옵션 선택시 받아올 값 저장할 변수 선언&&수정해줘야함;;
		var cate = $('.cate').val();
		var reg = $('.selTop').val();
		var time = $('input:radio[name=time]:checked').val();
		var gender = $('input:radio[name=gender]:checked').val();

		if (!cate) {
			alert("스터디 카테고리를 선택해주세요!!");
		} else if (!reg) {
			alert("지역 카테고리를 선택해주세요!!");
		} else if (!time) {
			alert("시간을 체크해주세요!!");
		} else if (!gender) {
			alert("성별을 체크해주세요!!");
		} else {
			return;
		}
	}
</script>

<div id="wrapper">
	<c:if test="${cate_no eq 1 }">
		<h1>IT프로그래밍</h1>
	</c:if>
	<c:if test="${cate_no eq 2 }">
		<h1>디자인</h1>
	</c:if>
	<c:if test="${cate_no eq 3 }">
		<h1>콘텐츠제작</h1>
	</c:if>
	<c:if test="${cate_no eq 4 }">
		<h1>자격증</h1>
	</c:if>
	<c:if test="${cate_no eq 5 }">
		<h1>취업</h1>
	</c:if>
	<c:if test="${cate_no eq 6 }">
		<h1>외국어</h1>
	</c:if>
	<c:if test="${cate_no eq 7 }">
		<h1>음악</h1>
	</c:if>
	<c:if test="${cate_no eq 8 }">
		<h1>뷰티</h1>
	</c:if>
	<c:if test="${cate_no eq 9 }">
		<h1>수능</h1>
	</c:if>

	<form name="searchStudy" id="searStu" method="post"
		action="/study/filter">
		<ul class="cate_list" style="height: 100px;">
			<li><span class="title">카테고리선택</span> <select class="cate"
				name="cateCode">
					<option value="">전체</option>
					<c:forEach items="${studycate1 }" var="cate">
						<option value="${cate.st_code }">${cate.st_subcate }</option>
					</c:forEach>
			</select></li>
			<li>
			<li>
				<div class="region">
					<span class="title">지역 선택</span> <select class="selTop"
						name="selRegion">
						<option value="">시/도</option>
						<option value="강남">강남</option>
						<option value="인천">인천</option>
						<option value="홍대">홍대</option>
						<option value="일산">일산</option>
						<option value="deagu">대구</option>
						<option value="wulsan">울산</option>
						<option value="busan">부산</option>
						<option value="gyeonggi">경기</option>
						<option value="gangwon">강원</option>
						<option value="chungbuk">충북</option>
						<option value="chungnam">충남</option>
						<option value="zenbuk">전북</option>
						<option value="zennam">전남</option>
						<option value="gyeongbuk">경북</option>
						<option value="gyeongnam">경남</option>
						<option value="jeju">제주</option>
						<option value="seojong">세종</option>
					</select>
				</div>
			</li>
		</ul>
		<div class="hope">
			<h4 class="title">시간선택</h4>
			<ul class="checkreg">
				<li><input type="radio" class="checkbox1" name="time" id="chk1"
					value="전시간가능" /><label for="chk1">전시간가능</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk2"
					value="주중 시간무관" /><label for="chk2">주중 시간무관</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk3"
					value="주중 오전" /><label for="chk3">주중 오전</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk4"
					value="주중 오후" /><label for="chk4">주중 오후</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk5"
					value="주말 시간무관" /><label for="chk5">주말 시간무관</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk6"
					value="주말 오전" /><label for="chk6">주말 오전</label></li>
				<li><input type="radio" class="checkbox1" name="time" id="chk7"
					value="주말 오후" /><label for="chk7">주말 오후</label></li>
			</ul>
		</div>
		<div class="gender">
			<h4 class="title">성별선택</h4>
			<ul class="checkgen" style="height: 100px;">
				<li><input type="radio" class="checkbox2" name="gender"
					id="chk8" value="무관" /><label for="chk8">무관</label></li>
				<li><input type="radio" class="checkbox2" name="gender"
					id="chk9" value="남" /><label for="chk9">남</label></li>
				<li><input type="radio" class="checkbox2" name="gender"
					id="chk10" value="여" /><label for="chk10">여</label></li>
			</ul>
		</div>
		<div class="btn" style="width: 1025px;">
			<input type='hidden' name = 'cate_no' value='${cate_no}'>
			<button onclick="button1_click('cate,reg,time,gender')"
				class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">선택한 조건으로
				검색</button>
			<button type="reset" class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">조건 초기화</button>
			<hr>
		</div>
	</form>
	<div class="container">
		<!-- 스터디 목록 출력 -->
		<c:forEach items="${studyFilter }" var="study" begin="0" end="9999">
			<ul class="search_list">
				<!-- 앵커 누르면 detail페이지로 연결 -->
				<li><a href="/study/detail?study_no=${study.study_no }">
						<div class="left">
							<div class="div1">
								<img src="/img/1.jpg" alt="대표이미지">
								<hr>
							</div>
						</div>
						<div class="right">
							<h3 class="title">${study.study_name }</h3>
							<br>
							<p class="p">지역 : ${study.study_region }</p>
							<p class="p">희망시간 : ${study.study_time }</p>
							<p class="p">빈도수 : ${study.study_freq }</p>
							<p class="p">성별 : ${study.study_gender }</p>
							<p class="p">팀장이름 : ${study.u_name }</p>
							<p class="p">
								스터디 시작일 :
								<fmt:formatDate value="${study.study_opendate }"
									pattern="yyyy-MM-dd" />
							<hr>
						</div>

				</a></li>
			</ul>
		</c:forEach>
	</div>
</div>
</body>
</html>