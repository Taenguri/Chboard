package com.spring.chboard.controller.rest;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.chboard.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestBoardController {

	private final BoardService boardService;

	// 글 등록
	@PostMapping("/rest/board")
	public String register(@RequestParam Map<String, Object> map) {

		int result = boardService.boardWrite(map);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
	}
	
	
	
	//글삭제
	@DeleteMapping("/rest/board/{boardNo}")
	public String delete(@PathVariable int boardNo) {
		log.info("-------------------------------");
		log.info("boardNo : {}", boardNo);
		log.info("-------------------------------");
		
		int result = boardService.boardDelete(boardNo);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
		
	}
	
	//글수정
	@PutMapping("/rest/board/{boardNo}")
	public String update(@PathVariable int boardNo, @RequestParam Map<String, Object> map ) {
		
		int result = boardService.boardUpdate(map);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
		
	}	
	
	
	
}
