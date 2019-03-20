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
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>받는사람</th>
                  <th>내용</th>
                  <th>상대방 확인</th>
                  <th>보낸날짜</th>
                </tr>
              </thead>
   				<c:if test="${msgList.size()>0 }">
   				<c:forEach var="i" begin="0" end="${msgList.size()-1 }">
	              <tbody>
	                <tr>
	                  <td>${msgList.get(i).receiver_name }</td>
	                  <td><div onclick="popup(${msgList.get(i).m_no });" style="cursor:pointer">${msgList.get(i).m_comment }</div></td>	                  
	                  <c:if test="${msgList.get(i).m_read eq 'y'}"><td style="color: #355C7D;">확인</td></c:if>
	                  <c:if test="${msgList.get(i).m_read eq 'n'}"><td style="color: #C06C84;">미확인</td></c:if>
	                  <td>${msgList.get(i).m_date }</td>
	                </tr>
	              </tbody>
   			</c:forEach>
   			</c:if>
            </table>
	      
          <c:if test="${msgList.size()>0 }">
          <jsp:include page="./pagingSentMsg.jsp"/>
          </c:if>
          </div><!--/row-->
          
          
        </div><!--/.col-xs-12.col-sm-9-->
      </div><!--/row-->

    </div>


</div>

<script>

function popup(m_no){
// 	window.open("/message/read?m_no="+m_no);
	window.open("/mypage/message/read?m_no="+m_no, "window팝업", "width=400, height=350, menubar=no, status=no, toolbar=no");
};

</script>
