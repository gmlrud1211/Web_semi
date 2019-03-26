<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/view/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	$("#clickAppliedList").click(function(){
		if($(".appliedList").hasClass("show")){
			$(".appliedList").removeClass("show");
		} else {
			$(".appliedList").addClass("show");
		}
	});
});
</script>
<style type="text/css">
.appliedList{
 	display:none; 
}
.appliedList .show {
	display:block;		
}

</style>

<div class="wrapper">
	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">

			<jsp:include page="/view/layout/mypage.jsp" />


			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>

				<div class="jumbotron"
					style="padding: 5px; background-color: #eee0; border-bottom: 1px solid #f67280; border-radius: 0;">
					<h2>내가 만든 스터디</h2>
					<p style="font-size: 16px">직접 개설한 스터디 목록입니다</p>
				</div>

				<ul class="nav nav-tabs" role="tablist" style="margin-bottom: 30px;">
					<li role="presentation" class="active"><a
						href="/mypage/mystudy/imade" style="color: #F67280;">내가 만든
							스터디</a></li>
					<li role="presentation"><a href="/mypage/mystudy/apply"
						style="color: #555;">신청한 스터디</a></li>
				</ul>

				<div class="row" style="margin: 0px;">

					<%--    			<c:forEach> --%> <!-- 만든 스터디 띄워주기 -->

					<div class="thumbnail col-sm-12">
						<div class="col-sm-3" style="width: 200px; height: 200px;">
							<%-- <img src="/cos/upload/${list.file_storedname }" --%><img src="/img/1.jpg" alt="study image" width="200" height="200" style="padding-right:20px"/><br>
						</div>
						<div class="caption col-sm-9">
							<span class="label label-default"
								style="float: right; font-size: 95%;">스터디상태</span>
							<h3>스터디제목</h3>
							<p>스터디 설명</p>
							<div id="clickAppliedList" style="text-align: center;cursor:pointer">신청자 리스트 <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></div>
							<div class="appliedList">
							<c:if test="true">
									<table class="table table-hover">
<%-- 										<c:forEach> <!-- 신청자 리스트 띄워주기 --> --%>
											<tbody>
												<tr>
													<td>번호</td>
													<td class="u_name">이름</td>
													<td>아이디</td>
													<td>생년월일</td>
													<td>성별</td>
													<td>연락처</td>
													<td>
														<c:if test="true">
														<button type="button" class="btn btn-sm" id="accept" style="color:white;background:#355C7D;">수락</button>
														<button type="button" class="btn btn-sm" id="decline" style="color:white; background:#F67280;">거절</button>
														</c:if>
														<c:if test="수락">수락</c:if>
														<c:if test="거절">거절</c:if>
													</td>
												</tr>
											</tbody>
<%-- 										</c:forEach> --%>
									</table>
							</c:if>
							<c:if test="신청자 없음">
								<div style="text-align: center;">아직 신청자가 없습니다</div>
							</c:if>
								</div>
						</div>
					</div>

					<%--    			</c:forEach> --%>


				</div>

<%-- 				<c:if test="${List.size()>0 }"> --%>
<%-- 					<jsp:include page="./pagingMadeStudy.jsp" /> --%>
<%-- 				</c:if> --%>

			</div>
			<!--/.col-xs-12.col-sm-9-->


		</div>
	</div>

</div>



