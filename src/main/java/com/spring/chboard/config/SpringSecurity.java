package com.spring.chboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
        .cors().disable()		//cors방지
        .csrf().disable()		//csrf방지
        .formLogin().disable()	//기본 로그인 페이지 없애기
        .headers().frameOptions().disable()
        .and()
        .logout()
        .logoutSuccessUrl("/") // 로그아웃 성공시 리다이렉트 주소
        .invalidateHttpSession(true); // 로그아웃 이후 세션 전체 삭제 여부
        
    }

    @Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

}