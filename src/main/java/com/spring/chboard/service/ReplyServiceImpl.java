package com.spring.chboard.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.chboard.repository.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;

	@Override
	public int ReplyWrite(Map<String, Object> map) {
		return replyMapper.ReplyWrite(map);
	}

}
