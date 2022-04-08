package com.spring.chboard.controller;



import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.chboard.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;
	
	@Autowired
	HttpSession session;
	
	// 로그인 페이지
	@GetMapping("/login")
	public String loginForm() {
		return "user/loginForm";
	}
	
	
	// 회원가입 페이지
	@GetMapping("/register")
	public String registerForm() {
		return "user/registerForm";
	}	
	
	
	// 회원정보페이지 ( 일반 사용자용 )
	@GetMapping("/user/{userNo}")
	public String userForm(Model model, @PathVariable int userNo) {
		
		Map<String, Object> userDetail = userService.userDetail(userNo);
		log.info("----------------------------");
		log.info("내용 : {}",userDetail);
		log.info("----------------------------");

		model.addAttribute("userdata",userDetail);
		return "user/userForm";
	}
	

	


}
