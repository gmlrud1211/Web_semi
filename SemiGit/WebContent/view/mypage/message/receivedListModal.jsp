<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--   <link rel="stylesheet" href="//resources/demos/style.css"> -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="wrapper">
<div class="container">
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
   				<c:if test="${rList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${rList.size()-1 }">
	              <tbody>
	                <tr>
	                  <td>${rList.get(i).u_name }</td>
<%-- 	                  <td><div onclick="dialog(${rList.get(i).m_no })">${rList.get(i).m_comment }</div></td> --%>
	                  <td><div class="msgClick">${rList.get(i).m_comment }</div></td>  		 
	                  <c:if test="${rList.get(i).m_read eq 'y' }"><td style="color: #355C7D;">확인</td></c:if>
	                  <c:if test="${rList.get(i).m_read eq 'n' }"><td style="color: #C06C84;">미확인</td></c:if>
	                  <td>${rList.get(i).m_date }</td>
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

<script>
$(document).ready(function(){
	
	$("#msgRead").dialog({
		title : '쪽지확인',
		autoOpen : false, // dialog가 선언되면 자동으로 열릴것인가?
        width : 400,  // dialog 넓이 지정
        height : 300, // dialog 높이 지정
        modal : true,      // dialog를 modal 창으로 띄울것인지 결정
        resizeable : false,// 사이즈 조절가능 여부
        draggable: false,  // 드래그 가능 여부
        open: function(){} // 시작할 때  실행되는 부분
        
	})
	
	$('.msgClick').on('click', msgClick);
});	


function openDialog(){
	$("#msgRead").html("너무 어렵다");
	$("#msgRead").dialog('open');
}

function msgClick(){
	openDialog();
}

</script>
<div id="msgRead"></div>
