<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center;">


	<div class="form-write">
		<h2>글수정</h2><hr/>
		<div class="form-group">
			<label for="boardNo">글번호</label> 
			<input type="text" class="form-control" value="${updateForm.boardNo}" id="boardNo" readonly/>
		</div>
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text" class="form-control" value="${updateForm.title}" id="title"/>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" value="${updateForm.writer}"  id="writer"/>
		</div>
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea id="content" name="content" >${updateForm.content}</textarea>
		</div>
		<div class="writeForm_btn_area">
		<button class="boardBtn" id="update_btn">수정완료</button>
		<button class="boardBtn" onclick="location.href='/board/'+${updateForm.boardNo}">취소</button>
		</div>		
	</div>


</div>
<script src="/js/board/updateForm.js"></script>
<%@include file="../include/footer.jsp"%>