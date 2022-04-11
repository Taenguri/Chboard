package com.spring.chboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.chboard.vo.SearchVO;

@Mapper
public interface ReplyMapper {

	//댓글 작성
	public int ReplyWrite(Map<String, Object> map);
	
	
	
}
