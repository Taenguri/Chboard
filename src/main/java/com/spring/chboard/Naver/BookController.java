package com.spring.chboard.Naver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.chboard.Naver.BooksResponseDto.Item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@RequiredArgsConstructor
@Controller
@Slf4j
public class BookController {

    private final BookApiClient bookApiClient;

    @GetMapping("/booksearch")
    public String goBookSearch(){
        return "naver/bookSearch";
    }

    
    @GetMapping("/booksearch/{keyword}")
    public String search(@PathVariable String keyword,  BookForm form,Model model) throws JsonProcessingException{
    	
    	BooksResponseDto data1 = bookApiClient.requestBook(form.getKeyword());
    	Item[] arr= data1.getItems();
	
    	
    	// 책 관련 정보
    	List<Map<String, Object>> resultMap = new ArrayList<Map<String,Object>>();
    	for(int i=0; i<arr.length; i++) {
    		
    		Map<String, Object> paramMap = new HashMap<>();
    		paramMap.put("title",arr[i].getTitle());
    		paramMap.put("author",arr[i].getAuthor());
    		paramMap.put("image",arr[i].getImage());
    		paramMap.put("price",arr[i].getPrice());
    		paramMap.put("discount",arr[i].getDiscount());
    		paramMap.put("publisher",arr[i].getPublisher());
    		paramMap.put("description",arr[i].getDescription());
    		paramMap.put("pubdate",arr[i].getPubdate());
    		resultMap.add(paramMap);
    	}
    	model.addAttribute("resultMap",resultMap);
    	
    	
    	
    	log.info("----------------------------");
    	log.info("resultMap : {}" , resultMap);
    	log.info("----------------------------");
    	
    	
    	
    	// 검색 데이터랑 글 개수
    	Map<String, Object> KDMap = new HashMap<>();
    	KDMap.put("keyword", form.getKeyword());
    	KDMap.put("display", data1.getDisplay());
    	model.addAttribute("KDMap", KDMap);
        
    	return "naver/bookSearch";
    }
    

    
}