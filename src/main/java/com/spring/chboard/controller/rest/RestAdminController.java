package com.spring.chboard.controller.rest;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.chboard.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestAdminController {

	private final UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	HttpSession session;
	
	
	
	//회원등록 ( 관리자용 )
	@PostMapping("/rest/admin/user")
	public String enroll(@RequestParam Map<String, Object> map) {

		String rawPassword = map.get("userPassword").toString();
		String encPassword = encoder.encode(rawPassword);
		map.put("userPassword", encPassword);
		
		int result = userService.register(map);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
		
		
	}
	
		
	//회원정보수정 ( 관리자용 )
	@PutMapping("/rest/admin/user/{userNo}")
	public String adminUserUpdate(@RequestParam Map<String, Object> map) {
		
		
		String rawPassword = map.get("userPassword").toString();
		String encPassword = encoder.encode(rawPassword);
		map.put("userPassword", encPassword);
		
		int result = userService.userUpdate(map);
		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}		
	}	
	
	//회원정보삭제	( 관리자용 )
	@DeleteMapping("/rest/admin/user/{userNo}")			
	public String adminUserDelete(@PathVariable int userNo) {

		int result = userService.userDelete(userNo);
		
		if (result == 1) {
			
			return "ok";
		
		} else {
			return "no";
		}		
	}
	
	
}
