<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
<script>
function detail(one_no) {
	location.href="/board/list?b_no="+b_no;
}
</script>
<style type="text/css">
th, .list {
	text-align: center;
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
            <h2>내가 쓴 게시글</h2>
            <p style="font-size: 16px">작성한 게시글을 확인할 수 있습니다</p>
          </div>
          <div class="row" style="margin: 0px;">
   
   			<table class="table table-hover">
		      <thead>
		        <tr>
		          <th width="10%">글번호</th>
		          <th width="15%">말머리</th>
		          <th width="40%">제목</th>
		          <th width="10%">추천수</th>
		          <th width="10%">조회수</th>
		          <th width="15%">작성일</th>
		        </tr>
		      </thead>
		      <tbody>
		        <c:if test="${mbList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${mbList.size()-1 }">
	              <tbody>
	               <tr onclick="detail(${mbList.get(i).b_no });" style="cursor:pointer">
	                  <td class="list">${mbList.get(i).b_no }</td>
	                  <td class="list">${mbList.get(i).b_head }</td>
	                  <td>${mbList.get(i).b_title }</td>
	                  <td class="list">${mbList.get(i).b_upcount }</td>
	                  <td class="list">${mbList.get(i).b_count }</td>
	                  <td class="list">${mbList.get(i).b_date }</td>
	                </tr>
	              </tbody>
   			</c:forEach>
   			</c:if>
		      </tbody>
		    </table>
   
          </div><!--/row-->
          <c:if test="${mbList.size()>0 }">
          <jsp:include page="./pagingMyBoard.jsp"/>
          </c:if>
          
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>

</div>
