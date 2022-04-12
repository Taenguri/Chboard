package com.spring.chboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {

	//댓글 작성
	public int ReplyWrite(Map<String, Object> map);
	
	//댓글 리스트
	public List<Map<String, Object>> ReplyList(int boardNo);
	
	//댓글 수정
	public int ReplyUpdate(Map<String, Object> map);
	
	//댓글 수정
	public int ReplyDelete(int replyNo);
	
}
