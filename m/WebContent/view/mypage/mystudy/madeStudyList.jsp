<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/view/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	/* $("#clickAppliedList").click(function(){ */
		
		$(document).on('click','.clickAppliedList',function(){
		var study_no = $(this).attr('name');
	    console.log(study_no);
	      $.ajax({
	         type: "post"
	         , url: "/mypage/mystudy/applylist"
	         , data: {
	            "study_no":study_no
	            }
	         , dataType: "html"
	         , success: function(data){
// 	              $(".appliedList").html(data);
					console.log( $(".clickAppliedList[name='"+study_no+"']").next())
	              $(".clickAppliedList[data-name='"+study_no+"']").next().html(data);
	         }
	         , error: function(e) {
	            alert("실패했습니다. 다시 시도해주세요");
	            console.log(e);
	         }
	      });
		
		if($(this).next().hasClass("show")){
			$(this).next().removeClass("show");
		} else {
			$(this).next().addClass("show");
		}
// 		if($(".appliedList").hasClass("show")){
// 			$(".appliedList").removeClass("show");
// 		} else {
// 			$(".appliedList").addClass("show");
// 		}
	});
	
	$("#recruitEnd").click(function() {
		
		var study_no = $(this).parent().parent().attr('data-name');
		
		var endConfirm = confirm('모집을 종료하시겠습니까?');   
		if (endConfirm) {   
	  		location.href = "/mypage/mystudy/recruitend?study_no=" + study_no 		      
	  	} else {
	  		return;
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
td{text-align:center;}

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
						href="/mypage/mystudy/imade" style="color: #F67280;">내가 만든스터디</a></li>
					<li role="presentation"><a href="/mypage/mystudy/apply" style="color: #555;">신청한 스터디</a></li>
				</ul>
				<div class="row" style="margin: 0px;">
				<c:if test="${mystudy.size() > 0}">
					<c:forEach items="${mystudy }" var="mystudy"> <!-- 만든 스터디 띄워주기 -->
					<div class="thumbnail col-sm-12" data-name="${mystudy.study_no }" >
						<div class="col-sm-3" style="width: 200px; height: 200px;">
							<img src="/cos/upload/${mystudy.file_storedname }"  alt="study image" width="200" height="200" style="padding-right:20px"/><br>
						</div>
						<div class="caption col-sm-9">
							<span class="label label-default" id="recruitEnd"
								style="float: right; font-size: 95%;">모집종료</span>
							<h3>${mystudy.study_name }</h3>
							<p>스터디 설명</p>
							<div class="clickAppliedList" data-name="${mystudy.study_no }" name="${mystudy.study_no }" style="text-align: center;cursor:pointer">
							신청자 리스트 <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></div>
							<div class="appliedList">
								<c:if test="신청자 없음">
									<div style="text-align: center;">아직 신청자가 없습니다</div>
								</c:if>
							</div>
						</div>
					</div>
					</c:forEach> 
					</c:if>
				<c:if test="${mystudy.size() eq 0}">
						<div>
							<img src="/img/search.png" width="100" height="100"
								style="margin-left: 45%; margin-top: 20px; margin-bottom: 30px;" /><br>
							<div style="text-align: center;">
								<h4>개설하신 스터디가 없습니다</h4>
							</div>
							<div style="text-align: center;">
								<h4>관심 분야의 스터디를 만들어 보세요!</h4>
							</div>
						</div>
					</c:if>

				</div>

<%-- 				<c:if test="${List.size()>0 }"> --%>
<%-- 					<jsp:include page="./pagingMadeStudy.jsp" /> --%>
<%-- 				</c:if> --%>

			</div>
			<!--/.col-xs-12.col-sm-9-->


		</div>
	</div>

</div>



