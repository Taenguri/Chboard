<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content" style="display:flex; justify-content:center;">


	<div class="form-write">
		<h2>글쓰기</h2><hr/>
		<div class="form-group">
			<label for="title">제목</label> 
			<input type="text" class="form-control" id="title"/>
		</div>
			
		
		<c:if test="${general == null && admin == null}">		
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="writer"/>
		</div>
		</c:if>
		<c:if test="${general != null}">
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="writer" value="${general.userName}" readonly/>
		</div>
		</c:if>		
		
		<c:if test="${admin != null}">
		<div class="form-group">
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="writer" value="${admin.userName}" readonly/>
		</div>
		</c:if>
		
		
				
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea id="content" name="content"></textarea>
		</div>
		<div class="writeForm_btn_area">
		<button class="boardBtn" id="write_btn">작성</button>
		<button class="boardBtn" onclick="location.href='/list'">취소</button>
		</div>		
	</div>


</div>


<script src="/js/board/writeForm.js"></script>
<%@include file="../include/footer.jsp"%>