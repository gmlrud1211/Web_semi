<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
			    <label for="currentPw" class="col-sm-2 control-label">현재 비밀번호</label>
			    <div class="col-sm-5">
			    	<input type="password" class="form-control" id="currentPw" name="currentPw" placeholder="현재 비밀번호를 입력해주세요">
			    </div>
			    <button type="button" id="pwCheck" class="btn btn-default col-sm-1">확인</button>
			    <div class="col-sm-4" id="pwCheckRes" style="font-size: 12px;"></div>
			  </div>
			  <div class="form-group">
			    <label for="newPw" class="col-sm-2 control-label">새 비밀번호</label>
			     <div class="col-sm-5">
			    	<input type="password" class="form-control" id="newPw" name="newPw" placeholder="8자 이상, 숫자 & 영문자 모두 포함">
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



