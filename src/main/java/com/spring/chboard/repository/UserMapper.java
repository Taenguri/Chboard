package com.spring.chboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.chboard.vo.SearchVO;

@Mapper
public interface UserMapper {

	
	//회원가입
	public int register(Map<String, Object> map);
	
	//로그인
	public Map<String, Object> login(String userId);
	
	//아이디 중복검사
	public int idChk(String userId);
	
	//회원정보수정
	public int userUpdate(Map<String, Object> map);
	
	//회원정보삭제
	public int userDelete(int userNo);
	
	//회원정보조회
	public Map<String, Object> userDetail(int userNo);
	
	//회원목록
	public List<Map<String, Object>> userList(SearchVO search);
	
	//총회원수
	public int userCount(SearchVO search);
} 
