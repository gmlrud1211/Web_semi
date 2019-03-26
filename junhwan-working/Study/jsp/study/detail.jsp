<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/view/layout/junheader.jsp"></jsp:include>

<div id="wrapper">
	<div class="left">
		<div class="div1">
			<a style="margin-top: 50px;"><img src="/img/1.jpg" alt="대표이미지"></a>
		</div>
		<div class="div2">
			<!-- 스터디 신청은 studytaemstate테이블로//찜하기는 bookmark -->
			<c:if test="${isBookmark }">
			<button id="btnBookmarkBf" type="button" style="width: 45%;"
				class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">
				<span id="comment">찜하기</span>
			</button>
			</c:if>
			<c:if test="${!isBookmark }">
			<button id="btnBookmarkBf" type="button" style=" width: 45%;"
				class="btn btn-default dropdown-toggle"
				style="margin-right: 50px; margin-bottom: 30px;">
				<span id="comment">찜하기 완료됨</span>
			</button>
			</c:if>
			<c:if test="${isApply }">
				<button id="btnApplyStudyBf" type="button"
					class="btn btn-default dropdown-toggle"
					style="margin-right: 30px; margin-bottom: 30px; float: right; width: 45%;">
					<span id="comment1">신청하기</span>
				</button>
			</c:if>
			<c:if test="${!isApply }">
				<button id="btnApplyStudyBf" type="button" class="btn btn-default dropdown-toggle"
					style="margin-right: 30px; margin-bottom: 30px; float: right; width: 45%;" disabled>
					<span id="comment1">이미 신청하셨습니다.</span>
				</button>
			</c:if>
		</div>
	</div>
	<div id="info" class="right" style="margin-top: 100px;">
		<h3 class="title">
			<strong style="font-size: 16px;">스터디 이름:
				${studyDetail.study_name }</strong>
		</h3>
		<br>
		<p class="p">지역 : ${studyDetail.study_region }</p>
		<p class="p">희망시간 : ${studyDetail.study_time }</p>
		<p class="p">빈도수 : ${studyDetail.study_freq }</p>
		<p class="p">성별 : ${studyDetail.study_gender }</p>
		<a href="/mypage/message/send"><p class="p"
				style="background-color: pink;">팀장이름 : ${studyDetail.u_name }</p></a>
		<p class="p">
			스터디 시작일 :
			<fmt:formatDate value="${studyDetail.study_opendate }"
				pattern="yyyy-MM-dd" />
		</p>

	</div>
	<!--    <p class="p">상세내용 : ????????</p> -->
	<ul id="obj" class="obj">
		<li
			style="font-size: 16px; font-family: sans-serif; margin-left: 30px"
			class="obj-list obj-list1" id="oblist1">${studyDetail.study_details }</li>
		<li
			style="font-size: 16px; font-family: sans-serif; margin-left: 30px"
			class="obj-list obj-list1" id="oblist1">${studyDetail.study_details }</li>
		<li
			style="font-size: 16px; font-family: sans-serif; margin-left: 30px"
			class="obj-list obj-list1" id="oblist1">${studyDetail.study_details }</li>
	</ul>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//찜하기
		$("#btnBookmarkBf").click(function() {
			var study_no = ${studyDetail.study_no };

			$.ajax({
				type : "get",
				url : "/mypage/bookmark/insert",
				data : {
					"study_no" : study_no,
				}

				,
				success : function(data) {
					alert(data.like);
					$("#comment").html(data.comment);
				}

			})

		});
		//신청하기
		$("#btnApplyStudyBf").click(function() {
			var study_no = ${studyDetail.study_no };
			var u_no = ${studyDetail.u_no };
			$.ajax({
				type : "get",
				url : "/mypage/mystudy/insert",
				data : {
					"study_no" : study_no,
					"u_no" : u_no,
				},
				success : function(data) {
					alert(data.apply);
					$("#comment1").html(data.comment1);
					if ((data.comment1) == "신청완료") {//신청완료가 되면 버튼 비활성화
						$("#btnApplyStudyBf").attr("disabled", true);
					}
				}
			})
		});
		
	      $("#sendMsg").click(function(){
	          window.open("/mypage/message/send?sender_no="+sender_no+"&receiver_no="+receiver_no+"&type=send", "window팝업", "width=400, height=350, menubar=no, status=no, toolbar=no");
	       });
	})
</script>
</body>