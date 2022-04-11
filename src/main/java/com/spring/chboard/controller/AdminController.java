package com.spring.chboard.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.chboard.service.UserService;
import com.spring.chboard.vo.PageCreator;
import com.spring.chboard.vo.SearchVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {

	private final UserService userService;
	
	@Autowired
	HttpSession session;
	
	
	
	// 회원등록 페이지 ( 관리자용 )
	@GetMapping("/enroll")
	public String enrollForm() {
		return "admin/enrollForm";
	}	
	
	
	// 회원목록페이지 ( 관리자용 )
	@GetMapping("/userList")
	public String userList(SearchVO search,Model model) {
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setTotalCount(userService.userCount(search));
		
		List<Map<String, Object>> userList = userService.userList(search);	
		
		model.addAttribute("userList",userList);
 		model.addAttribute("pc",pc	);
 		
 		
		log.info("----------------------------");
		log.info("userList : {}",userList);
		log.info("----------------------------");		
		
		return "admin/userList";
	}
	
	// 회원 정보 페이지 ( 관리자용 )
	@GetMapping("/admin/user/{userNo}")
	public String adminUserForm(Model model, @PathVariable int userNo) {
		
		Map<String, Object> userDetail = userService.userDetail(userNo);
		log.info("----------------------------");
		log.info("내용 : {}",userDetail);
		log.info("----------------------------");

		model.addAttribute("userdata",userDetail);
		return "/admin/adminUserForm";
	}
	


}
