<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="/view/layout/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOMO</title>

<script type="text/javascript">

		$(document).ready(function() {
			$("#btnSub").click(function() {
				$("form").submit();
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			})
			
			

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
				popup.location = "/banners/file";
			});
		});
		
		function sendData(no, name) {
			$("#file_no").val(no); //파일번호넣기
			$("#upResult").html(name); //파일이름 넣기
		}
		
	</script>
</head>

<body>
<div id="menu" style="height:100%;width:20%;float:left;">

  <jsp:include page="/view/layout/sidebar.jsp" /> </div>


<div id="content" style="backgound-color:#EEEEEE;height:100%;width:77%;float:left;">


<div style="margin-left:70px; margin-bottom:40px; margin-top:30px">
<h3>배너등록</h3>
</div>


<div class="container">

<div>
<form action="/banners/write" method="post"
 class="form-horizontal">
	<div class="form-group">
		<label for="title" class="col-sm-3 col-sm-offset-1 control-label"
		>배너명</label>
		<div class="col-sm-5">
		<input type="text" id="title" name="title" placeholder="특수문자는 사용할수 없습니다" 
			class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
      
		<label for="image" class="col-sm-3 col-sm-offset-1 control-label">이미지</label>
		
		<div class="col-sm-5">
		
		<input type="hidden" id="file_no" name="file_no" />
		<button type="button" id="btnFile" class="btn btn-default" >파일 첨부</button>
		<span id="upResult"></span>
		</div>
	  
	</div>
	
<!-- 	<div class="form-group"> -->
<!-- 		<label for="link" class="col-sm-3 col-sm-offset-1 control-label">연결링크</label> -->
<!-- 		<div class="col-sm-5"> -->
<!-- 		<input type="text" id="link" name="link"  -->
<!-- 			class="form-control"/> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<div class="form-group">
		<label for="number" class="col-sm-3 col-sm-offset-1 control-label">순서</label>
		<div class="col-sm-5">
		<input type="text" id="" name="number" value="${bannerview.bn_no }"
			class="form-control"/>
		</div>
	</div>

  <div class="col-sm-offset-4">
	<button type="button" id="btnSub" class="btn btn-sm" style="color:#ffffff; background:#F67280">등록</button>
	<button type="button" id="btnCancel" class="btn btn-sm" style="color:#ffffff; background:#FA4C64">취소</button>
	</div>
	
</form>
</div>
</div>

</div>


<br>



	


<div style="clear:both;">
<jsp:include page="/view/layout/footer.jsp" />
</div>












<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
























