<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${ general != null}">	
<input type="hidden" id="replyWriter" value="${general.userId}"/>
</c:if>
<c:if test="${ admin != null}">	
<input type="hidden" id="replyWriter" value="${admin.userId}"/>
</c:if>

<div class="replyContent">
	<div class="reply-writeForm" style="display: flex;">
		<textarea id="replyCon" class="replyWriteArea" rows="50" cols="50"></textarea>
		<button id="replyWriteBtn" class="replyWriteBtn">작&nbsp;성</button>
	</div>
	<div class="replyList">
		<div class="replyArea">
			<div class="replyContentArea">
				<div class="replyMain">sadasdasdasdasdasd</div>
				<div class="replySub">sadasdasdasdasdasd</div>
			</div>
			<div class="replyBtnArea">
				<button>수정</button>
				<button>삭제</button>
			</div>
		</div>
		<div class="replyArea">
			<div class="replyContentArea">
				<div class="replyMain">sadasdasdasdasdasd</div>
				<div class="replySub">sadasdasdasdasdasd</div>
			</div>
			<div class="replyBtnArea">
				<button>수정</button>
				<button>삭제</button>
			</div>
		</div>
		<div class="replyArea">
			<div class="replyContentArea">
				<div class="replyMain">sadasdasdasdasdasd</div>
				<div class="replySub">sadasdasdasdasdasd</div>
			</div>
			<div class="replyBtnArea">
				<button>수정</button>
				<button>삭제</button>
			</div>
		</div>		
		
		
	</div>
</div>


<script src="/js/reply/replyForm.js"></script>