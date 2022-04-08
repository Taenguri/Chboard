package com.spring.chboard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.chboard.repository.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardTest {
	@Autowired
	BoardMapper boardMapper;
	
	
	@Test
	void boardwrite() {
		Map<String, Object> map = new HashMap<>();
		map.put("title","안녕");
		map.put("content","오늘은 뭘 먹을까요");
		map.put("writer","철수");
		int res = boardMapper.boardWrite(map);
		assertThat(res).isEqualTo(1);
	}


	@Test
	void boardDelete() {
		boardMapper.boardDelete(8);
	}
}
