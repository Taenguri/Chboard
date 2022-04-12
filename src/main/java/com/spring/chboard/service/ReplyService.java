package com.spring.chboard.service;

import java.util.List;
import java.util.Map;


public interface ReplyService {
	
	//댓글 작성
	public int ReplyWrite(Map<String, Object> map);
	
	//댓글 리스트
	public List<Map<String, Object>> ReplyList(int boardNo);
	
	//댓글 수정
	public int ReplyUpdate(Map<String, Object> map);
	
	//댓글 삭제
	public int ReplyDelete(int replyNo);
}
