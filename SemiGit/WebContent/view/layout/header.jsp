<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<!-- Theme main style -->
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/bootstrap-theme.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/js/bootstrap.min.js"></script>

</head>
<body>
<!-- Start Header Area -->
<nav class="navbar navbar-default navbar-fixed-top" style="background-image:linear-gradient(to bottom, #fff 100%, #f8f8f8 100%);position: sticky; z-index: 9999;"">
      <div class="container">
      <div class="row">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/main" style="color:#F67280"><h2><strong>MOMO</strong></h2></a>
        </div>
        <div id="navbar" class="navbar-right">
          <ul class="nav navbar-nav" style="font-size: 0.8em;">
            <li><a href="#">공지사항</a></li>
			  <li><a href="#">FAQ</a></li>
			  <li><a href="#">자유게시판</a></li>
			  <li><a href="#">스터디개설</a></li>
			  
			  <c:if test="${login }">
			  <li><a href="/mypage/bookmark">마이페이지</a></li>
			  <li><a href="/users/logout">로그아웃</a></li>
			  </c:if>
			  <c:if test="${!login }">
			  <li><a href="/users/login">로그인</a></li>
			  <li><a href="#">회원가입</a></li>			  
			  </c:if>
          </ul>
        </div>
      </div>
      <div class="row">
		<div id="navbar">
      		<ul class="nav navbar-nav navbar-center">
              <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">IT프로그래밍<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">Java·JSP</a></li>
	                <li><a href="#">C언어</a></li>
	                <li><a href="#">파이썬</a></li>
	                <li><a href="#">APP개발</a></li>
	                <li><a href="#">HTML·CSS 퍼블리싱</a></li>
	                <li><a href="#">Database</a></li>
	                <li><a href="#">해킹</a></li>
	                <li><a href="#">알고리즘</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
             <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">디자인<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">웹·모바일 디자인</a></li>
	                <li><a href="#">3D 모델링·도면</a></li>
	                <li><a href="#">로고디자인</a></li>
	                <li><a href="#">포토샵편집</a></li>
	                <li><a href="#">웹툰·캐릭터</a></li>
	                <li><a href="#">캘리그라피</a></li>
	                <li><a href="#">공간·인테리어</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
	         <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">콘텐츠제작<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">영상</a></li>
	                <li><a href="#">3D 모델링·도면</a></li>
	                <li><a href="#">사진</a></li>
	                <li><a href="#">더빙·녹음</a></li>
	                <li><a href="#">음악·사운드</a></li>
	                <li><a href="#">엔터테이너</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
	         <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">자격증<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">정보기술</a></li>
	                <li><a href="#">전자</a></li>
	                <li><a href="#">디자인</a></li>
	                <li><a href="#">건축</a></li>
	                <li><a href="#">도시·교통</a></li>
	                <li><a href="#">금속·재료</a></li>
	                <li><a href="#">생산관리</a></li>
	                <li><a href="#">조리·제과제빵</a></li>
	                <li><a href="#">보건의료</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
             <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">취업<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">이력서·자소서</a></li>
	                <li><a href="#">면접</a></li>
	                <li><a href="#">인적성</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li> 
             <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">외국어<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">영어회화</a></li>
	                <li><a href="#">중국어</a></li>
	                <li><a href="#">일본어</a></li>
	                <li><a href="#">토익/토플</a></li>
	                <li><a href="#">스페인어</a></li>
	                <li><a href="#">프랑스어</a></li>
	                <li><a href="#">독일어</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
	         <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">음악<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">보컬</a></li>
	                <li><a href="#">피아노</a></li>
	                <li><a href="#">작곡</a></li>
	                <li><a href="#">기타연주</a></li>
	                <li><a href="#">랩</a></li>
	                <li><a href="#">디제잉</a></li>
	                <li><a href="#">바이올린</a></li>
	                <li><a href="#">성악</a></li>
	                <li><a href="#">첼로</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
             <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">뷰티<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">메이크업</a></li>
	                <li><a href="#">헤어</a></li>
	                <li><a href="#">네일</a></li>
	                <li><a href="#">스킨케어/마사지</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li> 
             <li class="dropdown">
              	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">수능<span class="caret"></span></a>
              		<ul class="dropdown-menu" role="menu">
                	<li><a href="#">언어</a></li>
	                <li><a href="#">수학</a></li>
	                <li><a href="#">외국어</a></li>
	                <li><a href="#">사탐</a></li>
	                <li><a href="#">과탐</a></li>
	                <li><a href="#">제2외국어</a></li>
	                <li><a href="#">기타</a></li>
	              </ul>
	            </li>
           </ul>
		 </div>
      </div>  
		 </div>
    </nav>
 <!-- End Header Area -->  


    