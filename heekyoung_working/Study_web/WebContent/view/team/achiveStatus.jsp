<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp"/>

<title>목표 관리</title>

<!-- chart.js cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<h3 style="text-align: center;"><small>목표 현황</small></h3>

<div>
	<canvas id="myChart"  width="200" height="250" > </canvas>
</div>		
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
	

	
	<div>
		<table class="table table-bordered">
		
			<tr>
				<td class="info">목표마감일</td><td>?</td>
			</tr>
			<tr>
				<td class="info">목표</td><td>?</td>
			</tr>
			<tr>
				<td class="info">세부목표</td><td>?</td>
				<td><input type="checkbox" name="sub_code" value="yes" /> 달성</td>
			</tr>		
		
		</table>
	</div>