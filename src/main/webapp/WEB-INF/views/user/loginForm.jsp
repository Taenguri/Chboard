<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center; align-items: center;">

	<div class="form-border">
		<h2>로그인</h2><hr/>
		<div class="form-group" style="width:400px;">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" id="userId" autocomplete="off" onkeyup="enterkey();">
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userPassword">비밀번호</label>
			 <input type="password"class="form-control" id="userPassword" onkeyup="enterkey();">
		</div>
		<button id="login_btn" class="userBtn">로그인</button>
		<button  onclick="location.href='/'" class="userBtn">취소</button>
	</div>

</div>
<script src="/js/user/login.js"></script>
<%@include file="../include/footer.jsp"%>