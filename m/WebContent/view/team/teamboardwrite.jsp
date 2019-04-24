<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/view/layout/header.jsp"/>

<title>팀별자료실 게시글 등록</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

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
		popup.location = "/team/board/file";
	});
});

function sendData(no, name) {
	$("#file_no").val(no); //파일번호넣기
	$("#upResult").html(name); //파일이름 넣기
}
</script>



<div class="wrapper">
<div class="container">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="name"><h2>Team Page</h2></div>
	          <div class="list-group" style="box-shadow: none;">
	            <a href="#" class="list-group-item" style="border:none;">스터디룸 메인</a>
	            <a href="#" class="list-group-item" style="border:none;">일정 관리</a>
	            <a href="/team/achive/view" class="list-group-item" style="border:none;">목표 관리</a>
	            <a href="/team/board" class="list-group-item" style="border:none;">팀별 게시판</a>
	            <a href="/team/manage" class="list-group-item" style="border:none;">스터디룸 관리</a>

        	 </div>
        	</div><!--/.sidebar-offcanvas-->

		 <div class="col-xs-12 col-sm-9">
	          <p class="pull-right visible-xs">
	            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
	          </p>
	          
	          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280; border-radius: 0;" >
	            <h2>팀별게시판</h2>
	            <p style="font-size: 16px">자료공유를 생활화 합시다~_~</p>
	          </div>
	          
	     	<div class="row">

			<form action="/team/board/write" method="post">
			<br><br>
				<table >
					<tr>
						<td>파일이름을 입력해주쎄용~ &nbsp;&nbsp;&nbsp;&nbsp; </td>
						<td><input type="text" name="sb_content" style="width:100%">	
							<input type="hidden" id="file_no" name="file_no" />
						</td>
					</tr>
					
					<tr>
						<td>업로드할 파일을 골라주세용~ &nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><button type="button" class="btn btn-sm" id="btnFile" style="color:#ffffff; background:#F67280">파일 선택..</button><span id="upResult"></span></td>
					</tr>
				
				</table>
		
				<br><br>
				<div id="btnBox" class="btn btn-round" >
					<button  class="btn btn-sm" style="color:#ffffff; background:#F67280">작성</button>
				</div>
			</form>
    	
    	
    	 </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>
    
</div>
</div>
			