package com.oracle.oBootSecurity02.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	// 스프링 버전이 올라가면서 WebSecurityConfigurerAdapter 에도 deprecate
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()  // /user/** 은 인증 필요 --> 인증만 되면 들어갈수 있음 (인가 필요 없음)
			.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//			manager로 들어오면 ROLE_MANAGER이나 ROLE_ADMIN만 가능하게 하기
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//			admin으로 들어오면 ROLE_ADMIN만 가능하게 하기
		.and()
		    .formLogin()
		    .loginPage("/loginForm")
		    .loginProcessingUrl("/login")
		    .failureUrl("/loginFail")
			.defaultSuccessUrl("/")
		;
		return http.build();
	}
}
