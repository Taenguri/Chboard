package com.spring.chboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.chboard.service.NaverBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NaverBookController {

	private final NaverBookService service;

	@GetMapping("/booksearch")
	public String goBookSearch() {
		return "/NaverBook/bookSearch";
	}

	// 키워드가 있을때도 있고 없을때도있음
	// 있을때는 가져가고 없을때는 안가져가고
	@GetMapping("/booksearch/{keyword}")
	public ModelAndView bookList(@PathVariable String keyword) {
		ModelAndView mav = new ModelAndView();
		
		// 한 페이지에 보여줄 책 개수
		int display = 10;
		
		if (keyword != null) {
			mav.addObject("bookList", service.searchBook(keyword, display, 1));
			mav.addObject("keyword", keyword);
			mav.addObject("display", display);
		}
		
		
		mav.setViewName("/NaverBook/bookSearch");
		
		return mav;
	}
}
