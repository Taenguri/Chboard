package com.spring.chboard.controller.rest;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.chboard.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestUserController {

	private final UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	HttpSession session;
	
	
	

	//로그인
	@PostMapping("/rest/login")
	public String login(@RequestParam Map<String, Object> map) {
		
		String InputPw = "";
        String DbPw = "";
        
        Map<String, Object> data = userService.login(map.get("userId").toString());

		
		if(data != null) {						// 데이터 찾기 성공
			InputPw = map.get("userPassword").toString();
			DbPw = data.get("userPassword").toString();
			
			if(true == encoder.matches(InputPw,DbPw)) {
				
				if( (data.get("VERIFY").toString()).equals("관리자") ) {		//관리자 로그인
					session.setAttribute("admin", data);
				}else{
					session.setAttribute("general", data);					// 일반사용자 로그인
				}
				
				return "loginOk";				// 비밀번호 일치
			
			}else {
				return "falsePw";				// 비밀번호 불일치
			}
			
		}else{
			return "noId";						// 아이디 불일치시
		}

		
	}
	
	
	
	
	
	//회원가입
	@PostMapping("/rest/user")
	public String register(@RequestParam Map<String, Object> map) {
		log.info("-------------------------------");
		log.info("map : {}", map);
		log.info("userId : {}", map.get("userId"));
		log.info("userName : {}", map.get("userName"));
		log.info("userPassword : {}", map.get("userPassword"));
		log.info("verify : {}", map.get("verify"));
		log.info("-------------------------------");


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
	
	
	//아이디 중복체크
	@PostMapping("/rest/idChk")
	public String idChk(@RequestBody String userId) {
		log.info("-------------------------------");
		log.info("userId : {}", userId);
		log.info("-------------------------------");
		
		int result = userService.idChk(userId);
		if(result != 0) {
			return "fail";
		}else {
			return "success";
		}
		
	}
		
		
		
		
	//회원정보수정 ( 일반 사용자용 )
	@PutMapping("/rest/user/{userNo}")
	public String userUpdate(@RequestParam Map<String, Object> map) {
		
		
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
	
	//회원정보삭제 ( 일반 사용자용 )
	@DeleteMapping("/rest/user/{userNo}")			
	public String userDelete(@PathVariable int userNo) {

		
		int result = userService.userDelete(userNo);
		if (result == 1) {
			if(session.getAttribute("admin") != null) {
				session.removeAttribute("admin");
			}else {
				session.removeAttribute("general");
			}
			return "ok";
		} else {
			return "no";
		}		
	}
	
	
	
	
}
