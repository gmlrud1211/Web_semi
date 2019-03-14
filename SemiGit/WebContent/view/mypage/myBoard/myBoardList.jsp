<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
<div class="wrapper">
<div class="container">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="name"><h2>MY PAGE</h2></div>
	          <div class="list-group" style="box-shadow: none;">
	            <a href="#" class="list-group-item" style="border:none;">나의 스터디룸</a>
	            <a href="#" class="list-group-item" style="border:none;">진행예정 스터디</a>
	            <a href="#" class="list-group-item" style="border:none;">관심 스터디</a>
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
            <h2>내가 쓴 게시물</h2>
            <p style="font-size: 16px">작성한 게시글을 확인할 수 있습니다</p>
          </div>
          <div class="row">
   
   			<table class="table table-hover">
		      <thead>
		        <tr>
		          <th>번호</th>
		          <th>말머리</th>
		          <th>제목</th>
		          <th>추천수</th>
		          <th>조회수</th>
		          <th>작성일</th>
		        </tr>
		      </thead>
		      <tbody>
		        <c:if test="${mbList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${mbList.size()-1 }">
	              <tbody>
	                <tr>
	                <a href="/board?b_no=${mbList.get(i).b_no }">
	                  <td></td>
	                  <td>${mbList.get(i).b_head }</td>
	                  <td>${mbList.get(i).b_title }</td>
	                  <td>${mbList.get(i).b_upcount }</td>
	                  <td>${mbList.get(i).b_count }</td>
	                  <td>${mbList.get(i).b_date }</td>
	                  </a>
	                </tr>
	              </tbody>
   			</c:forEach>
   			</c:if>
		      </tbody>
		    </table>
   
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>
</div>
