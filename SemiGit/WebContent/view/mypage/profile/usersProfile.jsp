<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
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
          <div class="row" style="margin: 0px;">
    		<div class="profilebox">
    		 <label for="profileId" class="col-sm-2 control-label">아이디</label>
			    <div class="panel panel-default col-sm-10 panel-body">${users.u_id }</div>
    		</div>
    		<div class="profilebox">
    		 <label for="profileName" class="col-sm-2 control-label">이름</label>
			    <div class="panel panel-default col-sm-10 panel-body">${users.u_name }</div>
    		</div>
    		<div class="profilebox">
    		 <label for="profileEmail" class="col-sm-2 control-label">이메일</label>
			    <div class="panel panel-default col-sm-10 panel-body">${users.u_email }</div>
    		</div>
    		<div class="profilebox">
    		 <label for="profileEmail" class="col-sm-2 control-label">전화번호</label>
			    <div class="panel panel-default col-sm-10 panel-body">${users.u_phone }</div>
    		</div>
    		<div class="profilebox">
    		 <label for="profileEmail" class="col-sm-2 control-label">생년월일</label>
			    <div class="panel panel-default col-sm-10 panel-body">${users.u_birth }</div>
    		</div>
    		<div class="profilebox">
    		 <label for="profileEmail" class="col-sm-2 control-label">관심카테고리</label>
			    <div class="panel panel-default col-sm-10 panel-body">
			    <c:if test="${ucList.size()>0 }">
				    <c:forEach var="i" begin="0" end="${ucList.size()-1 }">
					    <ol class="breadcrumb">
						  <li><a href="#">${ucList.get(i).st_cate }</a></li>
						  <li class="active">${ucList.get(i).st_subcate } </li>
						</ol>
				    </c:forEach>
			    </c:if>
			    <c:if test="${ucList.size()==0 }">관심 카테고리를 설정하지 않으셨습니다</c:if>
			    </div>
    		</div>
			    	
      		<button type="button" id="updatePw" class="btn btn-default">비밀번호 변경</button>
			<button type="button" id="updateProfile" class="btn btn-default" style="float:right;">정보수정</button>

          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>

<script type="text/javascript">
$(document).ready(function() {
	$("#updatePw").click(function(){
		location.href="/mypage/profile/pwchange"		
	});
});

$(document).ready(function() {
	$("#updateProfile").click(function(){
		location.href="/mypage/profile/updateProfile"		
	});
});

</script>

