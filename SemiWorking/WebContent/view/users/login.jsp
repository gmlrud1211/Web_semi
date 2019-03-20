<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp"/>

<div class="wrapper">
<div class="container" style="width: 400px;position: absolute; top: 40%; left: 42%; margin: -50px 0 0 -50px;">

      <form class="form-login" action="/users/login" method="post">
        <h2 class="form-login-heading" style="text-align: center;">로그인</h2>
        <label for="u_id" class="sr-only">Id</label>
        <input type="text" id="u_id" name="u_id" class="form-control" placeholder="Id" required="" autofocus="">
        <label for="u_pw" class="sr-only">Password</label>
        <input type="password" id="u_pw" name="u_pw" class="form-control" placeholder="Password" required="">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-id"> 아이디 저장
          </label>
        </div>
        <button class="btn btn-lg btn-block" type="submit" style="color:#ffffff; background:#F67280">로그인</button>
      </form>
	<div class="apiLogin">
		<jsp:include page="./loginNaver.jsp"/>
	</div>
    </div>
</div>