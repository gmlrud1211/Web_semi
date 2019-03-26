<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/view/layout/header.jsp"/>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/users.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">

var idChk = false;

// 아이디 변경 시 아이디 다시 확인하도록 변수 변경
function userIdChange(){
	idChk = false;
};


// 아이디 중복확인 검사
function dupId(){
	/*
		# : tag Id
		. : tag Class
		input[name=userId]
	*/
	
	// 아이디 정규식 체크 (4자 이상 11자 이하의 영,숫자 / 첫시작은 영문자)
	var idRule = new RegExp("^[a-zA-Z][a-zA-Z0-9]{3,11}$","g");  
    var match = idRule.exec($("#userId").val()); 
    
    if(match == null || $("#userId").val().length <  4 || $("#userId").val().length > 12){
    	alert("아이디의 시작은 영문자이며, 4~11자의 영숫자로 구성되어야합니다.");
    	$("#userId").focus();
    	return;
    }
    
	var id = $("#userId").val();
	var url = "/users/duplication";
	
	// plainObject
	var data = {"u_id":id};
	
	function success(data, status) {
		idChk = data;
		if(data == "true"){
			alert("사용하실 수 있는 아이디 입니다.");
		} else {
			alert("중복된 아이디입니다. 다른 아이디를 입력해주세요.");
		}
	};
		
	$.post(url, data, success);
		
}

$(document).ready(function() {

	// 휴대폰번호 자동하이픈
	function autoHypenPhone(str){
	    str = str.replace(/[^0-9]/g, '');
	    var tmp = '';
	    if( str.length < 4){
	        return str;
	    }else if(str.length < 7){
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3);
	        return tmp;
	    }else if(str.length < 11){
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3, 3);
	        tmp += '-';
	        tmp += str.substr(6);
	        return tmp;
	    }else{              
	        tmp += str.substr(0, 3);
	        tmp += '-';
	        tmp += str.substr(3, 4);
	        tmp += '-';
	        tmp += str.substr(7);
	        return tmp;
	    }
	    return str;
	}

	var phone = document.getElementById('phone');

	phone.onkeyup = function(event){
		event = event || window.event;
		var _val = this.value.trim();
		this.value = autoHypenPhone(_val) ;
	}
	
	// 이메일 select box 선택 부분
	$("#emailSelect").change(function() {
		$("#emailSelect option:selected").each(function () {
			if($(this).val() == 'direct'){
				$("#eAddress").val('');
				$("#eAddress").attr("disabled",false);
			} else {
				$("#eAddress").val($("#emailSelect option:selected").text());
				$("#eAddress").attr("readOnly",true);
			}	  
		});	  
	});
	
	// 회원가입 버튼 클릭 시 유효성 검사 후 폼전송
	$("#btnJoin").click(function(){
		
		// 아이디 중복확인을 해야 가입되도록
		if(idChk){
			var pwRule = new RegExp("^[a-zA-Z0-9][a-zA-Z0-9]{5,11}$","g");  
		    var nameRule = new RegExp("^[\u3131-\u318E\uAC00-\uD7A3]*$");
		    var year = parseInt($("#year").val());
		    var day = parseInt($("#day").val());
		    var thisyear = new Date().getFullYear();
		    
		    var pwMatch = pwRule.exec($("#userPw").val()); 
		    var nameMatch = nameRule.exec($("#userName").val());
		    
		    
		    if(pwMatch == null || $("#userPw").val().length <  6 || $("#userPw").val().length > 12){
			    // 비밀번호 정규식 체크
		    	alert("비밀번호를 6~11자의 영숫자로 입력해주세요.");
		    	$("#userPw").focus();
		    	return;
		    } else if($("#userPw").val() != $("#userPwConfirm").val()){
		    	// 비밀번호 / 비밀번호 일치 여부 확인
		    	alert("비밀번호와 비밀번호 확인이 서로 일치하지 않습니다");
		    	$("#userPw").focus();
		    	return; 
		    } else if (nameMatch == null ||  $("#userName").val() == ""){
		    	// 이름은 한글만 입력가능
		    	alert("이름을 한글로 입력해주세요.")
		    	$("#userName").focus();
		    	return;
		    } else if ( ( $("#eId").val() == "" ) || ( $("#eAddress").val() == "" ) ){
		    	// 이메일 입력여부 확인
		    	alert("이메일주소를 입력해주세요");
		    	if( $("#eId").val() == "" ){
			    	$("#eId").focus();
		    	} else {
		    		$("#eAddress").focus();
		    	}
		    	return;
		    } else if($("#phone").val() == "") {
		    	// 휴대폰번호 빈값 체크
		    	alert("휴대폰번호를 입력해주세요");
		    	$("#phone").focus();
		    	return;
		    } else if($("#year").val() == "" || $("#month").val() == 'default' || $("#day").val() == ""){
		    	// 생년월일 빈값 체크 
		    	alert("생년월일이 입력되지 않았습니다. ");
		    	$("#year").focus();
		    	return;
		    } else if( thisyear - year < 14 ){
		    	// 14세 이상 회원가입 가능
		    	alert("14세 이상 회원가입 가능합니다");
		    	$("#year").focus(); 
		    	return;
		    } else if ( year+100 < thisyear ){
		    	// 100세 이상은 연도 재확인 
		    	alert("태어난 연도를 재확인해주세요");
		    	$("#year").focus();
		    	return;
		    } else if( day<1 || day>31){
		    	// 1~31일 아닌 다른 수 입력 시 체크
		    	alert("태어난 일자를 재확인해주세요");
		    	$("#day").focus();
		    	return;
		    } else
		    {
		    	// 유효성 검사 완료 후 폼전송!
				$("#joinForm").submit();
		    }
		    	 
		} else {
	    	alert("아이디 중복확인을 해주세요");
	    	return;
	    }
	})
	
    // Birthday 처리 구문
    var date = new Date();
    var year = date.getFullYear();
    
    for (var i = 1900; i <= year; i++) {
		if (i == year) {
			$("#birth_year").append("<option value='" + i + "' selected>" + i + "년</option>");
		}
		else {
			$("#birth_year").append("<option value='" + i + "'>" + i + "년</option>");
		}
    }
   
    for (var i = 1; i <= 12; i++) {
		$("#birth_month").append("<option value='" + i + "'>" + i + "월</option>");
	}
    var lastDay = (new Date($("#birth_year").val(), $("#birth_month").val(), 0)).getDate();
    for (var i = 1; i <= lastDay; i++) {
		$("#birth_day").append("<option value='" + i + "'>" + i + "일</option>");
    }
   
    $("#birth_month, #birth_year").change(function () {
	    var lastDay = (new Date($("#birth_year").val(), $("#birth_month").val(), 0)).getDate();
		$("#birth_day option").remove();
		for (var i = 1; i <= lastDay; i++) {
			$("#birth_day").append("<option value='" + i + "'>" + i + "일</option>");
		}
    });
    
});
</script>


<body>

<div class="container" >
<h1 align="center" style="padding: 15px;">회원가입</h1>
<form id="joinForm" action="/users/join" method="post" class="form-horizontal">
<h3 align="center">환영합니다! 모두의 모임 모모입니다.</h3>
<hr style="margin-top: 30px; margin-bottom: 50px" >

<div class="form-group" style="width:96%">
	<div class="col-sm-5 col-sm-offset-3 control-div">
		<input type="text" id="userId" name="id" class="form-control" placeholder="아이디" onchange="userIdChange();">
	</div>
	<button type="button" class="btn btn-info btn-mm" onclick="dupId();">중복확인</button>
</div>

<div class="form-group" style="width:96%">
	<div class="col-sm-6 col-sm-offset-3 control-div">
		<input type="password" id="userPw" name="pw" class="form-control" placeholder="패스워드">
	</div>
</div>
<div class="form-group" style="width:96%">
	<div class="col-sm-6 col-sm-offset-3 control-div">
		<input type="password" id="userPwConfirm" name="pwconfirm" class="form-control" placeholder="패스워드 확인">
	</div>
</div>
<div class="form-group" style="width:96%">
   <div class="col-sm-6 col-sm-offset-3 control-div">
      <input type="text" id="userName" name="uname" class="form-control" placeholder="이름">
   </div>
</div>
<br><div class="form-group" style="width:96%">
   <div class="col-sm-2 col-sm-offset-3 control-div">
      <input type="text" id="eId" name="eid" class="form-control" placeholder="e-mail">
   </div>
   <div class="col-sm-0 control-div" style="float:left; line-height:43px;">
   @
   </div>
   <div class="col-sm-2 control-div" style="width:15.2%">
      <input type="text" id="eAddress" name="eAddress" class="form-control">
   </div>
   <div class="col-sm-2 control-div">
      <select class="form-control" id="emailSelect">
         <option value="direct">직접입력</option>
         <option value="gmail">gmail.com</option>
         <option value="naver">naver.com</option>
         <option value="hanmail">hanmail.net</option>
         <option value="nate">nate.com</option>
      </select>
   </div>
</div>

<div class="form-group" style="width:96%">
   <div class="col-sm-6 col-sm-offset-3 control-div">
      <input type="text" id="phone" name="phone" class="form-control" placeholder="휴대폰번호 (숫자만입력)" maxlength=13>
   </div>
</div>

<div class="form-group" id="birth" style="margin-left:-40px">
   <div class="col-sm-2 col-sm-offset-3 control-div" style="width:190px">
      <select class="form-control" name="birth_year" id="birth_year"></select>
   </div>
   <div class="col-sm-2 control-div" style="width:180px">
      <select class="form-control" name="birth_month" id="birth_month"></select>
   </div>
   <div class="col-sm-2 control-div" style="width:180px">
      <select class="form-control" name="birth_day" id="birth_day"></select>
   </div>
</div>
   

<label class="container cate" id="cate">관심있는 카테고리를 선택해주세요!</label> 

<div class="checkbox" style="text-align:left; width: 677px">
	<c:forEach var="cate" items="${cateList}" varStatus="i">
		<label class="checkbox-inline">
			<input type="checkbox" name="cate" value="<c:out value="${cate.st_catecode}" />"><c:out value="${cate.st_catename}" />
		</label>
	</c:forEach>
</div>

<!-- VALUE로 COTE_NO -->

<div id="joinbutton" class="joinbutton">
	<button type="button" id="btnJoin" class="btn btn-primary btn-mm">회원가입하기</button>
	<button type="button" id="btnMain" class="btn btn-warning btn-mm">취소</button>
</div>
   
</form>
</div>


</body>
</html>