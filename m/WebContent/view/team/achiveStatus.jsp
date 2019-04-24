<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Achive" %>
<%@ page import= "dto.AchivePeople" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../layout/header.jsp"/>

<title>목표 관리</title>

<!-- chart.js cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<style>

	.canvas {
		float : right;
		margin-top :5%;
		margin-right:10%;
	}
	.achiveView {
		float : left;
		margin : 20px;
	}
	table {
		width : 500px;
		height :150px;
		border-bottom : 1px solid #ccc;
		
		
	}
	tr td {
	}
	
	
</style>

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
          
          <div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #f67280;
          border-radius: 0;" >
            <h2>스터디룸 페이지</h2>
            <p style="font-size: 16px">목표관리 페이지</p>
          </div>
          <div class="row">

			
		<div class="canvas" >
			<canvas id="myChart"  width="200" height="250" > </canvas><br>
			<button id="btnSearch" class="btn btn-sm" style="color:#ffffff; background:#F67280">달성률 조회</button>
		</div>	
		
		<div class="canvas">	
	
		</div>
		<script type="text/javascript">
	
			
		var ctx = document.getElementById('myChart');
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
		
		
		<script type="text/javascript">
			$(document).ready(function() {			
				$("#btnSearch").click(function() {
					$("form").submit();
				});
	
				var size = ${achiveListSize};
				var list = '';
				if(size!=0) {
					console.log(${subANoList});
				}
				
				$("input[name=sub_code]").click(function() {
	// 				console.log($(this).is(":checked"));
	// 				console.log($(this).attr("value"));
	
					$.ajax({
						url: ""
						, type: "get"
						, dataType: "json"
						, data: {
							"checked":$(this).is(":checked")
							, "suba_no":$(this).attr("value")
						}
						 ,/*  success: function() {
							var apl = ${apl};
							if( apl != null ) {
							var l = apl.split(",");
						    for( var i=0; i<l.length; i++ ) {
						      $("input[type='checkbox'][value='"+l[i]+"']".prop("checked", true));
						     }
						   }
						 }
						,  */
						success : function() {
							$("input[type='checkbox']".prop("checked", true));
						}
						/* , complete : function() {
							location.reload();
						} */
					});
				});
				
			});
		</script>
	
			<script type="text/javascript">
			$(document).ready(function() {		
				$("#btnSearch").click(function() {
					var ctx = document.getElementById('myChart');
					var myChart = new Chart(ctx, {
					   
						type: 'doughnut',
						
					    data: {
					       	labels: ['1번과제', '2번과제', '3번과제'],
					        datasets: [{
					            label: '# of Votes',
					            data: [33, 33, 33],
					            backgroundColor: [
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(54, 162, 235, 0.2)',
					                'rgba(255, 206, 86, 0.2)'
					            ],
					            borderColor: [
					                'rgba(255, 99, 132, 1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 206, 86, 1)'
					            ],
					            borderWidth: 1
					        }]
					    },
					    options: {
					      responsive : false
					    }
					});				
				
				})
			});
		</script>
			
		
		
<!-- 		<form method="post" > -->
		
			<div class="achiveView">
			
			<c:set var="c" value="${achiveList[0].a_no }" />
			<c:set var="b" value="0" />
			 
			<c:forEach items="${achiveList}" var="achiveList" varStatus="stat">
			<c:set var="c" value="${achiveList.a_no }" />
				
			<c:if test="${b ne c }">
				<c:if test="${stat.first ne true }">
					</table>
					<br><br>
				</c:if>
					
				<table>
			
					<tr>
						<td>목표마감일</td>
						<td colspan='2'>${achiveList.a_ddate}</td>
					</tr>
					<tr>
						<td>목표</td>
						<td colspan='2'>${achiveList.a_title }</td>
					</tr>
			</c:if>
	
			<c:set var="b" value="${c }" />
	
				<tr>
					<td>세부목표 &nbsp;&nbsp; ${achiveList.suba_no }</td>
					<td>${achiveList.suba_name}</td>
					<td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%-- 						<input type="hidden" name="suba_no" id="suba_no" value="${achiveList.suba_no }"/> --%>
<!-- 						<input type="checkbox" name="sub_code" value="yes" />&nbsp;&nbsp;달성 -->
<!-- 							<button id="btnSearch" class="btn btn-sm" style="color:#ffffff; background:#F67280">달성 체크</button><br> -->
						<input type="checkbox" name="sub_code" value="${achiveList.suba_no }" />&nbsp;&nbsp;달성
					</td>
				</tr>
				<c:if test="${stat.last }">
					</table>
					<br><br>
				</c:if>
			</c:forEach>
				
		</div>

<!-- 		</form> -->
  
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

      </div><!--/row-->

    </div>


</div>
</div>