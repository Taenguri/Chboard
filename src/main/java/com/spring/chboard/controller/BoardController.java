package com.spring.chboard.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.chboard.service.BoardService;
import com.spring.chboard.vo.PageCreator;
import com.spring.chboard.vo.SearchVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;

	//메인화면
	@GetMapping("/")
	public String Main() {
		return "main";
	}
	
	// 리스트
	@GetMapping("/list")
	public String list(Model model,SearchVO search) throws ParseException {
		
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setTotalCount(boardService.listCount(search));
		
 		List<Map<String, Object>> list = boardService.list(search);
		log.info("----------------------------");
		log.info("list : {}",list);
		log.info("----------------------------");
 		model.addAttribute("list",list);
 		model.addAttribute("pc",pc	);
 		
		
		return "/board/list";
	}
	
	// 글 등록 페이지
	@GetMapping("/boardWrite")
	public String boardWrite() {
		return "/board/writeForm";
	}
	
	
	// 글 상세 페이지
	@GetMapping("/board/{boardNo}")
	public String content(@PathVariable int boardNo, Model model) {

		log.info("----------------------------");
		log.info("boardNo : {}",boardNo);
		log.info("----------------------------");
		Map<String, Object> content = boardService.content(boardNo);
		model.addAttribute("content",content);
		
		return "board/content";
	}
	
	// 글 수정 페이지
	@GetMapping("/board/{boardNo}/updateForm")
	public String updateForm(@PathVariable int boardNo, Model model) {

		log.info("----------------------------");
		log.info("boardNo : {}",boardNo);
		log.info("----------------------------");
		Map<String, Object> updateForm = boardService.content(boardNo);
		model.addAttribute("updateForm",updateForm);
		
		return "board/updateForm";
	}	
	
	
	
	
}
