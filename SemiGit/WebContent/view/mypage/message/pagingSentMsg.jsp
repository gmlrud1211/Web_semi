<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="text-center">
	<ul class="pagination pagination-sm">
	<%-- 첫 페이지가 아니라면 처음 버튼 보이기 --%>
<%-- 	<c:if test="${paging.curPage ne 1 }"> --%>
<!-- 		<li> -->
<!-- 		<a href="/mypage/message/sent?curPage=1">&larr;처음</a> -->
<!-- 		</li> -->
<%-- 	</c:if> --%>
	
	<%-- 이전 페이지그룹 --%>
	<c:if test="${paging.curPage le paging.pageCount }">
	<li class="disabled"><span>&laquo;</span></li>	
	</c:if>
	
	<c:if test="${paging.curPage gt paging.pageCount }">
	<li><a href="/mypage/message/sent?curPage=${paging.startPage-paging.pageCount}">&laquo;</a></li>	
	</c:if>
	
	<%-- 이전 페이지 --%>
	<c:if test="${paging.curPage eq 1 }">
	<li class="disabled"><span>&lt;</span></li>	
	</c:if>
	
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/mypage/message/sent?curPage=${paging.curPage-1}">&lt;</a></li>	
	</c:if>
	
	<%-- 페이징 리스트 --%>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	<c:if test="${paging.curPage eq i }">
	<li class="active"><a href="/mypage/message/sent?curPage=${i }">${i }</a></li>
	</c:if>
	
	<c:if test="${paging.curPage ne i }">
	<li><a href="/mypage/message/sent?curPage=${i }">${i }</a></li>
	</c:if>
	</c:forEach>
	
	<%-- 다음 페이지 --%>
	<c:if test="${paging.curPage eq paging.totalPage }">
	<li class="disabled"><span>&gt;</span></li>	
	</c:if>
	
	<c:if test="${paging.curPage ne paging.totalPage }">
	<li><a href="/mypage/message/sent?curPage=${paging.curPage+1}">&gt;</a></li>
	</c:if>
	
	<%-- 다음 페이지그룹 --%>
	<c:if test="${paging.endPage le paging.totalPage }">
	<li class="disabled"><span>&raquo;</span></li>	
	</c:if>
	<c:if test="${paging.endPage ne paging.totalPage }">
	<li><a href="/mypage/message/sent?curPage=${paging.startPage+paging.pageCount}">&raquo;</a></li>
	</c:if>

	<%-- 끝페이지 --%>
<%-- 	<c:if test="${paging.curPage ne paging.totalPage }"> --%>
<%-- 		<li><a href="/mypage/message/sent?curPage=${paging.totalPage}">끝&rarr;</a></li> --%>
<%-- 	</c:if> --%>
	
	</ul>


</div>