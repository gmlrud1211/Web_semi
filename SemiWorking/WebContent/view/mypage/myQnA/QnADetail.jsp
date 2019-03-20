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
            <h2>나의 1:1 문의</h2>
            <p style="font-size: 16px">관리자에게 궁금한 점을 언제든지 질문하세요!</p>
          </div>
          <div class="row">
   
   			<table class="table table-hover">
		      <thead>
		        <tr>
		          <th>번호</th>
		          <th>제목</th>
		          <th>작성일</th>
		          <th>상태</th>
		        </tr>
		      </thead>
		      <tbody>
	              <tbody>
		        <c:if test="${qnaList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${qnaList.size()-1 }">
<%-- 	                	<tr data-no="${qnaList.get(i).one_no }"> --%> <!-- jQuery로 셀렉하기 -->
	                	<tr onclick="detail(${qnaList.get(i).one_no });">
		                  <td>${qnaList.get(i).one_title }</td>
		                  <td>${qnaList.get(i).one_date }</td>
		                  <td>${qnaList.get(i).one_status }</td>
	                   	</tr>
   			</c:forEach>
   			</c:if>
              </tbody>
		      </tbody>
		    </table>
   
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>