package com.example.S20230403.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.S20230403.model.Accom;
import com.example.S20230403.service.SukbakService01;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequiredArgsConstructor
public class Controller01 {
	
	
	private final SukbakService01 ss01;
	
	@ExceptionHandler
	public String exceptionThrows(Exception e, Model model) {
		
		model.addAttribute("exception", e);
		return "/views/biz/exceptionThrows";
	}
	
	@GetMapping(value = "/biz/bizMain") 
	public String goBizMain(String user_id) {
		log.info("비즈컨트롤러01 goBizMain start...");
		Accom accom = new Accom();
		accom.setUser_id(user_id);
		
		return "/views/bizMain";
	}
	
	// post맨으로 한거, 업체정보 입력
	@PostMapping(value = "/biz/insertCompany")
	public String insertCompany(String user_id, Model model) {
		System.out.println("비즈컨트롤러01 insertCompany start...");
		Accom accom = new Accom();
		accom.setUser_id(user_id);
		ss01.insertCompanyInfo(accom);
		log.info(accom.toString());
		model.addAttribute("accom", accom);
		return "inserCompanyResult";
	}
	
	// 유저 id로 업체정보 불러오기
	@GetMapping(value = "/biz/companyMng")
	public String bizCompanyMng(String user_id) {
		System.out.println("비즈컨트롤01 bizCompanyMng start...");
		System.out.println("String user_id -> "+user_id);
		List<Accom> accomList = ss01.bizCompanyList(user_id);
//		model.addAttribute("accomList", accomList);
		ModelAndView mav = new ModelAndView("/views/biz/bizMain");
		mav.addObject("accomList", accomList);
		return "/biz/companyMng";
	}
	
//	@RequestMapping(value = "/biz/findAddr")
//	public String findAddr(Accom accom, Model model) {
//		System.out.println("BizUserController01 findAddr start...");
//		model.addAttribute("accom", accom);
//		return "/views/BizPage01/findAddr";
//	}
//
//	@GetMapping(value = "/biz/accountMng")
//	public ModelAndView accountMng(String id, Accom accom) {
//		log.info("BizUserController01 accountMng start... "+ id);
//		accom.setUser_id(id);
//		ModelAndView mav = new ModelAndView("/views/bizPage01/accountMng");
//		mav.addObject("accom", accom);
//		return mav;
//	}
	
	
	
}
