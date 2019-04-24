<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
<script type="text/javascript">

</script>
<div class="wrapper">
<div class="container">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="name"><h2>MY PAGE</h2></div>
	          <div class="list-group" style="box-shadow: none;">
	            <a href="/mypage/mystudy/mystudyroom" class="list-group-item" style="border:none;">나의 스터디룸</a>
	            <a href="/mypage/mystudy/imade" class="list-group-item" style="border:none;">진행예정 스터디</a>
	            <a href="/mypage/bookmark" class="list-group-item" style="border:none;">관심 스터디</a>
	            <a href="#" class="list-group-item" style="border:none;">나의 쪽지함</a>
	            <a href="#" class="list-group-item" style="border:none;">내가 쓴 게시글</a>
	            <a href="#" class="list-group-item" style="border:none;">나의 1:1 문의</a>
	            <a href="#" class="list-group-item" style="border:none;">개인 정보 관리</a>

          </div>
        </div><!--/.sidebar-offcanvas-->

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280;
          border-radius: 0;" >
            <h2></h2>
            <p style="font-size: 16px"></p>
          </div>
          <div class="row">
   			<c:if test="">
	            <div class="col-xs-6 col-lg-4">
	             <%--  <input type="button" value="X" onclick="bookmark_insert(${bmList.get(i).bm_no });" style="background: transparent;float: right;-webkit-appearance: button-bevel;">  --%>
	             <%--  <div><a href="#"><img src="/upload/${bmList.get(i).file_storedname }" alt="study images"></a></div>
	              <h4><a href="#" style="color: inherit;">${bmList.get(i).study_name }</a></h4> --%>
             
	            </div><!--/.col-xs-6.col-lg-4-->	
   			</c:if>
   			<jsp:include page="/view/layout/paging.jsp"/>
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>
</div>
