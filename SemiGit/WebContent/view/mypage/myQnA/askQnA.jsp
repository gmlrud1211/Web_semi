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
			    	<input type="text" class="form-control" name="qnaTitle" placeholder="제목을 입력해주세요">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="qnaImage" class="col-sm-2 control-label">이미지 첨부</label>
			    <div class="col-sm-10">			    
<!-- 			   	 	<input type="file" id="qnaImage"> -->
<!-- 			    	<p class="help-block">참고 이미지를 업로드해주세요</p> -->
					<button type="button" id="btnFile">파일 선택</button>&nbsp;&nbsp;<span id="upResult"></span>
					<input type="hidden" id="file_no" name="file_no" />
			    </div>
			  </div>
			  			  
			  <div class="form-group">
			  	<label for="qnaContent" class="col-sm-2 control-label">내용 작성</label>
			 	<div class="col-sm-10">		
			 		<textarea class="form-control" name="qnaContent" rows="10" placeholder="내용을 작성해주세요"></textarea>	    
			   </div>
			  </div>
			  <button type="submit" class="btn btn-default" style="float:right;">문의하기</button>
			  <button type="button" id="goList" class="btn btn-default" style="float:right;margin-right:10px;">목록으로</button>
			</form>
   			
   
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>

</div>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnFile").click(function() {
		
		//화면크기 구하기
		var w = screen.availWidth;
		var h = screen.availHeight;
		
		//팝업 띄우기
		var popup = window.open(
				"",
				"",
				"status=no" //하단 상태바
				+",menubar=no" //상단 메뉴
				+",scrollbars=no" //스크롤바
				+",resizable=no" //사이즈변경
				+",width=300" //너비
				+",height=200" //높이
				+",left="+(w-300)/2 //x 위치
				+",top="+(h-200)/2 ); //y 위치
		
		//팝업 url 설정
		popup.location = "/mypage/myqna/fileupload";
	});
	
	$("#goList").click(function(){
		history.go(-1);
	});
});

function sendData(no, name) {
	$("#file_no").val(no); //파일번호넣기
	$("#upResult").html(name); //파일이름 넣기
}

</script>
