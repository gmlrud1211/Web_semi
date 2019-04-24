<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/view/layout/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리 - 공지사항</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>



<style>
<!--
	body {font-size:11pt; padding:0; margin:0; text-align: center;}
	h3 {color: #85144b; font-size: 14pt; margin:10 auto; padding: 10px;}
	.contents {width: 100%; height: 10%; background-color: #d6d6d6; margin: 0 auto;}
	
	/* banner */
	.banner {position: relative; width: 100%;  top: 0px;  margin:0 auto; padding:0; overflow: hidden;}
	.banner ul {position: absolute; margin: 0px; height: 50% padding:0; list-style: none; }
	.banner ul li {float: left; width:100%; margin:0; padding:0;}
	.banner ul li img{width: 100%;}

-->
</style>
</head>
<body>

  <div class="contents">
		 
		<div class="banner">
			<ul>
			<c:forEach items="${bannerslist }" var="bannerslist">
			
				<li><img src="/cos/upload/${bannerslist.file_storedname }" ></li>
				
			</c:forEach>
			</ul>
		</div>
		 
	</div>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$(".banner > ul li img").css({
	         height : $(window).height() + "px"
	      })
	      $(window).resize(function() {
	         $(".banner > ul li img").css({
	            height : $(window).height() + "px"
	         })
	      })
		$(".banner > ul").bxSlider({
			
			infiniteLoop: true,       //무한루프
	         pager: false,              //pager 쓸지안쓸지
	         adaptiveHeight: true,       //이미지 크기에따른 배너 높이변경
	         auto: true,                 //자동슬라이드
	         autoHover: false,           //마우스 올려놨을때 슬라이드멈춤
	         pause: 3000,                //슬라이드간 멈추는시간
	         speed: 500,                 //슬라이드 지나가는속도
	         controls: true,            //좌우 화살표 쓸지안쓸지
		});
		
	}); 
 
</script>
</html>

