<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서 검색</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/33.0.0/classic/ckeditor.js"></script>
    <link rel="stylesheet" href="/css/Naver.css"/>
</head>
<body>
    <nav class="naver_nav">
            <a href="/booksearch"><img src="/images/naver.png" style="width:150px;height:50px;"></a>
	            <div class="search_area">
		                <span class='green_window'>
		                    <input type='text' class='input_text' name="keyword" id="keyword" placeholder="검색어를 입력하세요" autocomplete="off" onkeyup="enterkey();" />
		                </span>
		                <button id="booksearch" class='sch_smit'>검색</button>
	            </div>

      </nav>
      <div class="deco">
          <ul>
              <li>책 홈 <span>|</span> </li>
              <li>베스트셀러 <span>|</span> </li>
              <li>지서재</li>
          </ul>
      </div>
      <div class="search_result">
        <span><b>${KDMap.keyword}</b> &nbsp; 에 대한 검색결과</span>
      </div>
    <div class="inner">
        <div class="count">
            <span id="count_main">책 검색</span><span id="count_sub"> ${KDMap.display}건</span>
        </div>
	        <c:forEach var="resultMap" items="${resultMap}">
		        <div class="bookList">
		            <div class="book_image">
		                <img src="${resultMap.image}" style="height: 200px; width: 100%;"/>
		            </div>
		            <div class="bookContent">
		                <div class="bookTitle">
		                    <span>${resultMap.title}</span>
		                </div>
		                <div class="pub">
		                    <span>${resultMap.author}</span> <span id="bar">|</span> <span>${resultMap.publisher}</span>  <span id="bar">|</span> <span><fmt:formatDate value="${resultMap.pubdate}" pattern="yyyy.MM.dd"/></span>
		                </div>
		                <div class="price">
		                    <span id="origin">${resultMap.price}원</span> &nbsp; → &nbsp;<span id="discount">${resultMap.discount}원</span>
		                </div>
		                <div class="intro">
		                    <span>${resultMap.description}</span>
		                </div>
		            </div>
		
		        </div>
	        </c:forEach>
    </div>
    <div class="endline"></div>
<script src="/js/naver/naver.js"></script>
</body>
</html>