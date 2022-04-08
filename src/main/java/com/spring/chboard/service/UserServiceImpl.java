package com.spring.chboard.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.chboard.repository.UserMapper;
import com.spring.chboard.vo.SearchVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;


	//회원가입
	@Override
	public int register(Map<String, Object> map) {
		return userMapper.register(map);
	}

	//로그인
	@Override
	public Map<String, Object> login(String userId) {
		return userMapper.login(userId);
	}

	//아이디 중복검사
	@Override
	public int idChk(String userId) {
		return userMapper.idChk(userId);
	}
	
	//회원정보수정
	@Override
	public int userUpdate(Map<String, Object> map) {
		return userMapper.userUpdate(map);
	}

	//회원정보삭제
	@Override
	public int userDelete(int userNo) {
		return userMapper.userDelete(userNo);
	}

	//회원정보조회
	@Override
	public Map<String, Object> userDetail(int userNo) {
		return userMapper.userDetail(userNo);
	}

	//회원목록
	@Override
	public List<Map<String, Object>> userList(SearchVO search) {
		return userMapper.userList(search);
	}
	//총회원수
	@Override
	public int userCount(SearchVO search) {
		return userMapper.userCount(search);
	}




	
}
