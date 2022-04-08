package com.spring.chboard.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.chboard.repository.BoardMapper;
import com.spring.chboard.vo.SearchVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	//글 작성
	@Override
	public int boardWrite(Map<String, Object> map) {
		return boardMapper.boardWrite(map);
	}

	//리스트
	@Override
	public List<Map<String, Object>> list(SearchVO search) throws ParseException {
		List<Map<String, Object>> alist = boardMapper.list(search);
		
		for(Map<String, Object>  target : alist) {
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date to = fm.parse(target.get("regdate").toString());
			long regTime = to.getTime();						//게시물 등록시간
			long nowTime = System.currentTimeMillis();			// 현재시간
			
			if( nowTime - regTime < 60 * 60 * 24 * 1000) {		// 밀리초 계산 
				target.put("newMark", "true");					// 작성후 24시간이내의 게시물은 new뱃지를 붙혀준다.
			}
			
		}
		
		return alist;
	
	}

	//글 상세조회
	@Override
	public Map<String, Object> content(int boardNo) {
		boardMapper.boardHit(boardNo);			// 조회수 증가 처리
		return boardMapper.content(boardNo);
	}

	//글 삭제
	@Override
	public int boardDelete(int boardNo) {
		return boardMapper.boardDelete(boardNo);
	}

	// 글 갯수
	@Override
	public int listCount(SearchVO search) {
		return boardMapper.listCount(search);
	}

	// 글 수정
	@Override
	public int boardUpdate(Map<String, Object> map) {
		return boardMapper.boardUpdate(map);
	}



}
