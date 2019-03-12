<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		popup.location = "/file/newtab";
	});
});

function sendData(no, name) {
	$("#file_no").val(no); //파일번호넣기
	$("#upResult").html(name); //파일이름 넣기
}
</script>



</head>
<body>

	<form action="/team/board/write" method="post">
		<table >
			<tr><td>제목</td>
				<td><input type="text" name="sb_content" style="width:100%">	
					<input type="hidden" id="file_no" name="file_no" />
				</td>
			</tr>
			
			<tr><td>업로드할 파일</td>
				<td><button type="button" id="btnFile">파일 선택..</button><span id="upResult"></span></td>
			</tr>
		
		</table>
	
		<button>작성</button>
	</form>
</body>
</html>