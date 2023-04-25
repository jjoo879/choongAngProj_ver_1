package com.oracle.oBootSecurity01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.oBootSecurity01.model.User;
import com.oracle.oBootSecurity01.service.SecurityService;

@Controller
public class SecurityController {
	@Autowired
	private SecurityService securityServiceImpl;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("SecurityController loginForm 진행...");
		return "loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		System.out.println("SecurityController joinForm 진행...");
		return "joinForm";
	}

	@ResponseBody
	@GetMapping("/login")
	public String login() {
		System.out.println("login 페이지 start...");
		return "login 페이지 입니다.";
	}
	
	@ResponseBody
	@GetMapping("/admin")
	public String admin() {
		System.out.println("admin 페이지 start...");
		return "admin 페이지 입니다.";
	}
	
	@ResponseBody
	@GetMapping("/user/1")
	public String user1() {
		return "user1 페이지 입니다.";
	}
	
	@ResponseBody
	@GetMapping("/user/2")
	public String user2() {
		return "user2 페이지 입니다.";
	}
	
	@ResponseBody
	@GetMapping("/manager/1")
	public String manager1() {
		return "manager1 페이지 입니다.";
	}

	@ResponseBody
	@GetMapping("/manager/2")
	public String manager2() {
		return "manager2 페이지 입니다.";
	}
	
	@PostMapping("/joingProc")
	public String joingProc(User user) {
		System.out.println("회원가입 진행 : "+user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		securityServiceImpl.save(user);
//		userRepository.save(user);
		return "redirect:/loginForm";
	}
	
	
	
}
