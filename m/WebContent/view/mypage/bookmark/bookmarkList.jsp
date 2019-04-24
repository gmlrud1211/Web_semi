<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/view/layout/header.jsp"/>
<script type="text/javascript">
	function bookmark_delete(bm_no){
	var res = confirm("북마크를 삭제하시겠습니까?");
	if(res){
	location.href="/mypage/bookmark/delete?bm_no="+bm_no;
		}
	}
</script>

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
            <h2>관심 스터디</h2>
            <p style="font-size: 16px">찜한 스터디 목록입니다</p>
          </div>
          <div class="row">
   			<c:if test="${bmList.size()>0 }">
   			<c:forEach var="i" begin="0" end="${bmList.size()-1 }">
	            <div class="col-xs-6 col-lg-4">
	              <input type="button" value="X" onclick="bookmark_delete(${bmList.get(i).bm_no });" style="background: transparent;float: right;-webkit-appearance: button-bevel;"> 
	              <div><a href="/study/detail?study_no=${bmList.get(i).study_no }"><img src="/cos/upload/${bmList.get(i).file_storedname }" style="width:250px; height:200px" alt="study images"></a></div>
	              <h4><a href="/study/detail?study_no=${bmList.get(i).study_no }" style="color: inherit;">${bmList.get(i).study_name }</a></h4>
             
	            </div><!--/.col-xs-6.col-lg-4-->	
   			</c:forEach>
   			</c:if>
   			
   			<c:if test="${bmList.size() eq 0 }">
						<div>
							<img src="/img/search.png" width="100" height="100"
								style="margin-left: 45%; margin-top: 20px; margin-bottom: 30px;" /><br>
							<div style="text-align: center;">
								<h4>찜한 스터디가 없습니다</h4>
							</div>
							<div style="text-align: center;">
								<h4>스터디를 확인하고 관심있는 스터디를 찜하세요!</h4>
							</div>
						</div>
					</c:if>
   			
   			
<%--    			<c:if test="${bmList.size()>0 }"> --%>
<%--           <jsp:include page="./pagingBookmark.jsp"/> --%>
<%--           </c:if> --%>
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>

