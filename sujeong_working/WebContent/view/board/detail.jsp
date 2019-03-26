<%@page import="dto.BoardComment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="../layout/header.jsp" />

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"> </script>

<script type="text/javascript">

$(document).ready(function() {
	
	// ****************************************************************************
	// 초기 로딩시 세션의 u_no가져와서 버튼 초기세팅 작업 필요함 :: 테스트를 위해 u_no = 100으로 고정
	// ****************************************************************************
	
	var isRcmd = ${Recommend };
	
	if(isRcmd == true){
		$("#btnRecmdAf").show();
		$("#btnRecmdBf").hide();
	} else {
		$("#btnRecmdBf").show();
		$("#btnRecmdAf").hide();
	}
	
	// 추천버튼 클릭 시  (+1)
	$("#btnRecmdBf").click(function() {
		
		var b_no = ${boardView.b_no};
		var u_no = ${boardView.u_no};
		var type = "recommend";
		
		$.ajax({
			type: "post"
			, url: "/board/recommend"
			, data: {
				"b_no":b_no, 
				"u_no":u_no,
				"type":type
				}
			, dataType: "text"
			, success: function(data){
				$("#btnRecmdAf").show();
				$("#btnRecmdBf").hide();
		        $("#cntText").html(data);

			}
			, error: function(e) {
				alert("추천에 실패했습니다. 다시 시도해주세요");
				console.log(e);
			}
		});
	});
	
	// 추천 취소 시 (-1)
	$("#btnRecmdAf").click(function() {
		var b_no = ${boardView.b_no};
		var u_no = ${boardView.u_no};
		var type = "cancel";
		
		$.ajax({
			type: "post"
			, url: "/board/recommend"
			, data: {
				"b_no":b_no, 
				"u_no":u_no,
				"type":type
				}
			, dataType: "text"
			, success: function(data){
				$("#btnRecmdBf").show();
				$("#btnRecmdAf").hide();
		        $("#cntText").html(data);
			}
			, error: function(e) {
				alert("추천취소에 실패했습니다. 다시 시도해주세요");
				console.log(e);
			}
		});
	});
	
	var writer_no = ${write_no }
	var reader_no = <%=session.getAttribute("u_no")%>
	
	if(reader_no == writer_no) {
		$("#btnUpdate").show();
		$("#btnDelete").show();
		$("#btnReport").hide();
	} else {
		$("#btnUpdate").hide();
		$("#btnDelete").hide();
		$("#btnReport").show();
	}

	 $("#btnDelete").click(function() {
		var delConfirm = confirm('정말로 삭제하시겠습니까?');	
		if (delConfirm) {	
			location.href = "/board/delete?b_no=${boardView.b_no }";
		} else {
			return;
		}
	});

	$("#btnReport").click(function() {
		var reportConfirm = confirm('해당 게시글을 신고 하시겠습니까?\r신고하신 글은 관리자가 부적합하다고 판단 시 삭제됩니다.');	
		if (reportConfirm) {
			location.href = "/board/report?b_no=${boardView.b_no }";
		} else {
			return;
		}
	});
	
	// 댓글갯수 카운트
	$(".count").append( $(".replyrow").length );

	// 댓글 등록
	$("#commentsubmit").click(function() {
		//u_no 세션값으로 수정필요함! u_no=100으로 테스트 중
		if($("#content").val() == ""){
			alert("댓글내용을 입력해주세요");
			return;
		} else {
			$("form").submit();
		}
	});
		
	//댓글 수정
	$(document).on("click","button[id='replyupdate']",function(){
		
		$(this).val('닫기');
		
		var reply = ''
				+ '<form action="/board/commentupdate" method="post" id="updateForm">'
				+ '<input type="hidden" name="u_no" value=100 />'
				+ '<input type="hidden" id="parent_reply" name="parent_reply" />'
				+ '<input type="hidden" name="b_no" value=${boardView.b_no} />'
// 				+ '<table class="container">'
// 				+ '	<tr style="text-align:center;">'
// 				+ '		<td colspan="4">'
				+ '<div style="margin-top: 25px;">'
				+ '<textarea id="updatcontent" class="updatcontent" name="content" style="width:700px"></textarea>'
// 				+ '</td>'
// 				+ '		<td colspan="3">'
				+ '		<button type="button" id="r_commentupdate" class="btn btn-primary btn-sm" style="margin-left: 20px; margin-bottom: 38px;">'
				+ '		댓글수정</button>'
				+ '</div>'
// 				+'</td>'
// 				+ '	</tr>'
// 				+ '</table>'
				+ '</form>';
				
		var $commentUpdatetr = $(this).parent().parent().next().children();
		if($commentUpdatetr.hasClass("noreply")) {
			$commentUpdatetr.removeClass("noreply")
			$commentUpdatetr.append(reply);
		} else {
			$commentUpdatetr.addClass("noreply")
			$commentUpdatetr.html("")
		}

		// bc_no ()셋팅
		var parent =  $(this).parent().parent().attr("name");
		//$(this).next().val(parent);
		$("input[name=parent_reply]").val(parent);

	});
	

	//대댓글 수정
	$(document).on("click","button[id='replyupdate_2']",function(){
		
		$(this).val('닫기');
		
		var reply = ''
				+ '<form action="/board/commentupdate" method="post" id="updateForm">'
				+ '<input type="hidden" name="u_no" value=100 />'
				+ '<input type="hidden" id="parent_reply" name="parent_reply" />'
				+ '<input type="hidden" name="b_no" value=${boardView.b_no} />'
// 				+ '<table class="container">'
// 				+ '	<tr style="text-align:center;">'
// 				+ '		<td colspan="4">'
				+ '<div style="margin-top: 25px;">'
				+ '<textarea id="updatcontent" class="updatcontent" name="content" style="width:700px"></textarea>'
// 				+ '</td>'
// 				+ '		<td colspan="3">'
				+ '		<button type="button" id="r_commentupdate" class="btn btn-primary btn-sm" style="margin-left: 20px; margin-bottom: 38px;">'
				+ '		댓글수정</button>'
				+ '</div>'
// 				+'</td>'
// 				+ '	</tr>'
// 				+ '</table>'
				+ '</form>';
				
		var $commentUpdatetr = $(this).parent().parent().next().children();
		if($commentUpdatetr.hasClass("noreply")) {
			$commentUpdatetr.removeClass("noreply")
			$commentUpdatetr.append(reply);
		} else {
			$commentUpdatetr.addClass("noreply")
			$commentUpdatetr.html("")
		}

		// bc_no ()셋팅
		var parent =  $(this).parent().parent().attr("name");
		//$(this).next().val(parent);
		$("input[name=parent_reply]").val(parent);

	});
	
	//대댓글 등록
	$(document).on("click","button[id='replysubmit']",function(){
		
		$(this).val('닫기');
		
		var reply = ''
				+ '<form action="/board/comment" method="post" id="replyForm">'
				+ '<input type="hidden" name="u_no" value=100 />'
				+ '<input type="hidden" id="parent_reply" name="parent_reply" />'
				+ '<input type="hidden" name="b_no" value=${boardView.b_no} />'
// 				+ '<table class="container">'
// 				+ '	<tr style="text-align:center;">'
// 				+ '		<td colspan="4">'
				+ '<div style="margin-top: 25px;">'
				+ '<textarea id="replycontent" class="replycontent" name="content" style="width:700px"></textarea>'
// 				+ '</td>'
// 				+ '		<td colspan="3">'
				+ '		<button type="button" id="r_commentsubmit" class="btn btn-primary btn-sm" style="margin-left: 20px; margin-bottom: 38px;">'
				+ '		답글등록</button>'
				+ '</div>'
// 				+'</td>'
// 				+ '	</tr>'
// 				+ '</table>'
				+ '</form>';
				
		var $replytr = $(this).parent().parent().next().children();
		if($replytr.hasClass("noreply")) {
			$replytr.removeClass("noreply")
			$replytr.append(reply);
		} else {
			$replytr.addClass("noreply")
			$replytr.html("")
		}

		// bc_no ()셋팅
		var parent =  $(this).parent().parent().attr("name");
		//$(this).next().val(parent);
		$("input[name=parent_reply]").val(parent);

	});
	

	$(document).on("click","#r_commentupdate", function(){
		if($("#replycontent").val() == ""){
			alert("댓글내용을 입력해주세요");
			return;
		} else {
			$("#updateForm").submit();
		}
	});
	
	$(document).on("click","#r_commentsubmit", function(){
		if($("#replycontent").val() == ""){
			alert("댓글내용을 입력해주세요");
			return;
		} else {
			$("#replyForm").submit();
		}
	});
	
	$(document).on("click","#replydelete", function() {
		var delConfirm = confirm('정말로 삭제하시겠습니까?');	
		if (delConfirm) {	
			var comment_no = $(this).parent().parent().attr("name");
			location.href = "/board/commentDelete?cmt_no="+comment_no+"&b_no=${boardView.b_no}";
		} else {
			return;
		}
	});
});

</script>
<style>
td.noreply {
	padding: 0 !important;
}
</style>
<div class="container">

<h3>게시글 상세보기</h3>
<hr>

<div>
<table class="table table-bordered">
<tr>

<td class="info">글번호</td><td>${boardView.b_no }</td>
<td class="info">작성일</td><td colspan="2">${boardView.b_date }</td>
</tr>

<tr>
<td class="info">말머리</td><td>[${boardView.b_head }]</td>
<td class="info">작성자</td><td colspan="2">${boardView.u_name }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${boardView.b_count }</td>
<td class="info">추천수</td><td id="recommendCnt"><span id="cntText">${boardView.b_upcount }&nbsp;&nbsp;</span>
	<button type="button" id="btnRecmdAf" class="btn btn-warning btn-sm">추천취소</button>
	<button type="button" id="btnRecmdBf" class="btn btn-warning-outline btn-sm">추천하기</button>
</td>
 
<tr>
<td class="info">제목</td><td colspan="4">${boardView.b_title }</td>
</tr>
<tr><td class="info">본문</td><td colspan="4">${boardView.b_content }</td></tr>

<tr>
<td class="info">첨부파일</td>
<td colspan="4"><a href="/board/download?file_no=${boardView.file_no}">&nbsp;${fileName }</a></td>
</tr>

</table>
</div>

<div class="text-center">	
	<!-- 모두노출 -->
	<a href="/board/list"><button id="btnList" class="btn btn-primary">목록</button></a>
	
	<!-- 본인 작성글 에만 노출 -->
	<a href="/board/update?b_no=${boardView.b_no }"><button id="btnUpdate" class="btn btn-info">수정</button></a>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	
	<!-- 타인 작성글에만 노출 -->
	<button id="btnReport" class="btn btn-danger">게시글 신고</button>
</div>
<br><br><br>
<div class="container">
<h4 class="count">총 댓글 수 </h4>
<table class="table table-striped">
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="10%">
			<col width="5%">
			<col width="5%">
			<col width="5%">
		</colgroup>
		<tbody>
		<%
			List<BoardComment> list = (List) request.getAttribute("commentList");
		%>
		<%
			for (int i = 0; i < list.size(); i++) { if(list.get(i).getBc_reno() < 1 ) { 
		%>
			<tr class="replyrow" name=<%=list.get(i).getBc_no() %> >
				<td id="replyElements"><h6><%=list.get(i).getU_name() %> </h6></td>
				<td id="replyElements"><h6><%=list.get(i).getBc_comment() %></h6></td>
				<td id="replyElements"><h6><%=list.get(i).getBc_date() %></h6></td>
				<td><button type="button" id="replysubmit" name="replysubmit" class="btn btn-warning-outline btn-sm">답글달기</button></td>
				<td><button type="button" id="replyupdate" class="btn btn-warning-outline btn-sm">수정 </button></td>
				<td><button type="button" id="replydelete" class="btn btn-warning-outline btn-sm">삭제</button></td>
			</tr>
			<tr style="text-align: center;"><td colspan="6" class="noreply"></td></tr>
		<%
			} //  Bc_reno 가 i의 bc_no 인 댓글 찾기
			for(int j = 0; j < list.size(); j++) { if (list.get(i).getBc_no() == list.get(j).getBc_reno()) {
		%>
			<tr class="replyrow" name=<%=list.get(j).getBc_no() %> >
				<td><h6><%=list.get(j).getU_name() %> </h6></td>
				<td><h6> ㄴ <%=list.get(j).getBc_comment() %></h6></td>
				<td><h6><%=list.get(j).getBc_date() %></h6></td>
				<td><h6> </h6></td>
				<td><button type="button" id="replyupdate_2" class="btn btn-warning-outline btn-sm">수정</button></td>
				<td><button type="button" id="replydelete" class="btn btn-warning-outline btn-sm">삭제</button></td>
			</tr><tr style="text-align: center;"><td colspan="6" class="noreply"></td></tr>
			
		<%
			} } }
		%>
		</tbody>
	</table>
	
	
	<form action="/board/comment" method="post">
	<input type="hidden" name="u_no" value=100 />
	<input type="hidden" name="b_no" value=${boardView.b_no} />
	<table class="container">
		<tr style="text-align:center;">
			<td colspan="3"><textarea id="content" class="content" name="content" style="width:800px"></textarea></td>
			<td colspan="4">
			<button type="button" id="commentsubmit" class="btn btn-warning btn-mm" style="margin-right: 50px;">
			댓글등록</button></td>
		</tr>
	</table>
	</form>
</div>


</div>


<jsp:include page="../layout/footer.jsp" />

