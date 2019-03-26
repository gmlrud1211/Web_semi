<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"> </script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<div class="container" style="text-align:center;">
<form action="/board/fileupdate?b_no=${b_no}" method="post" enctype="multipart/form-data">
<p style="padding:30px; font-size: 15px;font-weight: 1000;">첨부할 파일을 선택해주세요</p>	
<input type="file" name="upfile" class="file file-primary" style="margin-left: 20px;"/><br><br>
<button class="btn btn-primary">업로드</button>
</form>
</div>

</body>
</html>


