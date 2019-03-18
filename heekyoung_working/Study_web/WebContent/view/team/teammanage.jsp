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

	
	<canvas id="myChart"  width="200" height="250"> </canvas>
	
	
	<script type="text/javascript">

	var ctx = document.getElementById('myChart').getContext('2d');
	var myChart = new Chart(ctx, {
	   
		type: 'doughnut',
		
	    data: {
	        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
	        datasets: [{
	            label: '# of Votes',
	            data: [12, 19, 3, 5, 2, 3],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	      responsive : false
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
	