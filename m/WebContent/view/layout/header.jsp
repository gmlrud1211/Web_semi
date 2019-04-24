<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"> </script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->

</head>
<body>
	<!-- Start Header Area -->
	<nav class="navbar navbar-default navbar-fixed-top"
		style="background-image: linear-gradient(to bottom, #fff 100%, #f8f8f8 100%); position: sticky; z-index: 999;"">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/main" style="color: #F67280"><h2>
							<strong>MOMO</strong>
						</h2></a>
				</div>
				<div id="navbar" class="navbar-right">
					<ul class="nav navbar-nav" style="font-size: 0.8em;">
						<li><a href="/noticeboard/pagelist">공지사항</a></li>
						<li><a href="/faq/pagelist">FAQ</a></li>
						<li><a href="/board/list">자유게시판</a></li>
						<li><a href="/study/open">스터디개설</a></li>

						<c:if test="${login }">
							<li><a href="/mypage/mystudy/mystudyroom">마이페이지</a></li>
							<li><a href="/users/logout">로그아웃</a></li>
						</c:if>
						<c:if test="${!login }">
							<li><a href="/users/login">로그인</a></li>
							<li><a href="/users/join">회원가입</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="navbar">
					<ul class="nav navbar-nav navbar-center">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">IT프로그래밍<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=101">Java·JSP</a></li>
								<li><a href="/study/category?st_code=102">C언어</a></li>
								<li><a href="/study/category?st_code=103">파이썬</a></li>
								<li><a href="/study/category?st_code=104">APP개발</a></li>
								<li><a href="/study/category?st_code=105">HTML·CSS 퍼블리싱</a></li>
								<li><a href="/study/category?st_code=106">Database</a></li>
								<li><a href="/study/category?st_code=107">해킹</a></li>
								<li><a href="/study/category?st_code=108">알고리즘</a></li>
								<li><a href="/study/category?st_code=109">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">디자인<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=201">웹·모바일 디자인</a></li>
								<li><a href="/study/category?st_code=202">3D 모델링·도면</a></li>
								<li><a href="/study/category?st_code=203">로고디자인</a></li>
								<li><a href="/study/category?st_code=204">포토샵편집</a></li>
								<li><a href="/study/category?st_code=205">웹툰·캐릭터</a></li>
								<li><a href="/study/category?st_code=206">캘리그라피</a></li>
								<li><a href="/study/category?st_code=207">공간·인테리어</a></li>
								<li><a href="/study/category?st_code=208">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">콘텐츠제작<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=301">영상</a></li>
								<li><a href="/study/category?st_code=302">3D 모델링·도면</a></li>
								<li><a href="/study/category?st_code=303">사진</a></li>
								<li><a href="/study/category?st_code=304">더빙·녹음</a></li>
								<li><a href="/study/category?st_code=305">음악·사운드</a></li>
								<li><a href="/study/category?st_code=306">엔터테이너</a></li>
								<li><a href="/study/category?st_code=307">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">자격증<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=401">정보기술</a></li>
								<li><a href="/study/category?st_code=402">전자</a></li>
								<li><a href="/study/category?st_code=403">디자인</a></li>
								<li><a href="/study/category?st_code=404">건축</a></li>
								<li><a href="/study/category?st_code=405">도시·교통</a></li>
								<li><a href="/study/category?st_code=406">금속·재료</a></li>
								<li><a href="/study/category?st_code=407">생산관리</a></li>
								<li><a href="/study/category?st_code=408">조리·제과제빵</a></li>
								<li><a href="/study/category?st_code=409">보건의료</a></li>
								<li><a href="/study/category?st_code=410">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">취업<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=501">이력서·자소서</a></li>
								<li><a href="/study/category?st_code=502">면접</a></li>
								<li><a href="/study/category?st_code=503">인적성</a></li>
								<li><a href="/study/category?st_code=504">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">외국어<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=601">영어회화</a></li>
								<li><a href="/study/category?st_code=602">중국어</a></li>
								<li><a href="/study/category?st_code=603">일본어</a></li>
								<li><a href="/study/category?st_code=604">토익/토플</a></li>
								<li><a href="/study/category?st_code=605">스페인어</a></li>
								<li><a href="/study/category?st_code=606">프랑스어</a></li>
								<li><a href="/study/category?st_code=607">독일어</a></li>
								<li><a href="/study/category?st_code=608">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">음악<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=701">보컬</a></li>
								<li><a href="/study/category?st_code=702">피아노</a></li>
								<li><a href="/study/category?st_code=703">작곡</a></li>
								<li><a href="/study/category?st_code=704">기타연주</a></li>
								<li><a href="/study/category?st_code=705">랩</a></li>
								<li><a href="/study/category?st_code=706">디제잉</a></li>
								<li><a href="/study/category?st_code=707">바이올린</a></li>
								<li><a href="/study/category?st_code=708">성악</a></li>
								<li><a href="/study/category?st_code=709">첼로</a></li>
								<li><a href="/study/category?st_code=710">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">뷰티<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=801">메이크업</a></li>
								<li><a href="/study/category?st_code=802">헤어</a></li>
								<li><a href="/study/category?st_code=803">네일</a></li>
								<li><a href="/study/category?st_code=804">스킨케어/마사지</a></li>
								<li><a href="/study/category?st_code=805">기타</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">수능<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/study/category?st_code=901">언어</a></li>
								<li><a href="/study/category?st_code=902">수학</a></li>
								<li><a href="/study/category?st_code=903">외국어</a></li>
								<li><a href="/study/category?st_code=904">사탐</a></li>
								<li><a href="/study/category?st_code=905">과탐</a></li>
								<li><a href="/study/category?st_code=906">제2외국어</a></li>
								<li><a href="/study/category?st_code=907">기타</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!-- End Header Area -->