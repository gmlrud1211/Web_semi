<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/view/layout/header.jsp"/>
<script type="text/javascript">
$(document).ready(function() {
	
	var pwChk = false;
	var npwChk = false;
	
	// 기존 비밀번호 재입력 시 다시 확인하도록 변수 변경
	function userPwChange(){
		pwChk = false;
	};
	
	$("#pwCheck").click(function(){

		var u_pw = $("#currentPw").val();
		var url = "/mypage/profile/pwcheck";
		var data = {"u_pw" : u_pw};		
		
		function success(data, status) {
			pwChk = data;
// 			console.log(pwChk);
			
			if(data == "true"){
				$("#pwCheckRes").html("확인되었습니다. 새 비밀번호를 입력해주세요");
				
			} else {
				$("#pwCheckRes").html("<span style='color:red;'>비밀번호가 틀립니다. 다시 확인해주세요</span>");
				
			}
		};	
		
		$.post(url, data, success);	
	});
	
	$("#newPw").click(function(){	
// 		console.log(pwChk);
		
		if(pwChk=="false"){
			alert("현재 비밀번호를 먼저 확인해주세요");
		}
	});
	
	$("#newPw").blur(function(){
		
		if(pwChk=="true"){
			var pwRule = new RegExp("^[a-zA-Z0-9][a-zA-Z0-9]{5,11}$","g");  
		    var pwMatch = pwRule.exec($("#newPw").val()); 
			
		    if(pwMatch == null || $("#newPw").val().length <  6 || $("#newPw").val().length > 12){
			    // 비밀번호 정규식 체크
			    $("#newPwCheck").html("<span style='color:red'>비밀번호를 6~11자의 영숫자로 입력해주세요</span>")
		    	return;
		    } else {
		    	$("#newPwCheck").html("안전한 비밀번호입니다")
		    	npwChk = "true";
		    }
		}	
		
	});	
	
	$("#changePw").click(function(){
		if (pwChk!="true") {
			alert("기존 비밀번호를 먼저 확인해주세요")
		} else if(pwChk=="true" && npwChk != "true" ){
			alert("새 비밀번호를 확인해주세요")
			console.log(npwChk);
		} else {
			$("#pwchangeform").submit();
			alert("비밀번호가 변경되었습니다");
		}		
	});
	
	  // Birthday 처리 구문
	  var date = new Date();
	  var year = date.getFullYear();
	  for (var i = 1900; i <= year; i++) {
	    if (i == year) {
	      $("#birth-year").append("<option value='" + i + "' selected>" + i + "년</option>");
	    }
	    else {
	      $("#birth-year").append("<option value='" + i + "'>" + i + "년</option>");
	    }
	  }
	  for (var i = 1; i <= 12; i++) {
	    $("#birth-month").append("<option value='" + i + "'>" + i + "월</option>");
	  }
	  var lastDay = (new Date($("#birth-year").val(), $("#birth-month").val(), 0)).getDate();
	  for (var i = 1; i <= lastDay; i++) {
	    $("#birth-day").append("<option value='" + i + "'>" + i + "일</option>");
	  }
	  $("#birth-month, #birth-year").change(function () {
	    var lastDay = (new Date($("#birth-year").val(), $("#birth-month").val(), 0)).getDate();
	    $("#birth-day option").remove();
	    for (var i = 1; i <= lastDay; i++) {
	      $("#birth-day").append("<option value='" + i + "'>" + i + "일</option>");
	    }
	  });
	  
	  // db에서 생일 값 가져오기
	  u_byear = $("#birth-year").attr(${fn:split(users.u_birth, '-')[0]});
	  $('#birth-year option[value='+ u_byear + ']').attr('selected', 'selected');
	  
	  u_bmont = $("#birth-year").attr(${fn:split(users.u_birth, '-')[1]});
	  $('#birth-month option[value='+ u_bmont + ']').attr('selected', 'selected');
	  
	  u_bday = $("#birth-year").attr(${fn:split(users.u_birth, '-')[2]});
	  $('#birth-day option[value='+ u_bday + ']').attr('selected', 'selected');
	  
	  // 휴대폰 번호 처리
	  // 입력 시
	  $("#phone1").keyup(function () {
	    if ($(this).val().length == 3) {
	      $("#phone2").focus();
	    }
	  });
	  $("#phone2").keyup(function () {
	    if ($(this).val().length == 4) {
	      $("#phone3").focus();
	    }
	  });
	  // 지울 시
	  $("#phone2").keydown(function (e) {
	    if (e.which == 8 && $(this).val().length == 0) {
	      $("#phone1").focus();
	    }
	  });
	  $("#phone3").keydown(function (e) {
	    if (e.which == 8 && $(this).val().length == 0) {
	      $("#phone2").focus();
	    }
	  });
	
	
});
</script>
<style>
label{
text-align:center;
}

</style>
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
            <h2>개인 정보 관리</h2>
            <p style="font-size: 16px">개인정보를 확인하고 수정할 수 있습니다</p>
          </div>
          <div class="row" style="margin: 0px;padding: 10px;">
    		
    		<form class="form-horizontal" id="pwchangeform" action="/mypage/profile/pwchange" method="post">
   				<div class="form-group">
			    <label for="id" class="col-sm-2 control-label">아이디</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="id" name="id" placeholder="${users.u_id }" readOnly>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="name" class="col-sm-2 control-label">이름</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="name" name="name" placeholder="${users.u_name }" readOnly>
			    </div>
			  </div>
			  <div class="form-group">
			  	<label for="email" class="col-sm-2 control-label">이메일</label>
			  		<div class="col-sm-3">
				      <input type="text" class="form-control" id="eId" name="eId">
				   </div>
				   <div class="col-sm-0 control-div" style="float:left; line-height:43px;">
				   @
				   </div>
				   <div class="col-sm-3 control-div">
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
		
			
			  <div class="form-group" id="phone">
			  	<label for="phone1" class="col-sm-2 control-label">전화번호</label>
			        <div class="col-md-8 input-phone">
			          <div class="col-xs-3">
			            <input type="tel" class="form-control" id="phone1" name="phone1" maxlength="3" placeholder="010">
			          </div>
			          <p class="col-xs-1 form-control-label">
			            &minus;
			          </p>
			          <div class="col-xs-3">
			            <input type="tel" class="form-control" id="phone2" name="phone2" maxlength="4" placeholder="0000">
			          </div>
			          <p class="col-xs-1 form-control-label">
			            &minus;
			          </p>
			          <div class="col-xs-3">
			            <input type="tel" class="form-control" id="phone3" name="phone3" maxlength="4" placeholder="0000">
			          </div>
			        </div>
			      </div>
			  
			   <div class="form-group" id="birth">
			   		<label for="birth" class="col-sm-2 control-label">생년월일</label>
			        <div class="col-md-8">
			            <select class="c-select form-control" name="birth_year" id="birth-year" style="width:20%;float: left;margin-right: 1em;"></select>
			            <select class="c-select form-control" name="birth_month" id="birth-month" style="width:20%;float: left;margin-right: 1em;"></select>
			            <select class="c-select form-control" name="birth_day" id="birth-day" style="width:20%;"></select>
			        </div>
		    	  </div>
		    	  <br>
		    	<div class="col-sm-5"></div>  
			  	<button type="button" id="changeProfile" class="btn btn-default col-sm-2">수정하기</button>
		    	<div class="col-sm-5"></div>  
			  	 
			</form>

          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>



