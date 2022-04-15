package com.spring.chboard.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.chboard.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestReplyController {

	private final ReplyService replyService;
	
	
	// 댓글 등록
	@PostMapping("/rest/replyWrite")
	public String register(@RequestParam Map<String, Object> map) {

		int result = replyService.ReplyWrite(map);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
	}
	
	
    // 댓글 목록
    @GetMapping("/replyList/{boardNo}")
    public List<Map<String, Object>> replyList(@PathVariable int boardNo){

    	List<Map<String, Object>> replyList  = replyService.ReplyList(boardNo);
    	System.out.println("--------------------re:" +replyList);
    	return replyList;
    }
    
    
	//글삭제
	@DeleteMapping("/rest/reply/{replyNo}")
	public String delete(@PathVariable int replyNo) {
		
		int result = replyService.ReplyDelete(replyNo);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
		
	}    
    
    
    

	//글수정
	@PutMapping("/rest/reply/{replyNo}")
	public String update(@PathVariable int replyNo, @RequestParam Map<String, Object> map ) {
		
		int result = replyService.ReplyUpdate(map);

		if (result == 1) {
			return "ok";
		} else {
			return "no";
		}
		
	}    
    
    
    
}
