<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${ general != null}">	
<input type="hidden" id="replyWriter" value="${general.userId}"/>
</c:if>
<c:if test="${ admin != null}">	
<input type="hidden" id="replyWriter" value="${admin.userId}"/>
</c:if>

<!-- 로그인한 사용자 -->
<c:if test="${ general != null || admin != null }">	
<div class="replyContent">

	<div class="reply-writeForm" style="display: flex;">
		<textarea id="replyCon" class="replyWriteArea" rows="50" cols="50" onkeyup="enterkey();"></textarea>
		<button id="replyWriteBtn" class="replyWriteBtn">작&nbsp;성</button>
	</div>
	

<div id="listReply"></div>	
<div id="replyUpdateForm" style="display:none"></div>	
	
	
	
</div>
</c:if>



<!-- 로그인안한 사용자 -->
<c:if test="${ general == null && admin == null }">	
	<div class="not_login">
		<span>댓글기능은 <a href="/login">로그인</a>이 필요합니다.</span>		
	</div>
</c:if>


<script src="/js/reply/replyForm.js"></script>