<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="/view/layout/header.jsp" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>MOMO</title>
<style>
#container {
	width: 75%;
	margin: 0 auto;
	text-align: center;
}

.tab {
	list-style: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
/* Float the list items side by side */
.tab li {
	float: left;
}
/* Style the links inside the list items */
.tab li a {
	display: inline-block;
	color: #000;
	text-align: center;
	text-decoration: none;
	padding: 14px 16px;
	font-size: 17px;
	transition: 0.3s;
}
/* Style the tab content */
.tabcontent {
	display: none;
	/* 	background-color: grey; */
	padding: 6px 12px;

	/* 	color: black; */
}

ul.tab li.current {
	background-color:;
	/* 	color: black; */
	border-top: 1px solid grey;
	border-left: 1px solid grey;
	border-right: 1px solid grey;
}

.tabcontent.current {
	display: block;
	border: 1px solid grey;
}
</style>
<style>
#container>div {
	border: none;
}

#container>div {
	position: relative;
	/
}

#container>div>table {
	position: absolute;
	top: 0;
	left: 0;
}
</style>

<!-- <script src="https://code.jquery.com/jquery-1.10.2.js"></script> -->

</head>


<%--    	<jsp:include page="/view/layout/mypage.jsp"/>  --%>


<body>
	<div style="max-width:1170px; margin:0 auto; width:100%">
<!-- 		<div id="menu" style="clear: both;"> -->
			<jsp:include page="/view/layout/mypage.jsp" />
<!-- 		</div> -->
	
		<div
			style="padding: 5px; background-color: #eee0;  float: left; border-radius: 0; 
			padding:20px; border-left: 1px solid #D8D8D8;">
			<h2>FAQ</h2>
			<h4>자주 묻는 질문에 대한 답변입니다.</h4>
		</div>

		<div id="container" style="min-height: 350px; float: left; padding:20px; border-left: 1px solid #D8D8D8;">
			<ul class="tab">
				<li class="current" data-tab="tab1"><a href="#">회원가입</a></li>
				<li data-tab="tab2"><a href="#">로그인</a></li>
				<li data-tab="tab3"><a href="#">회원탈퇴</a></li>
				<li data-tab="tab4"><a href="#">일정관리</a></li>
				<li data-tab="tab5"><a href="#">스터디신청</a></li>
				<li data-tab="tab6"><a href="#">스터디만들기</a></li>
				<li data-tab="tab7"><a href="#">쪽지</a></li>
				<li data-tab="tab8"><a href="#">지역</a></li>
			</ul>

			<div id="tab1" class="tabcontent current">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '회원가입'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>


			<div id="tab2" class="tabcontent">

				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '로그인'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab3" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '회원탈퇴'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab4" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '일정관리'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab5" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '스터디신청'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab6" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '스터디만들기'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab7" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '쪽지'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>

			<div id="tab8" class="tabcontent">
				<table class="table table-hover table-striped table-condensed">
					<c:forEach items="${faqlist }" var="faqlist">
						<c:if test="${faqlist.faq_cate == '지역'}">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="10%">
							</colgroup>

							<tr class="qusetion">
								<td style="text-align: left; padding-left: 20px">${faqlist.faq_qusetion }</td>

							</tr>

							<tr class="answer">
								<td colspan="3" style="text-align: left; padding-left: 20px">${faqlist.faq_answer }</td>
							</tr>

						</c:if>
					</c:forEach>

				</table>
			</div>


		</div>
		<div style="text-align: center; float: right; margin-right: 10%; ">
			원하는 답변을 얻지 못하셨다면?
			<button id="btnWrite" class="btn btn-primary">1:1 질문하기</button>
		</div>
	</div>

	<script>
		$(function() {
			$('ul.tab li').click(function() {
				var activeTab = $(this).attr('data-tab');
				$('ul.tab li').removeClass('current');
				$('.tabcontent').removeClass('current');
				$(this).addClass('current');
				$('#' + activeTab).addClass('current');
			})

			//모든 답변 가림 
			$(".answer").css({
				display : "none"
			});

			/* $(".qusetion").click(function() {
				//일단 서브메뉴 다 가립니다.
				//$(".sub").css({display:"none"});

				//열린 서브메뉴에 대해서만 가립니다.
				$(".answer").each(function() {
					console.log($(this).css("display"));
					if ($(this).css("display") == "block") {
						//$(".sub").css({display:"none"});
						//$(this).hide();
						$(this).slideUp("fast");

					}
				});
				//현재 요소의 다음 요소를 보이게 합니다.
				$(this).next("tr").css({display:"block"});
				$(this).next("tr").show();
				$(this).next("tr").slideDown("fast");

			}) */

			$(".qusetion").click(function() {
				$(this).next().toggle();
				$(this).parent().siblings("tbody").find(".answer").hide();
			})

			//글쓰기 버튼 이벤트
			$("#btnWrite").click(function() {
				location.href = "/mypage/myqna/ask";
			});

			$("#delete").click(function() {
				$(location).attr("href", "/faq/delete?faq_no=" + faq_no);
			});

		});
	</script>

</body>
</html>

