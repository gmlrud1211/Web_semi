<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/view/layout/junheader.jsp"></jsp:include>
<script type="text/javascript">
	function button1_click(reg, time, gender) {
		//옵션 선택시 받아올 값 저장할 변수 선언&&수정해줘야함;;
// 		var cate = $("#st_cate").val();
// 		console.log(cate);
		var reg = $('.selTop').val();
		var time = $('input:radio[name=time]:checked').val();
		var gender = $('input:radio[name=gender]:checked').val();

// 		if (!cate) {
// 			alert("스터디 카테고리를 선택해주세요!!");

		
		if (!reg) {
			alert("지역 카테고리를 선택해주세요!!");
		} else if (!time) {
			alert("시간을 체크해주세요!!");
		} else if (!gender) {
			alert("성별을 체크해주세요!!");
		} else {
			var searStu = document.getElementById("searStu");
			searStu.action="/study/filter";
			searStu.submit();
		}
	}
</script>

<div id="wrapper">

	<form name="searchStudy" id="searStu" method="post" action="/study/filter">
		<ul class="cate_list" style="height: 100px;">
<!-- 			<li><span class="title">카테고리선택</span> <select class="cate" -->
<!-- 				name="cateCode"> -->
<!-- 					<option value="">전체</option> -->
<%-- 					<c:forEach items="${studycate1 }" var="cate"> --%>
<%-- 						<option value="${cate.st_code }">${cate.st_subcate }</option> --%>
<%-- 					</c:forEach> --%>
<!-- 			</select></li> -->
<%-- 			<input type="hidden" id="st_cate" value="${st_cate }"> --%>
			<li>
			<li>
				<div class="region">
					<span class="title">지역 선택</span> <select class="selTop"
						name="selRegion">
						<option value="">시/도</option>
						<option value="강남">강남</option>
						<option value="신촌">신촌</option>
						<option value="선릉">선릉</option>
						<option value="가좌">가좌</option>
						<option value="수색">수색</option>
						<option value="일산">일산</option>
						<option value="역삼">역삼</option>
						<option value="건대">건대</option>
						<option value="홍대">홍대</option>
						<option value="종로">종로</option>
						<option value="영등포">영등포</option>
						<option value="잠실">잠실</option>
						<option value="인천">인천</option>
						<option value="노원">노원</option>
						<option value="경기">경기</option>
						<option value="남양주">남양주</option>
						<option value="의정부">의정부</option>
						<option value="일산">일산</option>
						<option value="하남">하남</option>
						<option value="김포">김포</option>
						<option value="분당">분당</option>
						<option value="수원">수원</option>
						<option value="시흥">시흥</option>
						<option value="울산">울산</option>
						<option value="부산">부산</option>
						<option value="강원">강원</option>
						<option value="대구">대구</option>
						<option value="대전">대전</option>
						<option value="충북">충북</option>
						<option value="충남">충남</option>
						<option value="천안">천안</option>
						<option value="전북">전북</option>
						<option value="전남">전남</option>
						<option value="경북">경북</option>
						<option value="경남">경남</option>
						<option value="제주">제주</option>
						<option value="세종">세종</option>
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
			<button type="button"onclick="button1_click('reg,time,gender')"
				class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">선택한 조건으로
				검색</button>
			<button type="reset" class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">조건 초기화</button>
			<hr>
		</div>
	</form>
	<div class="container">
	<c:if test="${sList.size()>0 }">
		<!-- 스터디 목록 출력 -->
		<c:forEach items="${sList }" var="sList" begin="0" end="${sList.size()-1 }">
			<ul class="search_list">
				<!-- 앵커 누르면 detail페이지로 연결 -->
				<li><a href="/study/detail?study_no=${sList.study_no }">
						<div class="left">
							<div class="div1">
								<img src="/cos/upload/${sList.file_storedname }" alt="대표이미지">
								<hr>
							</div>
						</div>
						<div class="right">
							<h3 class="title">${sList.study_name }</h3>
							<br>
							<p class="p">지역 : ${sList.study_region }</p>
							<p class="p">팀장이름 : ${sList.u_name }</p>
							<p class="p">스터디 시작일 : ${sList.study_opendate }</p>
							<hr>
						</div>

				</a></li>
			</ul>
		</c:forEach>
		</c:if>
		<c:if test="${sList.size() eq 0 }">
		<div><h3 style="text-align: center;margin-top: 50px;">개설된 스터디가 없습니다</h3></div>
		</c:if>
	</div>
</div>
</body>
</html>