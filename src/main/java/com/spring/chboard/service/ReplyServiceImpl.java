package com.spring.chboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.chboard.repository.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;
	
	
	//댓글 작성
	@Override
	public int ReplyWrite(Map<String, Object> map) {
		return replyMapper.ReplyWrite(map);
	}

	//댓글 리스트
	@Override
	public List<Map<String, Object>> ReplyList(int boardNo) {
		return replyMapper.ReplyList(boardNo);
	}

	//댓글 수정
	@Override
	public int ReplyUpdate(Map<String, Object> map) {
		return replyMapper.ReplyUpdate(map);
	}

	
	//댓글 삭제
	@Override
	public int ReplyDelete(int replyNo) {
		return replyMapper.ReplyDelete(replyNo);
	}

}
