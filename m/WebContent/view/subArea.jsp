<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" id="Category_Study">
	<ul style="list-style:none; overflow: hidden; margin-top: 30px;">
	<c:forEach var="studyList" items="${StudyList_cate}" varStatus="i">
		<li style="float:left; width:33.333%; margin-bottom:40px" id=momo<c:out value="${studyList.st_catecode }"/>>
			<p><img src="/cos/upload/<c:out value="${studyList.file_storedname}" />"></p>
			<p><a href="/study/detail?study_no=<c:out value="${studyList.study_no}" />" id=study_name style="color:#4888ca; font-size:15px"><c:out value="${studyList.study_name}"/></a></p>
			<p><c:out value="${studyList.st_cate}"/> > <c:out value="${studyList.st_subcate}"/> </p> 
			<p>[지역] <c:out value="${studyList.study_region}" /></p>
			<p>희망 스터디 빈도 : <c:out value="${studyList.study_freq}" /></p>
			<p>스터디 시간  : <c:out value="${studyList.study_time}" /></p>
			<p>모집마감 : <c:out value="${studyList.study_opendate}" /></p>
		</li>	
	</c:forEach>
	</ul>
</div>