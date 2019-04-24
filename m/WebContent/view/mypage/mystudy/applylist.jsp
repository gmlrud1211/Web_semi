<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

$(document).ready(function() {

	   $("#accept").click(function() {
		   console.log("11111");
			var type = "accept";
			var study_no = $(this).parent().parent().attr('var')
			var u_no = $(this).parent().parent().attr('data')
			  
			location.href = "/mypage/mystudy/accept?type=" + type + "&study_no=" + study_no + "&u_no=" + u_no;
			
	   });
	   
	   $("#decline").click(function() {
			var type = "decline";
			var study_no = $(this).parent().parent().attr('var')
			var u_no = $(this).parent().parent().attr('data')
			  
			location.href = "/mypage/mystudy/accept?type=" + type + "&study_no=" + study_no + "&u_no=" + u_no;
	   });
});
	   
</script>
<table class="table table-hover">
	<%-- 										<c:forEach> <!-- 신청자 리스트 띄워주기 --> --%>
	<tbody>
		
		<c:choose>
			<c:when test="${not empty applyl}">
				<tr>
					<td class="u_name">이름</td>
					<td>생년월일</td>
					<td>연락처</td>
					<td>수락/거절</td>
				</tr>
				<c:forEach items="${applyl }" var="applylist">
					<tr var = "${applylist.study_no }" data="${applylist.u_no }">
						<td class="u_name">${applylist.u_name }</td>
						<td>${applylist.u_birth }</td>
						<td>${applylist.u_phone }</td>
						<c:if test="${applylist.ts_statecode eq 1}">
						<td id="btnArea">
							<c:if test="true">
								<button type="button" class="btn btn-sm applybtn" id="accept"
									style="color: white; background: #355C7D;">수락</button>
								<button type="button" class="btn btn-sm applybtn" id="decline"
									style="color: white; background: #F67280;">거절</button>
							</c:if> <c:if test="수락">수락</c:if> <c:if test="거절">거절</c:if>
						</td>
						</c:if>
						<c:if test="${applylist.ts_statecode eq 2}">
							<td id="btnArea">
							<button type="button" class="btn btn-sm applybtn" style="color: white; background: #355C7D;" disabled="disabled">수락완료</button>
							</td>
						</c:if>
						<c:if test="${applylist.ts_statecode eq 3}">
							<td id="btnArea">
							<button type="button" class="btn btn-sm applybtn" style="color: white; background: #F67280;" disabled="disabled">거절완료</button>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td>신청한 신청자가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<%-- 										</c:forEach> --%>
</table>