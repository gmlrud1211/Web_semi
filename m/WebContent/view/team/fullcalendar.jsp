<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/view/layout/header.jsp" />
<title>일정관리</title>

<style type="text/css">
::selection {
   background-color: #E13300;
   color: white;
}

::moz-selection {
   background-color: #E13300;
   color: white;
}

::webkit-selection {
   background-color: #E13300;
   color: white;
}

body {
   background-color: #fff;
   margin: 40px;
   font: 13px/20px normal Helvetica, Arial, sans-serif;
   color: #4F5155;
}

#body {
   margin: 0 15px 0 15px;
}

#script-warning {
   display: none;
   background: #eee;
   border-bottom: 1px solid #ddd;
   padding: 0 10px;
   line-height: 40px;
   text-align: center;
   font-weight: bold;
   font-size: 12px;
   color: red;
}

#loading {
   display: none;
   position: absolute;
   top: 10px;
   right: 10px;
}
</style>

<link href='/view/team/css/fullcalendar.min.css' rel='stylesheet' />
<link href='/view/team/css/fullcalendar.print.min.css' rel='stylesheet'
   media='print' />
<link href='/view/team/css/fullcalendar.css' rel='stylesheet'
   type="text/css" />
<!-- <link href='./css/fullcalendar.print.css' rel='stylesheet' type="text/css" /> -->
<link href='/view/team/css/main.css' rel='stylesheet' type="text/css" />

<script src='/view/team/js/moment.min.js'></script>
<script src='/view/team/js/fullcalendar.min.js'></script>
<!-- <script src='./js/jquery-ui.min.js'></script> -->
<script src="/view/team/js/jquery.bpopup.min.js" type="text/javascript"></script>
<script src='/view/team/js/ko.js'></script>



<script>
      $(document).ready(function(){
       
                $('#calendar').fullCalendar({
                header: {
                       left: 'prev,next today',
                       center: 'title',
                       right: 'month,agendaWeek,agendaDay,listMonth'
                     },
                   editable : true,
                   navLinks : true,
                   eventLimit : true,
                   locale : "ko",
                   events :  ${list},
                   
                   eventClick: function(calEvent, jsEvent, view){
                      if(!confirm("일정'"+calEvent.title+"'을 삭제하시겠습니까?"))
                         {return false;}
                      $.ajax({
                         type : 'post',
                         url: "/schedule/delete",
                         data : { c_id : calEvent.no },
                         cache : false,
                         async : false
                      })
                      .done(function(result){
                         window.location.reload();
                         if(result == 1){
                             alert("정상 삭제되었습니다");
                            
                             $('#calendar').fullCalendar("refetchEvents");
                            }
                      });
                   }
   
                          
                });
         
      });
      
      

      function addSchedule()
      {
         var htmlsContents = ""; 
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>일정명칭</div> <div style='width:60%;float:right;'><input type='text' id='title' value=''></div></div>";
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>일정내용</div> <div style='width:60%;float:right;'><input type='text' id='content' value='' style='width:80px'></div></div>";
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>시작날짜</div> <div style='width:60%;float:right;'><input type='text' id='start' value='' style='width:80px'></div></div>";
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>마침날짜</div> <div style='width:60%;float:right;'><input type='text' id='end' value='' style='width:80px'></div></div>";
         
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>주소</div> <div style='width:60%;float:right;'><input type='text' id='address' style='width:200px'></div></div>";
         htmlsContents+="<div style='width:100%; height:30px;'><div style='width:30%;float:left; padding-left:30px;'>장소명</div> <div style='width:60%;float:right;'><input type='text' id='place' style='width:100px'></div></div>";

         htmlsContents+="<input type='hidden' id='pTitle'>";
         htmlsContents+="<input type='hidden' id='pAddress'>";
         htmlsContents+="<input type='hidden' id='pLat'>";
         htmlsContents+="<input type='hidden' id='pLng'>";

       
         htmlsContents+="<div style='width:100%; text_align:center;height:30px; margin-left:40%; margin-bottom:15px; margin-top:10px'><button id='save' onclick=\'javascript:saveSchedule();\'>저장하기</button></div>";

         
         openPopup("일정등록",htmlsContents, 900);
         map.relayout();
                          
      }
      
      function openPopup(subject,contents, widths)
      {
         $("#alert_subject").html(subject);
         $("#alert_contents").html(contents);
         openMessage("winAlert",widths);
      }
      
      function saveSchedule()
      {
        var calendar_title = $("#title").val();
        var calendar_content = $("#content").val();
        var calendar_start_date = $("#start").val();
        var calendar_end_date = $("#end").val();
        
//         var url = "/ajax/schedule";
        
      
        if(!calendar_title)
           {
           alert("일정 명칭을 입력해 주세요");
            return false; 
           }
        if(!calendar_content)
       {
       alert("일정 명칭을 입력해 주세요");
        return false; 
       }
        if(!calendar_start_date)  {
           alert("시작날짜를 입력해 주세요");
            return false; 
           }
        if(!calendar_end_date)  {
           alert("마침날짜를 입력해 주세요");
            return false; 
           }
       
        $.ajax({
           type:"post",
//            cache:false,
//            async:false,
           data: {
           
              "title" : $("#title").val(),
              "content": $("#content").val(),
              "start": $("#start").val(),
              "end": $("#end").val(),
              
              "placeTitle": $("#pTitle").val(),
              "placeAddress" : $("#pAddress").val(),
              "placeLat" : $("#pLat").val(),
              "placeLng" : $("#pLng").val()
              } ,
           url: "/ajax/schedule",
        
              success : function(data){
                 
              alert("정상 저장되었습니다"); 
              window.location.reload();
             
              closeMessage('winAlert');
              
                console.log(data);
              
                $("#alert_contents").html(data); 
               $('#calendar').fullCalendar("refetchEvents");
           }
           , error: function(e) {
            alert("실패");
            console.log(e);
           }

        });

      
      }
      
       function openMessage(IDS,widths){
         $('#'+IDS).css("width",widths+"px");
         $('#'+IDS).bPopup();
         
      }
      
      function closeMessage(IDS){
        
         $('#'+IDS).bPopup().close();
         
      } 
   

    </script>

</head>
<body>

<jsp:include page="/view/layout/studyroom.jsp" />

   <div id='script-warning'>실행오류!</div>


   <div style="max-width: 900px; margin: 0 auto; height: 30px;">
      <div style="float: right;">
         <button onclick="javascript:addSchedule();">일정등록</button>
      </div>
   </div>

   <div id='calendar' style="max-width: 900px; margin: 0 auto; float:left;"></div>

   <div class="box box-success"
      style="width: 900px; display: none; background-color: white;"
      id="winAlert">
      <div class="box-header with-border"
         style="bakcground-color: white; padding-left: 15px">
         <h3 class="box-title" id="alert_subject"
            style="background-color: white"></h3>
      </div>
      <!-- box-header -->
      <div class="box-body" id="alert_contents"
         style="font-size: 15px; background-color: white;"></div>
      <div style="margin-left: 1%;">
         <h4>장소 검색</h4>
         <jsp:include page="/view/team/location.jsp" />
      </div>
   </div>