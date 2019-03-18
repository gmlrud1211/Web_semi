<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
<div class="wrapper">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<jsp:include page="/view/layout/mypage.jsp"/>


        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280;
          border-radius: 0;" >
            <h2>나의 1:1 문의</h2>
            <p style="font-size: 16px">관리자에게 궁금한 점을 언제든지 질문하세요!</p>
          </div>
          <div class="row" style="margin: 0px;">
   			<form class="form-horizontal" action="/mypage/myqna/ask" method="post">
   				<div class="form-group">
			    <label for="qnaTitle" class="col-sm-2 control-label">문의글 제목</label>
			    <div class="col-sm-10">
			    	<input type="text" class="form-control" id="qnaTitle" placeholder="제목을 입력해주세요">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="qnaImage" class="col-sm-2 control-label">이미지 첨부</label>
			    <div class="col-sm-10">			    
			   	 	<input type="file" id="qnaImage">
			    	<p class="help-block">참고 이미지를 업로드해주세요</p>
			    </div>
			  </div>
			  <div class="form-group">
			  	<label for="qnaContent" class="col-sm-2 control-label">내용 작성</label>
			 	<div class="col-sm-10">		
			 		<textarea class="form-control" id="qnaContent" rows="10" placeholder="내용을 작성해주세요"></textarea>	    
			   </div>
			  </div>
			  
			  <button type="submit" class="btn btn-default" style="float:right;">문의하기</button>
			</form>
   			
   
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>

</div>
