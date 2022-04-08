package com.spring.chboard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.chboard.repository.UserMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UserTest {

	@Autowired
	UserMapper userMapper;
	
	
	@Test
	void insert() {
		Map<String, Object> map = new HashMap<>();
		map.put("userId","erq222");
		map.put("userName","홍길동");
		map.put("userPassword","1234");
		int res = userMapper.register(map);
		assertThat(res).isEqualTo(1);
	}

	

	
}
