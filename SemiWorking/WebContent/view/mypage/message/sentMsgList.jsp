<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>

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
            <h2>나의 쪽지함</h2>
            <p style="font-size: 16px">보내고 받은 쪽지를 확인할 수 있습니다</p>
          </div>
          
          <ul class="nav nav-tabs" role="tablist" style="margin-bottom: 30px;">
	        <li role="presentation"><a href="/mypage/message/received" style="color: #555;">받은쪽지함</a></li>
	        <li role="presentation" class="active"><a href="/mypage/message/sent" style="color: #F67280;">보낸쪽지함</a></li>
	      </ul>
         
          <div class="row" style="margin: 0px;">
	       <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>받는사람</th>
                  <th>내용</th>
                  <th>확인여부</th>
                  <th>보낸날짜</th>
                </tr>
              </thead>
   				<c:if test="${sList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${sList.size()-1 }">
	              <tbody>
	                <tr>
	                  <td>${sList.get(i).u_name }</td>
	                  <td>${sList.get(i).m_comment }</td>
	                  <c:if test="${sList.get(i).m_read eq 'y'}"><td style="color: #355C7D;">확인</td></c:if>
	                  <c:if test="${sList.get(i).m_read eq 'n'}"><td style="color: #C06C84;">미확인</td></c:if>
	                  <td>${sList.get(i).m_date }</td>
	                </tr>
	              </tbody>
   			</c:forEach>
   			</c:if>
            </table>
          </div>
	      
          </div><!--/row-->
          
          <c:if test="${sList.size()>0 }">
          <jsp:include page="/view/layout/paging.jsp"/>
          </c:if>
          
        </div><!--/.col-xs-12.col-sm-9-->
      </div><!--/row-->

    </div>


</div>
