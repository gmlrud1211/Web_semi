<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/view/layout/header.jsp" />

<script type="text/javascript"
 src="/resources/smarteditor2/js/service/HuskyEZCreator.js"
 charset="utf-8"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		//스마트에디터 내용을 <textarea>에 적용하기
		submitContents($("#btnWrite"));
		
		$("form").submit();
	});
	
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>

<style type="text/css">
#content {
	width: 100%;
}

td.info {
background-color : #BDBDBD;
}


</style>

<div class="container">

<h3>1대1문의 상세보기</h3>
<hr>

<div>
<table class="table table-bordered">
<tr>
<td style="background-color : #D8D8D8; font-color:white''" class="info">글번호</td><td>${oboardview.one_no }</td>
<td style="background-color : #D8D8D8;" class="info">글제목</td><td>${oboardview.one_title }</td>
</tr>

<!-- <tr> -->
<%-- <td class="info">아이디</td><td>${nboardView.writer }</td> --%>
<!-- <td class="info">닉네임</td><td colspan="2">[추후 추가]</td> -->
<!-- </tr> -->


<tr>
<td style="background-color : #D8D8D8;" class="info">글내용</td><td colspan="3">${oboardview.one_content }</td>

</tr>

<tr>
<td style="background-color : #D8D8D8;" class="info">작성일</td><td colspan="4">${oboardview.one_date }</td>
</tr>
</table>
</div>

<!-- <div class="text-center">	 -->
<!-- 	<button id="btnList" class="btn btn-primary">목록</button> -->
<!-- 	<button id="btnUpdate" class="btn btn-info">수정</button> -->
<!-- 	<button id="btnDelete" class="btn btn-danger">삭제</button> -->
<!-- </div> -->
</div>

<div class="container">

<h3>답변 등록</h3>
<hr>

<div>
<form action="/oneandboard/write" method="post">
<table class="table table-bordered">

<tr>


<td  style="background-color : #D8D8D8;" class="info">작성자</td>
<td>관리자</td></tr>

<!-- <tr> -->
<!-- <!-- 	<td class="info">제목</td> --> 
<!-- 		<td><input type="text" name="title" style="width:100%; "/></td> -->
<!-- </tr> -->
<tr><td style="background-color : #D8D8D8;" class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="content" name="content"></textarea></td></tr>
</table>
</form>
</div>

<div class="text-center">	
	<button type="button" id="btnWrite" class="btn btn-primary">작성</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
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





<jsp:include page="/view/layout/footer.jsp" />
















    