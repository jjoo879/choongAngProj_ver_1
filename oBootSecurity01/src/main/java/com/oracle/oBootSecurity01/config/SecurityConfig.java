package com.oracle.oBootSecurity01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//필터 체인 관리 시작 어노테이션
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()
			// /user/** 은 인증 필요 --> 인증만 되면 들어갈수 있음
			.anyRequest()
			.permitAll();
		return http.build();
	}

//	가장 기본적임. 해시 암호화만 사용 가능한 방법
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests()
//		.anyRequest()
//		.permitAll();
////		authorizeRequests가 들어오면 어떤 Request든지 permit 해줘라
////	→ 기본 방식. 다른 조건 주고 싶으면?(위 코드 참조)
//		return http.build();
//	}
	
}
