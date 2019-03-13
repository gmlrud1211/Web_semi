<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
  <head>
  <meta charset="utf-8">
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script> -->

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Dialog - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<script>
$(document).ready(function(){
	
$( function() {
  $( "#dialog" ).dialog();
} );
});
</script>
</head>
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
            <p style="font-size: 16px">보내고 받은 쪽지를 확인할 수 있습니다</p>
          </div>
          
          <ul class="nav nav-tabs" role="tablist" style="margin-bottom: 30px;">
	        <li role="presentation" class="active"><a href="/message/received" style="color: #F67280;">받은쪽지함</a></li>
	        <li role="presentation"><a href="/message/sent" style="color: #555;">보낸쪽지함</a></li>
	      </ul>
          
          <div class="row" style="margin: 0px;">
	       <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>보낸사람</th>
                  <th>내용</th>
                  <th>확인여부</th>
                  <th>받은날짜</th>
                </tr>
              </thead>
   				<c:if test="${msgList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${msgList.size()-1 }">
	              <tbody>
	                <tr>
	                  <td>${msgList.get(i).u_name }</td>
<%-- 	                  <td><div onclick="dialog(${msgList.get(i).m_no })">${msgList.get(i).m_comment }</div></td> --%>
	                  <td><div id="dialog">${msgList.get(i).m_comment }</div></td>
	                  <c:if test="${msgList.get(i).m_read eq 'y' }"><td style="color: #355C7D;">확인</td></c:if>
	                  <c:if test="${msgList.get(i).m_read eq 'n' }"><td style="color: #C06C84;">미확인</td></c:if>
	                  <td>${msgList.get(i).m_date }</td>
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
