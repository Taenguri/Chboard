<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center;">


	<div class="form-write">
		<h2>${content.title}</h2><hr/>
		<span id="contentTx">글번호 : ${content.boardNo}</span><span id="contentTx">작성자 : ${content.writer}</span><span id="contentTx">작성일 : <fmt:formatDate value="${content.regdate}" pattern="yyyy-MM-dd"/></span><span id="contentTx">조회수 : ${content.hit}</span>
		<div class="baseline"></div>
			<input type="hidden" id="boardNo" value="${content.boardNo}" />		
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text" class="form-control" id="title" value="${content.title}" readonly/>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="writer" value="${content.writer}" readonly/>
		</div>
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea id="content" readonly>${content.content}</textarea>
		</div>
		<div class="writeForm_btn_area">
		<button class="boardBtn" onclick="location.href='/board/'+${content.boardNo}+'/updateForm'">수정</button>
		<button class="boardBtn" id="delete_btn">삭제</button>
		<button class="boardBtn" onclick="location.href='/list'">돌아가기</button>
		</div>		
	</div>
	

</div>

<!-- 댓글 관련 페이지 -->
<%@include file="../reply/reply.jsp"%>

<script src="/js/board/content.js"></script>
<%@include file="../include/footer.jsp"%>