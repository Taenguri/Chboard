<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="/css/All.css">
</head>
<body>


<!-- 로그인 하지 않은 사용자 -->
<c:if test="${ general == null && admin == null }">			
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">CHboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/list">게시판</a></li>
      <li><a href="/booksearch" target="_blank" >네이버 책 검색</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/register">회원가입</a></li>
      <li><a href="/login">로그인</a></li>
    </ul>
  </div>
</nav>
</c:if>


<!-- 일반사용자 -->
<c:if test="${ general != null}">	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">CHboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/list">게시판</a></li>
      <li><a href="/booksearch" target="_blank" >네이버 책 검색</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a style="color:white;">등급 : 일반사용자</a></li>
      <li><a href="/user/${general.userNo}">회원정보</a></li>
      <li><a href="/logout">로그아웃</a></li>
    </ul>
  </div>
</nav>
</c:if>


<!-- 관리자 --> 
<c:if test="${ admin != null }">		
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">CHboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/list">게시판</a></li>
      <li><a href="/booksearch" target="_blank" >네이버 책 검색</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a style="color:white;">등급 : 관리자</a></li>
      <li><a href="/userList">회원목록</a></li>      
      <li><a href="/user/${admin.userNo}">회원정보</a></li>
      <li><a href="/logout">로그아웃</a></li>
    </ul>
  </div>
</nav>
</c:if>
 
