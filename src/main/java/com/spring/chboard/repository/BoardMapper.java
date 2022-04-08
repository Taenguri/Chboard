package com.spring.chboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.chboard.vo.SearchVO;

@Mapper
public interface BoardMapper {

	//글 작성
	public int boardWrite(Map<String, Object> map);
	
	//리스트
	public List<Map<String, Object>> list(SearchVO search);
	
	//글 상세조회
	public Map<String, Object> content(int boardNo);
	
	//글 삭제
	public int boardDelete(int boardNo);
	
	// 조회수 증가
	public void boardHit(int boardNo);
	
	// 글 갯수
	public int listCount(SearchVO search);
	
	// 글 수정
	public int boardUpdate(Map<String, Object> map);
	
	
}
