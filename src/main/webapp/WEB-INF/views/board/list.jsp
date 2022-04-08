<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content">
	<div class="container">
		<h2>CHboard</h2><hr/>
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="col-md-1 text-center">글번호</th>
					<th class="col-md-6">제목</th>
					<th class="col-md-2 text-center">작성자</th>
					<th class="col-md-2 text-center">날짜</th>
					<th class="col-md-1 text-center">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td class="col-md-1 text-center">${list.boardNo}</td>
					<td class="col-md-6">
						<a href="/board/${list.boardNo}" id="a">${list.title}</a><c:if test="${list.newMark == true}"><span class="label label-danger" id="newMarkBadge">New</span></c:if>
					</td>
					<td class="col-md-2 text-center">${list.writer}</td>
					<td class="col-md-2 text-center"><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
					<td class="col-md-1 text-center">${list.hit}</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
		<div class="list_btn_area">
		<button class="boardBtn" onclick="location.href='/boardWrite'">글쓰기</button>
		</div>
		
		<!-- 페이징 -->
		<div style="display:flex; justify-content: center;">
		  <ul class="pagination">
		    <c:if test="${pc.prev}">
		    	<li><a href="list${pc.makeURI(pc.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pc.startPage}" end="${pc.endPage}" var="idx">
				<li <c:out value="${pc.paging.page == idx ? 'class=active' : ''}" />><a href="list${pc.makeURI(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pc.next}">
		    	<li><a href="list${pc.makeURI(pc.endPage + 1)}">다음</a></li>
		    </c:if> 
		  </ul>
		</div>		
		
		
		<!-- 검색 -->
		<div class="search row">
		 		<div class="col-md-2">
                  	 <select id="condition"  name="condition" class="form-control" >    
                         <option value="title" ${param.condition == 'title' ? 'selected' : ''}>제목</option>
                         <option value="content" ${param.condition == 'content' ? 'selected' : ''}>내용</option>
                         <option value="writer" ${param.condition == 'writer' ? 'selected' : ''}>작성자</option>
                         <option value="titleContent" ${param.condition == 'titleContent' ? 'selected' : ''}>제목+내용</option>
                     </select>
                </div>
                <div class="col-md-10">
                     <div class="input-group">
		   				 <input class="form-control" type="text" name="keyword" id="keywordInput" value="${param.keyword}" onkeyup="enterkey();" autocomplete="off"/>
		    			<span class="input-group-btn"><button id="searchBtn" type="button" class="btn btn-default btn_search">검색</button></span>
					</div>	
				</div>
		</div>	
				 					
				 							
		
	</div>
</div>
<script src="/js/board/list.js"></script>
<%@include file="../include/footer.jsp"%>