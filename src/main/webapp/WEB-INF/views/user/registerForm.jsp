<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center; align-items: center;">


	<div class="form-border">
		<h2>회원가입</h2><hr/>
		<div class="form-group" style="width:400px;">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" id="userId" autocomplete="off" onkeyup="enterkey();">
			<span id="id_ok">사용 가능한 아이디입니다.</span>
			<span id="id_no">아이디가 이미 존재합니다.</span>
			<span id="id_null_ck">아이디를 입력해주세요.</span>
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userPassword">비밀번호</label> 
			<input type="password" class="form-control" id="userPassword" onkeyup="enterkey();">
			<span id="pw_null_ck">비밀번호를 입력해주세요.</span>
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userName">이름</label> 
			<input type="text" class="form-control" id="userName" autocomplete="off" onkeyup="enterkey();" />
			<span id="name_null_ck">이름을 입력해주세요.</span>
		</div>
		<label for="verify">
		<input type="checkbox" id="verify" onclick='check(this)'/> 관리자로 가입하기
		</label> 
		<button id="register_btn" class="userBtn">가입</button>
		<button onclick="location.href='/'" class="userBtn">취소</button>
	</div>
	
</div>
<script src="/js/user/registerForm.js"></script>
<%@include file="../include/footer.jsp"%>