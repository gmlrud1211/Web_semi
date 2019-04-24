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
			$("#btnFile").click(function() {
				
				//화면크기 구하기
				var w = screen.availWidth;
				var h = screen.availHeight;
				
				//팝업 띄우기
				var popup = window.open(
						"",
						"",
						"status=no" //하단 상태바
						+",menubar=no" //상단 메뉴
						+",scrollbars=no" //스크롤바
						+",resizable=no" //사이즈변경
						+",width=300" //너비
						+",height=200" //높이
						+",left="+(w-300)/2 //x 위치
						+",top="+(h-200)/2 ); //y 위치
				
				//팝업 url 설정
				popup.location = "/study/open/file";
			});
		});
		
		function sendData(no, name) {
			$("#file_no").val(no); //파일번호넣기
			$("#upResult").html(name); //파일이름 넣기
		}
		
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
		
			$("#btnOpen").click(function() {
				$("form").submit();
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			})
		});
		</script>
	
<body>
	<h3 style="text-align: center;"><small>스터디 개설하기</small></h3>
	<hr>
	
	
	<div class="container">	
	
		<form action="/study/open" method="post" class="form-horizontal">

			<div class="form-group">
				<label for="study_name" class="col-sm-3 col-sm-offset-1 control-label">스터디제목 </label> 
				<div class="col-sm-5">
					<input type="text" id="study_name" name="study_name" />
				</div>
			</div>
			
			<div class="form-group">
			<label for="st_code" class="col-sm-3 col-sm-offset-1 control-label"> 카테고리  </label>
					<div class="col-sm-5">
						<select name="st_catecode" id="st_catecode" >
								 <!-- onchange="fnGetCate(this.value);" -->
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
								
						<select name="st_code" id="st_code" >
						<%-- <c:if test="${cate_no eq 1}"> --%>
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
						<%-- </c:if>	
						<c:if test="${cate_no eq 2}">
							<option value="201">웹·모바일 디자인</option>
							<option value="202">3D 모델링 ·도면</option>
							<option value="203">로고디자인</option>
							<option value="204">포토샵편집</option>
							<option value="205">웹툰·캐릭터</option>
							<option value="206">캘리그라피</option>
							<option value="207">공간·인테리어</option>
							<option value="208">기타</option>
						</c:if>
						<c:if test="${cate_no eq 3 }">	
							<option value="301">영상</option>
							<option value="302">사진</option>
							<option value="303">더빙·녹음</option>
							<option value="304">음악·사운드</option>
							<option value="305">엔터테이너</option>
							<option value="306">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 4 }">	
							<option value="401">정보기술</option>
							<option value="402">전자</option>
							<option value="403">디자인</option>
							<option value="404">건축</option>
							<option value="405">도시·교통</option>
							<option value="406">금속·재료</option>
							<option value="407">생산관리</option>
							<option value="408">조리·제과제빵</option>
							<option value="409">보건의료</option>
							<option value="410">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 5 }">	
							<option value="501">이력서·자소서</option>
							<option value="502">면접</option>
							<option value="503">인적성</option>
							<option value="504">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 6 }">	
							<option value="601">영어회화</option>
							<option value="602">중국어</option>
							<option value="603">일본어</option>
							<option value="604">토익/토플</option>
							<option value="605">스페인어</option>
							<option value="606">프랑스어</option>
							<option value="607">독일어</option>
							<option value="608">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 7 }">	
							<option value="701">보컬</option>
							<option value="702">피아노</option>
							<option value="703">작곡</option>
							<option value="704">기타연주</option>
							<option value="705">랩</option>
							<option value="706">디제잉</option>
							<option value="707">바이올린</option>
							<option value="708">성악</option>
							<option value="709">첼로</option>
							<option value="710">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 8 }">	
							<option value="801">메이크업</option>
							<option value="802">헤어</option>
							<option value="803">네일</option>
							<option value="804">스킨케어/마사지</option>
							<option value="805">기타</option>
						</c:if>	
						<c:if test="${cate_no eq 9 }">	
							<option value="901">언어</option>
							<option value="902">수학</option>
							<option value="903">외국어</option>
							<option value="904">사탐</option>
							<option value="905">과탐</option>
							<option value="906">제2외국어</option>
							<option value="907">기타</option>
						</c:if>		 --%>
								<%-- <c:forEach items="${studycate }" var="cate">
									<option value="${cate.st_code }">${cate.st_subcate }</option>
								</c:forEach>    --%>
						</select>
					</div>
			</div>
	
			<div class="form-group">
			<label for="study_region" class="col-sm-3 col-sm-offset-1 control-label"> 지역  </label>  
					<div class="col-sm-5">
						<input type="radio" name="study_region" value="강남" /> 강남 
						<input type="radio" name="study_region" value="신촌" /> 신촌
						<input type="radio" name="study_region" value="선릉" /> 선릉
						<input type="radio" name="study_region" value="수색" /> 수색 
						<input type="radio" name="study_region" value="가좌" /> 가좌
						<input type="radio" name="study_region" value="일산" /> 일산 					
						<input type="radio" name="study_region" value="역삼" /> 역삼
						<input type="radio" name="study_region" value="건대" /> 건대
						<input type="radio" name="study_region" value="홍대" /> 홍대
						<input type="radio" name="study_region" value="종로" /> 종로
						<input type="radio" name="study_region" value="영등포" /> 영등포
						<input type="radio" name="study_region" value="잠실" /> 잠실
						<input type="radio" name="study_region" value="인천" /> 인천
						<input type="radio" name="study_region" value="노원" /> 노원
						<input type="radio" name="study_region" value="경기" /> 경기
						<input type="radio" name="study_region" value="남양주" /> 남양주
						<input type="radio" name="study_region" value="의정부" /> 의정부
						<input type="radio" name="study_region" value="일산" /> 일산
						<input type="radio" name="study_region" value="하남" /> 하남		
						<input type="radio" name="study_region" value="김포" /> 김포   
						<input type="radio" name="study_region" value="분당" /> 분당
						<input type="radio" name="study_region" value="수원" /> 수원
						<input type="radio" name="study_region" value="시흥" /> 시흥
						<input type="radio" name="study_region" value="김포" /> 김포
						<input type="radio" name="study_region" value="울산" /> 울산
						<input type="radio" name="study_region" value="부산" /> 부산
						<input type="radio" name="study_region" value="강원" /> 강원
						<input type="radio" name="study_region" value="대구" /> 대구
						<input type="radio" name="study_region" value="대전" /> 대전
						<input type="radio" name="study_region" value="충북" /> 충북
						<input type="radio" name="study_region" value="충남" /> 충남
						<input type="radio" name="study_region" value="천안" /> 천안
						<input type="radio" name="study_region" value="전북" /> 전북
						<input type="radio" name="study_region" value="전남" /> 전남
						<input type="radio" name="study_region" value="경북" /> 경북
						<input type="radio" name="study_region" value="경남" /> 경남
						<input type="radio" name="study_region" value="제주" /> 제주
						<input type="radio" name="study_region" value="세종" /> 세종
					</div>
			</div>		
			<div class="form-group">
			<label for="study_time" class="col-sm-3 col-sm-offset-1 control-label"> 시간대  </label>
				<div class="col-sm-5">
					
					<input type="radio" name="study_time" value="전시간가능" /> 전시간가능 
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
			<div class="form-group">
			<label class="col-sm-3 col-sm-offset-1 control-label"> 스터디기간  </label>
				<div class="col-sm-5">
					<input type="text" name="study_opendate" id="studyopendate" > ~ <input type="text" name="study_period" id="studyperiod"> 
				</div>
			</div>
			<div class="form-group">
			<label class="col-sm-3 col-sm-offset-1 control-label"> 상세 내용 </label>  
				<div class="col-sm-5">
				<textarea name="study_detail" cols="50" rows="7" placeholder="하고싶은말을 자유롭게 작성해주세용" > </textarea>  
				</div>
			</div>		   
	
			<div class="col-sm-offset-4">
				<input type="hidden" id="file_no" name="file_no" />
				<button type="button" id="btnFile" class="btn btn-default" >대표이미지 파일 첨부</button>
				<span id="upResult"></span>
			</div>
			<br><br>
		</form>	
	</div>


	<div class="col-sm-offset-4">
			<button type="button" id="btnOpen" class="btn btn-sm" style="color:#ffffff; background:#F67280">등록</button>
			<button type="button" id="btnCancel" class="btn btn-sm" style="color:#ffffff; background:#FA4C64">취소</button>
	</div>


</body>
</html>