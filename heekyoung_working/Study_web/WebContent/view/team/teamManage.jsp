<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Users" %>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>


<script type="text/javascript">
	$(document).ready(function() {
					
		//팀원관리(팀원 방출) 페이지
		$("#btnTeamPeople").click(function() {
			location.href ="#";
		});
				
		//새 목표 등록 이벤트
		$("#btnEnroll").click(function() {
			location.href ="/team/achive/write";
		});
		
		//스터디룸 정보 수정 이벤트
		$("#btnUpdate").click(function() {
			location.href ="/team/info/update";
		});
	});
</script>




<div class="wrapper">
<div class="container">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="name"><h2>Team Page</h2></div>
	          <div class="list-group" style="box-shadow: none;">
	            <a href="#" class="list-group-item" style="border:none;">스터디룸 메인</a>
	            <a href="#" class="list-group-item" style="border:none;">일정 관리</a>
	            <a href="/team/board" class="list-group-item" style="border:none;">팀별 게시판</a>
	            <a href="/team/manage" class="list-group-item" style="border:none;">스터디룸 관리</a>

          </div>
        </div><!--/.sidebar-offcanvas-->

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280;
          border-radius: 0;" >
            <h2>스터디룸 관리 페이지</h2>
            <p style="font-size: 16px">스터디룸 회원관리페이지 입니다.</p>
          </div>
          <div class="row">
   	
   				<div class="container">
		
					<table class="table table-hover table-striped table-condensed">
						<thead>
							<tr>
								<th style="width: 10%">팀원번호</th>
								<th style="width: 20%">팀원ID</th>
								<th style="width: 25%">팀원이름</th>
								<th style="width: 50%">방출여부</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${Users }" var="userlist">
								<tr>
								 	<td>${userlist.u_no }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</div>
   				
   			
   				<div id="btnBox" class="btn pull-right">
					<button id="btnTeamPeople" class="btn btn-sm" style="color:#ffffff; background:#F67280">팀원관리</button>
				</div>
					
				<div id="btnBox" class="btn pull-right">
					<button id="btnEnroll" class="btn btn-sm" style="color:#ffffff; background:#F67280">새로운 목표 등록</button>
				</div>
				<div id="btnBox" class="btn pull-right">
					<button id="btnUpdate" class="btn btn-sm" style="color:#ffffff; background:#F67280">스터디 정보 수정</button>
				</div>
							
   
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>
</div>
