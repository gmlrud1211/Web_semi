<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<jsp:include page="../layout/header.jsp"/>    
<title>스터디룸 관리</title>

<script type="text/javascript">
	$(document).ready(function() {
					
		//글쓰기 버튼 이벤트
		$("#btnEnroll").click(function() {
			location.href ="/team/achive/write";
		});
		
		//스터디룸 정보 수정 이벤트
		$("#btnUpdate").click(function() {
			location.href ="/team/info/update";
		});
	});
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>



<h3 style="text-align: center;">스터디룸 관리<small> &laquo;목표등록, 수정, 팀원 관리&raquo; </small></h3>
<hr>	
	<h3 style="text-align: center;"><small>목표관리</small></h3>

	



	<div>
		<canvas id="myChart" style="display: block; width: 426px; height: 213px;" width="426" height="213" ></canvas>

	</div>

	<script type="text/javascript">
	var ctx = document.getElementById('myChart').getContext('2d');
	
	var myChart = new Chart(ctx, {
		type :'doughnut',
		data : {
			label : ['1번과제','2번과제'],
			dataset: [{
				label:'Points',
				data: [10,90],
				backgroundColor : [
					'rgba(25,140,255,1)',
					'rgba(0,0,0,0.50)'
				],
				hoverBackgroundtColor : [
					'rgba(25,140,255,1)',
					'rgba(0,0,0,0.50)'
				]
			}]
		},
		 options: {
		       animation : {
		    	   animateScale : true
		
		       }
		 }
	});
	
	</script>



		
	<div id="btnBox" class="btn pull-right">
		<button id="" class="btn btn-sm" style="color:#ffffff; background:#F67280">팀원관리</button>
	</div>
	<div id="btnBox" class="btn pull-right">
		<button id="btnEnroll" class="btn btn-sm" style="color:#ffffff; background:#F67280">새로운 목표 등록</button>
	</div>
	<div id="btnBox" class="btn pull-right">
		<button id="btnUpdate" class="btn btn-sm" style="color:#ffffff; background:#F67280">스터디 정보 수정</button>
	</div>
	