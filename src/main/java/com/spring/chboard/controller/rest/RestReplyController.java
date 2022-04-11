package com.spring.chboard.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("/replyList")
    public ModelAndView replyList(@RequestParam int boardNo, ModelAndView mav){

//    	List<Map<String, Object>> lis
        // 뷰이름 지정
        mav.setViewName("/reply/reply");
        // 뷰에 전달할 데이터 지정
//        mav.addObject("list", list);
        // replyList.jsp로 포워딩
        return mav;
    }
	
}
