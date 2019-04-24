<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/view/layout/header.jsp" />

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
					<h2>나의 스터디룸</h2>
					<p style="font-size: 16px">현재 진행중인 스터디 목록입니다</p>
				</div>
				<div class="row">
					<c:forEach items="${myStudy }" var="myStudy">
						<!-- 만든 스터디 띄워주기 -->
						<div class="thumbnail col-sm-12"">
							<div class="col-sm-3" style="width: 200px; height: 200px;">
								<img src="/cos/upload/${myStudy.file_storedname }"
									alt="study image" width="200" height="200"
									style="padding-right: 20px" /><br>
									
							</div>
							<div class="caption col-sm-9" style="padding:20px">
								<h4>[${myStudy.st_cate }] - [${myStudy.st_subcate }]</h4><br>
								<a href="/team/main?study_no=${myStudy.study_no }"><h4>${myStudy.study_name }</h4></a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>



