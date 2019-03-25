<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../layout/header.jsp"/>    

	<title>studyopen</title>
	
	<!--datepicker쓰기위한 jQuery-->  
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script type="text/javascript">

	$(function() {
	    $( "#studyopendate" ).datepicker({

	    });
	   	$( "#studyopendate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	    
	});
	$(function() {
	    $( "#studyperiod" ).datepicker({
	    });
	    $( "#studyperiod" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	    
	});
	$(function() {
	    $( "#studyaddrecruit" ).datepicker({
	    });
	    $( "#studyaddrecruit" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	    
	});
	</script>
	
	
		<!-- 상위카테고리 선택에 따른 하위카테고리  리스트 보여줌--> 
 <!-- 	<script type="text/javascript">
	
		function fnGetCate(param) {
			var $target = $("select[name='st_code']");
			
			$target.empty();
			if(param==""){
				$target.append("<option value=""> 선택 </option>");
				return;
			}
			
			$.ajax ({
				type="post",
				url ="/view/study/cate",
				async : false,
				data:{st_catecode:param},
				dataType : "json",
				success : function(data) {
					if(data.length ==0) {
						$target.append("<opction value="">선택</option>");
					} else {
						$(data).each(function(i){
							$target.append("<option value="+data[i].st_code+">"+data[i].st_name+"</option>");
							
						});
					}
				}, 
				error:function(xhr){
					console.log(xhr.responseText);
					alert("잠시 후 다시 이용해주세요.");
					return;
				}
				
			});
			
		} 
	</script>  -->

	
	<script type="text/javascript">
		$(document).ready(function() {
		
			$("#btnUpdate").click(function() {
				$("form").submit();
				alert("수정 완료되었습니다!");				
				
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			})
		});
		</script>

		
<div class="wrapper">
<div class="container">

<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="name"><h2>Team Page</h2></div>
	          <div class="list-group" style="box-shadow: none;">
	            <a href="#" class="list-group-item" style="border:none;">스터디룸 메인</a>
	            <a href="#" class="list-group-item" style="border:none;">일정 관리</a>
	            <a href="/team/achive/view" class="list-group-item" style="border:none;">목표 관리</a>
	            <a href="/team/board" class="list-group-item" style="border:none;">팀별 게시판</a>
	            <a href="/team/manage" class="list-group-item" style="border:none;">스터디룸 관리</a>

        	 </div>
        	</div><!--/.sidebar-offcanvas-->

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280; border-radius: 0;" >
            <h2>스터디룸 수정</h2>
            <p style="font-size: 16px">스터디룸 수정 페이지 입니다.</p>
          </div>
          
          <div class="row">
				<form action="/team/info/update" method="post" class="form-horizontal">
		
					<!-- <div class="form-group">
						<label for="study_name" class="col-sm-3 col-sm-offset-1 control-label">스터디제목 </label> 
						<div class="col-sm-5">
							<input type="text" id="study_name" name="study_name" readonly />
						</div>
					</div>
					-->
					<!-- <div class="form-group">
					<label for="st_code" class="col-sm-3 col-sm-offset-1 control-label"> 카테고리  </label>
							<div class="col-sm-5">
								<select name="st_catecode" id="st_catecode" >
										 onchange="fnGetCate(this.value);"
									<option value="">1차분류</option>
									<option value="1">IT·프로그래밍</option>
									<option value="2">디자인</option>
									<option value="3">콘텐츠 제작</option>
									<option value="4">자격증</option>
									<option value="5">취업</option>
									<option value="6">외국어</option>
									<option value="7">음악</option>
									<option value="8">뷰티</option>
									<option value="9">수능</option>
		
								</select>
										
								<select name="st_code" id="st_code">
									<option value="">2차분류</option>
									<option value="101">Java·Jsp</option>
									<option value="102">C언어</option>
									<option value="103">Python</option>
									<option value="104">App개발</option>
									<option value="105">HTML·CSS 퍼블리싱</option>
									<option value="106">Database</option>
									<option value="107">해킹</option>
									<option value="108">알고리즘</option>
									<option value="109">기타</option>
								</select>
							</div>
					</div>
			 		 -->
					<div class="form-group">
					<label for="study_region" class="col-sm-3 col-sm-offset-1 control-label"> 지역  </label>  
							<div class="col-sm-5">
								<input type="radio" name="study_region" value="강남" /> 강남 
								<input type="radio" name="study_region" value="역삼" /> 역삼
								<input type="radio" name="study_region" value="건대" /> 건대
								<input type="radio" name="study_region" value="홍대" /> 홍대
								<input type="radio" name="study_region" value="종로" /> 종로
								<input type="radio" name="study_region" value="영등포" /> 영등포
								<input type="radio" name="study_region" value="잠실" /> 잠실
								<input type="radio" name="study_region" value="노원" /> 노원
								<input type="radio" name="study_region" value="하남" /> 하남		
								<input type="radio" name="study_region" value="인천" /> 인천
								<input type="radio" name="study_region" value="김포" /> 김포   
								<input type="radio" name="study_region" value="분당" /> 분당
								<input type="radio" name="study_region" value="수원" /> 수원
								<input type="radio" name="study_region" value="시흥" /> 시흥
								<input type="radio" name="study_region" value="대구" /> 대구
								<input type="radio" name="study_region" value="대전" /> 대전
								<input type="radio" name="study_region" value="부산" /> 부산
								<input type="radio" name="study_region" value="김포" /> 김포
							</div>
					</div>		
					<div class="form-group">
					<label for="study_time" class="col-sm-3 col-sm-offset-1 control-label"> 시간대  </label>
						<div class="col-sm-5">
							
							<input type="radio" name="study_time" value="전 시간가능" /> 전시간 가능 
							<input type="radio" name="study_time" value="주중 시간무관" /> 주중 시간무관
							<input type="radio" name="study_time" value="주중 오전" /> 주중 오전 
							<input type="radio" name="study_time" value="주중 오후" /> 주중 오후
							<input type="radio" name="study_time" value="주말 시간무관" /> 주말 시간무관
							<input type="radio" name="study_time" value="주말 오전" /> 주말 오전	
					 		<input type="radio" name="study_time" value="주말 오후" /> 주말 오후
						</div>
					</div>
					
					<div class="form-group">
						<label for="study_freq" class="col-sm-3 col-sm-offset-1 control-label"> 스터디 횟수  </label>
						<div class="col-sm-5">
							<input type="text" id="study_freq" name="study_freq" placeholder="횟수를 입력해주세요" /> 회
						</div>
					</div>
					<div class="form-group">
					<label class="col-sm-3 col-sm-offset-1 control-label"> 모집인원 </label> 
						<div class="col-sm-5">
							<select name="study_min" id="study_min">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
							</select> ~ 
							<select name="study_max" id="study_max">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
							</select>
						</div>
					</div>
					<div class="form-group">
					<label for="study_gender" class="col-sm-3 col-sm-offset-1 control-label"> 성별</label>  
						<div class="col-sm-5">
							<input type="radio" name="study_gender" value="무관" /> 무관			
							<input type="radio" name="study_gender" value="여자" /> 여자
							<input type="radio" name="study_gender" value="남자" /> 남자
						</div>
					</div>
			<!-- 		<div class="form-group">
					<label class="col-sm-3 col-sm-offset-1 control-label"> 스터디기간  </label>
						<div class="col-sm-5">
							<input type="text" name="study_opendate" id="studyopendate" > ~ <input type="text" name="study_period" id="studyperiod"> 
						</div>
					</div> -->
					<div class="form-group">
					<label class="col-sm-3 col-sm-offset-1 control-label"> 추가모집기간</label>
						<div class="col-sm-5">
							<input type="text" name="study_addrecruit" id="studyaddrecruit" > ~ 까지 추가모집
						</div>
					</div>
					<div class="form-group">
					<label class="col-sm-3 col-sm-offset-1 control-label"> 상세 내용 </label>  
						<div class="col-sm-5">
						<textarea name="study_detail" cols="50" rows="7" placeholder="하고싶은말을 자유롭게 작성해주세용" > </textarea>  
						</div>
					</div>		   
			
					<br><br>
				</form>	
			</div>
		
			<div class="col-sm-offset-4">
				<button type="button" id="btnUpdate" class="btn btn-sm" style="color:#ffffff; background:#F67280">수정완료</button>
				<button type="button" id="btnCancel" class="btn btn-sm" style="color:#ffffff; background:#FA4C64">취소</button>
			</div>

          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>

</div>
