<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/view/layout/header.jsp"/>
<script type="text/javascript">
$(document).ready(function() {
		
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
	    for (var i = 01; i <= lastDay; i++) {
	      $("#birth-day").append("<option value='" + i + "'>" + i + "일</option>");
	    }
	  });
	  
	  // db에서 생일 값 가져오기
	  var u_byear = "${fn:split(users.u_birth, '-')[0]}";
	  
	  var us_bmonth = "${fn:split(users.u_birth, '-')[1]}";
	  	  
	  var u_bmonth;
	  if(us_bmonth<10){ // 10보다 작을 때 앞에 0 떼어주기
			u_bmonth = us_bmonth.substring(1);	  
	 } else {
			u_bmonth = us_bmonth;
	  }
// 	  console.log(u_bmonth);
	  
	  var us_bday = "${fn:split(users.u_birth, '-')[2]}";
	  var u_bday;
	  if(us_bday<10){ // 10보다 작을 때 앞에 0 떼어주기
		  u_bday = us_bday.substring(1);	  
	 } else {
		 u_bday = us_bday;
	  }
	  
	
	  $("#birth-year").attr(u_byear);
	  $('#birth-year option[value='+ u_byear + ']').prop('selected', 'selected');
	  
	  $("#birth-month").attr(u_bmonth);
	  $('#birth-month option[value='+ u_bmonth + ']').prop('selected', 'selected');
	  
	  $("#birth-day").attr(u_bday);
	  $('#birth-day option[value='+ u_bday + ']').prop('selected', 'selected');
	  
	  // db에서 선호 카테고리 값 가져오기
		var ufc = '${ufc}';
		if( ufc != null ) {
			var u = ufc.split(",");
			for(var i=0; i<u.length; i++) {
// 				console.log(u[i]);
				$("input[type='checkbox'][name='cate'][value='"+u[i]+"']").prop("checked",true);
			}
		}
	  
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
	
	  $("#changeProfile").click(function(){
		  
		  if ( ( $("#eId").val() == "" ) || ( $("#eAddress").val() == "" ) ){
		    	// 이메일 입력여부 확인
		    	alert("이메일주소를 입력해주세요");
		    	if( $("#eId").val() == "" ){
			    	$("#eId").focus();
		    	} else {
		    		$("#eAddress").focus();
		    	}
		    	return;
		  } else if($("#birth-year").val() == "" || $("#birth-month").val() == "" || $("#birth-day").val() == ""){
		    	// 생년월일 빈값 체크 
		    	alert("생년월일을 입력해주세요");
		    	$("#birth-year").focus();
		    	return;
		  } else if($("#phone1").val() == "" ||$("#phone2").val() == ""||$("#phone3").val() == "" ) {
		    	// 휴대폰번호 빈값 체크
		    	alert("휴대폰번호를 입력해주세요");
		    	$("#phone1").focus();
		    	return;
		  } else {
			alert("정보가 수정되었습니다");
			$("#profileform").submit();
		  }

	  });
	  
	// 이메일 select box 선택 부분
	$("#emailSelect").change(function() {
		$("#emailSelect option:selected").each(function () {
			if($(this).val()== 'direct'){
				$("#eAddress").val('');
				$("#eAddress").attr("disabled",false);
			} else {
				$("#eAddress").val($(this).text());
// 				$("#eAddress").attr("disabled",true);
			}	  
		});	  
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
    		
    		<form class="form-horizontal" id="profileform" action="/mypage/profile/updateProfile" method="post">
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
		
			
			  <div class="form-group" id="phone">
			  	<label for="phone1" class="col-sm-2 control-label">전화번호</label>
<!-- 			        <div class="col-md-6 input-phone"> -->
			          <div class="col-md-2">
			            <input type="tel" class="form-control" id="phone1" name="phone1" maxlength="3" placeholder="${fn:split(users.u_phone, '-')[0]}">
			          </div>
			          <p class="col-xs-1 form-control-label" style="width: 3%;">
			            &minus;
			          </p>
			          <div class="col-md-2">
			            <input type="tel" class="form-control" id="phone2" name="phone2" maxlength="4" placeholder="${fn:split(users.u_phone, '-')[1]}">
			          </div>
			          <p class="col-xs-1 form-control-label" style="width: 3%;">
			            &minus;
			          </p>
			          <div class="col-md-2">
			            <input type="tel" class="form-control" id="phone3" name="phone3" maxlength="4" placeholder="${fn:split(users.u_phone, '-')[2]}">
			          </div>
<!-- 			        </div> -->
			      </div>
			  
			   <div class="form-group" id="birth">
			   		<label for="birth" class="col-sm-2 control-label">생년월일</label>
			        <div class="col-md-10">
			            <select class="form-control" name="birth_year" id="birth-year" style="width:20%;float: left;margin-right: 1em;"></select>
			            <select class="form-control" name="birth_month" id="birth-month" style="width:20%;float: left;margin-right: 1em;"></select>
			            <select class="form-control" name="birth_day" id="birth-day" style="width:20%;"></select>
			        </div>
		    	  </div>
		    	  
		     <div class="form-group" id="cate">
		     	<label for="cate" class="col-sm-2 control-label">관심 카테고리</label>
					<div class="checkbox col-md-10">						
						<c:forEach var="cate" items="${cateList}" varStatus="i">
							<div class="col-md-2" style="font-size: 13px;">
								<input type="checkbox" name="cate" value="<c:out value="${cate.st_catecode}" />"><c:out value="${cate.st_catename}" />
							</div>
						</c:forEach>
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



