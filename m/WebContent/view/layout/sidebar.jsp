<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.3.min.js"></script>



<script>
$(document).ready(function(){
    
    //모든 서브 메뉴 감추기
    $(".sub").css({display:"none"}); 
    //$(".sub").hide(); //위코드와 동일 

    $(".title").click(function(){
        //일단 서브메뉴 다 가립니다.
        //$(".sub").css({display:"none"});
        
        //열린 서브메뉴에 대해서만 가립니다.
        $(".sub").each(function(){
            console.log($(this).css("display"));
            if($(this).css("display")=="block") {
                //$(".sub").css({display:"none"});
                //$(this).hide();
                $(this).slideUp("fast");
            }
        });
        

        //현재 요소의 다음 요소를 보이게 합니다.
        //$(this).next("ul").css({display:"block"});
        //$(this).next("ul").show();
        $(this).next("ul").slideDown("fast");

    })
});


</script>




<style>


body {
	margin: px auto;
	padding: px auto;
	font-family: "맑은 고딕";
	font-size: 1.5em;
	
}

ul#navi {
	width: 300px;
/* 	height:80%; */
	text-indent: 10px;
}

	
ul#navi a {
	width: 300px;
/* 	height:80%; */
	text-indent: 10px;
	
	
	
}
ul#navi, ul#navi ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

li.group {
	margin-bottom: 10px;
}

li.group div.title a  {
color :  grey;

text-decoration: none;
	
}

li.group div.title a:hover {
	
 text-decoration: none;
 color :  #F67280;
}
	
	

li.group div.title {
    text-align : center !important;
    font-size: 1.55em;
	height: 55px;
	line-height: 50px;
	color :  grey;
	cursor: pointer;
	
   
	
}

ul.sub li {
    text-align : center;
	margin-bottom: 2px;
	height: 35px;
	line-height: 35px;
	cursor: pointer;
	
}

ul.sub li a {
	display: block;
	width: 100%;
	height: 100%;
	text-decoration: none;
	color :  grey;
}

ul.sub li:hover {
	background: #F67280;
}


</style>
</head>
<body>

	<ul id="navi" style="border-left: 1px solid black;">
		<li class="group">
			<div class="title"><a href="/usersmanage/list" role="button" aria-expanded="false">회원관리</a></div>
			
		</li>
		<li class="group"> 
			<div class="title">게시판관리</div> 
			<ul class="sub">
				<li><a href="/board/list" aria-expanded="false" >자유게시판</a></li>
				<li><a href="/faq/list">FAQ관리</a></li>
				<li><a href="/noticeboard/adminlist" aria-expanded="false" >공지사항</a></li>
			</ul>
		</li>
		<li class="group">
			<div class="title">
			<a href="/oneandboard/list">1대1 문의관리</a></div>
			
		</li>
		<li class="group">
			<div class="title">
			<a href="/banners/list">배너관리</a></div>
			
		</li>
		<li class="group">
			<div class="title">
			<a href="/report/list">신고관리</a></div>
			
		</li>
	</ul>

</body>
</html>