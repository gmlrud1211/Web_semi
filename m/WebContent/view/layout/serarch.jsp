<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 검색창 -->
<form action="/board/search" method="post" class="form-horizontal">
<div style="margin-left:120px">	
	<div class="col-sm-2 control-div form-group">
      <select class="form-control" id="type" name="type">
         <option value="title">글제목</option>
         <option value="writer">작성자</option>
         <option value="content">글내용</option>
      </select>
   </div>
	<div class="form-group" style="width:96%">
		<div class="col-sm-6 col-sm-offset-3 control-div" style="margin-left:0px">
			<input type="text" id="keyword" name="keyword" class="form-control" placeholder="검색어를 입력하세요">
		</div>
		<button type="submit" id="btnSearch" class="btn btn-info">검색</button> 
   </div>	
</div>
</form>
