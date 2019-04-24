<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp" />

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"> </script>

<script type="text/javascript"
 src="/resources/smarteditor2/js/service/HuskyEZCreator.js"
 charset="utf-8"></script>

<script type="text/javascript">
$(document).ready(function() {

	// 저장된 말머리로 세팅
	if("${board.b_head}" == "질문"){
		$("#head").val("질문");
	} else {
		$("#head").val("정보공유");
	}
	

	// 수정 버튼 클릭 시 빈값 검사 후 폼 전송
	$("#btnUpdate").click(function() {
		if($("#head").val() == "default"){
			alert("말머리를 선택해주세요");
			return;
		} else if ($("#title").val() == ""){
			alert("글제목을 입력해주세요");
			$("#title").focus();
			return;
		} else {	
			submitContents($("#btnWrite"));
			$("form").submit();
		}
	});
	
	$("#btnCancel").click(function() {
		history.go(-1);
	});

	// 첨부파일 버튼 클릭 시 
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
				+",left="+(w-300)/2
				+",top="+(h-200)/2)
		
		//팝업 url 설정
		popup.location = "/board/fileupdate?b_no=${board.b_no }";
	});
	
})
function sendData(no, name) {
	$("#fileno").val(no); //파일번호넣기
	$("#upResult").html(name); //파일이름 넣기
}
</script>


<style type="text/css">
#content {
	width: 100%;
}
</style>

<div class="container">

<h3>게시글 수정</h3>
<hr>

<div>
<form action="/board/update" method="post">
<input type="hidden" id="file_no" name="file_no" value="${board.file_no }"/>
<input type="hidden" id="b_no" name="b_no" value="${board.b_no}"/>
<table class="table table-bordered">
<tr>
<td class="info">말머리</td>
<td colspan="2">
<div class="col-sm-4 control-div">
<select class="form-control" name="head" id="head">
	<option value="default">말머리를 선택해주세요</option>
	<option value="정보공유">정보공유</option>
	<option value="질문">질문</option>
</select>
</div>
</td>
</tr>


<tr>
<td class="info">작성자</td>
<td colspan="2">${userName }</td>

</tr>
<tr>
	<td class="info">제목</td>
	<td><input type="text" id="title" name="title" style="width:100%;" value="${board.b_title }" /></td>
</tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="content" class="content" name="content">
${board.b_content }
</textarea></td></tr>
<tr>
<td class="info">첨부파일</td>
<tr><td><button type="button" id="btnFile" class="btn btn-warining">파일첨부</button><span id="upResult">&nbsp;${fileName }</span></td>
</tr>
</table>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-primary">수정</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</form>
</div>
</div>


<script type="text/javascript">
// 스마트에디터 스킨 적용
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "content", //<textarea>의 id를 입력
    sSkinURI: "/resources/smarteditor2/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
    htParams: {
    	bUseToolbar: true, //툴바 사용여부
    	bUseVerticalResizer: false, //입력창 크기 조절 바
    	bUseModeChanger: false //모드 탭
    }
});

// <form>의 submit동작에 맞춰 스마트에디터에 작성한 내용을
//<textarea>의 내용으로 전송함 -> <form>태그의 값으로 적용
function submitContents(elClickedObj) {
    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
    try {
        elClickedObj.form.submit();

    } catch(e) {}
}
</script>
	
<jsp:include page="../layout/footer.jsp" />
















    