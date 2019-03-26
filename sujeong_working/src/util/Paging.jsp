<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
<div align="center" style="margin-bottom: 20px">
	<ul class="pagination paginaion-sm">
		
		<c:if test="${paging.curPage ne 1 }">
		<li><a href="/board/paginglist?curPage=1">&larr;처음</a></li>
		
		</c:if>
		<li><a href="/board/paginglist?curPage=${paging.startPage-paging.pageCount }">&laquo;</a></li>
		<!-- 이전페이지  -->
		
		<c:if test="${paging.curPage eq 1 }">
		<li class="disabled"><span>&lt;</span></li>
		</c:if>
		
		<c:if test="${paging.curPage ne 1 }">
		<li><a href="/board/paginglist?curPage=${paging.curPage-1 }">&lt;</a></li>
		</c:if>
		
		<c:forEach begin="${paging.startPage }" end="${ paging.endPage}" var="i"> 
		
		<c:if test="${paging.curPage eq i }">
		<li class="active"><a href="/board/paginglist?curPage=${i }">${i } </a>
		</c:if>
		<li><a href="/board/paginglist?curPage=${i }">${i } </a></li>
		</c:forEach>
		
		<li><a href="/board/paginglist?curPage=${paging.startPage+paging.pageCount }">&raquo;</a></li>
		<li><a href="/board/paginglist?curPage=${paging.curPage+1 }">&gt;</a></li>
	</ul>
</div>