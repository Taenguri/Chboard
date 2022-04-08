<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="content">
	<div class="container">
		<h2>회원목록</h2><hr/>
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="col-md-1 text-center">회원번호</th>
					<th class="col-md-7">회원아이디</th>
					<th class="col-md-2 text-center">회원이름</th>
					<th class="col-md-2 text-center">회원등급</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${userList}" var="userList">
				<tr>
					<td class="col-md-1 text-center">${userList.userNo}</td>
					<c:if test="${userList.userNo == admin.userNo }">
					<td class="col-md-7">
						<a href="/user/${userList.userNo}" id="a">${userList.userId}</a>
					</td>
					</c:if>
					<c:if test="${userList.userNo != admin.userNo }">
					<td class="col-md-7">
						<a href="/admin/user/${userList.userNo}" id="a">${userList.userId}</a>
					</td>
					</c:if>
					<td class="col-md-2 text-center">${userList.userName}</td>
					<td class="col-md-2 text-center">${userList.VERIFY}</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
		<div class="list_btn_area">
		<button class="boardBtn" onclick="location.href='/enroll'">회원등록</button>
		</div>
		
		<!-- 페이징 -->
		<div style="display:flex; justify-content: center;">
		  <ul class="pagination">
		    <c:if test="${pc.prev}">
		    	<li><a href="list${pc.makeURI(pc.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pc.startPage}" end="${pc.endPage}" var="idx">
				<li <c:out value="${pc.paging.page == idx ? 'class=active' : ''}" />><a href="userList${pc.makeURI(idx)}">${idx}</a></li>
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
                         <option value="userNo" ${param.condition == 'userNo' ? 'selected' : ''}>회원번호</option>
                         <option value="userId" ${param.condition == 'userId' ? 'selected' : ''}>아이디</option>
                         <option value="userName" ${param.condition == 'userName' ? 'selected' : ''}>회원이름</option>
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
<script src="/js/admin/userList.js"></script>
<%@include file="../include/footer.jsp"%>