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
	
});
</script>
<style>
#label{
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
				      <input type="text" class="form-control" id="eId" name="eId" placeholder="${fn:split(users.u_email, '@')[0]}">
				   </div>
				   <div class="col-sm-0 control-div" style="float:left; line-height:43px;">
				   @
				   </div>
				   <div class="col-sm-3 control-div">
				      <input type="text" id="eAddress" name="eAddress" class="form-control" placeholder="${fn:split(users.u_email, '@')[1]}">
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
			   <div class="form-group">
			    <label for="phone" class="col-sm-2 control-label">전화번호</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="phone" name="phone" placeholder="${users.u_phone }">
			    </div>
			  </div>
			  <div class="form-group">
			  	 <label for="birth" class="col-sm-2 control-label">생년월일</label>
				   <div class="col-sm-2">
				      <input type="text" id="year" name="year" class="form-control" placeholder="${fn:split(users.u_birth, '-')[0]}">
				   </div>
				   <div class="col-sm-2">
				      <select class="form-control" name="month" id="month" "${fn:split(users.u_birth, '-')[1]}"> 
				      <!-- 제이쿼리로  -->
				         <option value="default">선택</option>
				         <option value="1">1</option>
				         <option value="2">2</option>
				         <option value="3">3</option>
				         <option value="4">4</option>
				         <option value="5">5</option>
				         <option value="6">6</option>
				         <option value="7">7</option>
				         <option value="8">8</option>
				         <option value="9">9</option>
				         <option value="10">10</option>
				         <option value="11">11</option>
				         <option value="12">12</option>
				      </select>
				   </div>
				   <div class="col-sm-2">
				      <input type="text" id="day" name="day" class="form-control" placeholder="태어난 일">
				   </div>
				</div>   
			  
			  
			  
			  <div class="form-group">
			    <label for="newPw" class="col-sm-2 control-label">이메일</label>
			     <div class="col-sm-5">
			    	<input type="text" class="form-control" id="newPw" name="newPw" placeholder="8자 이상, 숫자 & 영문자 모두 포함">
			    </div>
			  	<button type="button" id="changePw" class="btn btn-default col-sm-1">변경</button>
			  	<div class="col-sm-4" id="newPwCheck" style="font-size: 12px;"></div>
			  </div>  
			</form>

          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>



