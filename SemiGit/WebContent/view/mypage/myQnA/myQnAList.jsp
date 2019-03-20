<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".qnaTitle").click(function(){
		if($(this).parent('tr').next().hasClass("sh")){
			$(this).parent('tr').next().removeClass("sh");
		} else {
			$(this).parent('tr').next().addClass("sh");
		}
	});
});
</script>
<style type="text/css">
.qnaContent{
 	display:none; 
}
.qnaContent.sh {
	display: table-row;		
}
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
            <h2>나의 1:1 문의</h2>
            <p style="font-size: 16px">관리자에게 궁금한 점을 언제든지 질문하세요!</p>
          </div>
          <div class="row" style="margin:0;">
   
   			<table class="table table-hover">
		      <thead>
		        <tr>
		          <th width="10%">번호</th>
		          <th width="60%">제목</th>
		          <th width="15%">작성일</th>
		          <th width="15%">상태</th>
		        </tr>
		      </thead>
		      <tbody>
	              <tbody>
		        <c:if test="${qnaList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${qnaList.size()-1 }">
<%-- 	                	<tr data-no="${qnaList.get(i).one_no }"> --%> <!-- jQuery로 셀렉하기 -->
	                	<tr> 
		                  <td class="list">${qnaList.get(i).one_no }</td>
	                	  <td class="qnaTitle" style="cursor:pointer">${qnaList.get(i).one_title }</td>
	                	  <td class="list">${qnaList.get(i).one_date }</td>
		                  <c:if test="${qnaList.get(i).one_status eq 'y' }"><td class="list">답변완료</td></c:if>
		                  <c:if test="${qnaList.get(i).one_status eq 'n' }"><td class="list">대기중</td></c:if>
	                   	</tr>
	                   	<tr class="qnaContent">
	                   		<td width="10%">
	                   		</td>
	                   		<td colspan="3"> 
	                   		<div>
	                   		<p><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>&nbsp;<strong style="font-size: 0.9em;">질문하신 내용입니다: </strong></p>
							       <c:if test="${qnaList.get(i).file_storedname ne null }">
	                   					<div>
							         		<img src="/cos/upload/${qnaList.get(i).file_storedname }" width="300" height="300" /><br>
	                   						<br>
	                   					</div>
							        </c:if>
	                   			${qnaList.get(i).one_content }
	                   			
	                   		</div>
	                   		<br>
	                   		<c:if test="${qnaList.get(i).one_status eq 'y' }">
	                   		<div>
	                   		<p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>&nbsp;<strong style="font-size: 0.9em;">답변입니다: </strong></p>
	                   		${qnaList.get(i).one_anscontent }
	                   		</div>
	                   		<br>
	                   		</c:if>
	                   		</td>
	                   	</tr> 
   			</c:forEach>
   			</c:if>
              </tbody>
		      </tbody>
		    </table>
   
          <button onclick="location.href='/mypage/myqna/ask'" class="btn btn-default" style="float: right;">1:1 문의하기</button>
          
          <c:if test="${qnaList.size()>0 }">
          <jsp:include page="./pagingMyQnA.jsp"/>
          </c:if>
          
          </div><!--/row-->
          
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>
