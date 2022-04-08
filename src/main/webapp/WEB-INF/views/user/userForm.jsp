<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center; align-items: center;">


	<div class="form-border">
		<h2>회원 정보</h2><hr/>
		<div class="form-group" style="width:400px;">
			<label for="userNo">회원번호</label> 
			<input type="text" class="form-control" id="userNo" autocomplete="off" value="${userdata.userNo}" readonly> 
		</div>
		<div class="form-group" style="width:400px;">
			<label for="verify">회원등급</label> 
			<input type="text" class="form-control" id="verify" autocomplete="off" value="${userdata.VERIFY}" readonly>
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" id="userId" autocomplete="off" value="${userdata.userId}" onFocus="this.value=''; return true;" onkeyup="enterkey();">
			<span id="id_ok">사용 가능한 아이디입니다.</span>
			<span id="id_no">아이디가 이미 존재합니다.</span>
			<span id="id_null_ck">아이디를 입력해주세요.</span>
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userPassword">비밀번호</label> 
			<input type="password" class="form-control" id="userPassword"  onkeyup="enterkey();">
			<span id="pw_null_ck">비밀번호를 입력해주세요.</span>
		</div>
		<div class="form-group" style="width:400px;">
			<label for="userName">이름</label> 
			<input type="text" class="form-control" id="userName" autocomplete="off" value="${userdata.userName}" onFocus="this.value=''; return true;" onkeyup="enterkey();">
			<span id="name_null_ck">이름을 입력해주세요.</span>
		</div>		
		<button id="userUpdate_btn" class="userBtn">수정</button>
		<button id="userdelete_btn" class="userBtn">삭제</button>
		<button onclick="location.href='/'"class="userBtn">돌아가기</button>
	</div>

</div>
<script src="/js/user/userForm.js"></script>
<%@include file="../include/footer.jsp"%>