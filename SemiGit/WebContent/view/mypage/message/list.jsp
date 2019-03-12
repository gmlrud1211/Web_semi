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
            <h2>나의 쪽지함</h2>
            <p style="font-size: 16px">받은 쪽지 목록입니다</p>
          </div>
          <div class="row">
	       <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>보낸사람</th>
                  <th>내용</th>
                  <th>확인여부</th>
                  <th>날짜</th>
                </tr>
              </thead>
   				<c:if test="${msgList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${msgList.size()-1 }">
	              <tbody>
	                <tr>
	                  <td>${msgList.get(i).getSender_name }</td>
	                  <td>${msgList.get(i).getM_comment }</td>
	                  <td>${msgList.get(i).getM_read }</td>
	                  <td>${msgList.get(i).getM_date }</td>
	                </tr>
	              </tbody>
   			</c:forEach>
   			</c:if>
            </table>
          </div>
	      
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
      </div><!--/row-->

    </div>


</div>
</div>
