package com.example.S20230403.controller;

import java.util.List;import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Payment;
import com.example.S20230403.model.Users;
import com.example.S20230403.service.Paging;
import com.example.S20230403.service.Service06;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class Controller06 {
	private final Service06 s06;

	@GetMapping("login")
	public String login() {
		return "/views/login";
	}
	@GetMapping("main")
	public String main() {
		return "/views/main";
	}
	@GetMapping("noti")
	public String noti(Model model,NoticeFaq nf) {
		System.out.println("Qna Start Controller");

		List<NoticeFaq> nfqlist =s06.listNoticeFaq(nf);
		List<NoticeFaq> listnc =s06.listnc(nf);
		List<NoticeFaq> listnt =s06.listnt(nf);

		model.addAttribute("nfqlist",nfqlist);
		model.addAttribute("listnc",listnc);
		model.addAttribute("listnt",listnt);

		return "/views/noti";
	}
	@GetMapping("noti2")
	public String noti2() {
		return "/views/noti2";
	}
	@GetMapping("qna")
	public String qna() {
		return "/views/qna";
	}
	@GetMapping("qna2")
	public String qna2() {
		return "/views/qna2";
	}
	@GetMapping("search")
	public String search(Model model,Accom accom,String sech) {
		List<Accom> searchAc =s06.searchAc(accom);
		System.out.println("검색 컨트롤라 시작");
		model.addAttribute("searchAc",searchAc);
		return "/views/search";
	}
	@GetMapping("payment")
	public String payment(Model model,Accom accom,Payment pmt) {

		return "/views/payment";
	}
//	@GetMapping("adminPage")
//	public String adminPage(Model model,String currentPage,Users users) {
//		int userTotal =s06.userTotal();
//		Paging page = new Paging(userTotal, currentPage);
//		System.out.println("컨트롤러 totalemp-> "+userTotal);
//		//	paging 작업
//		//  서비스이긴 하지만 dao작업이 필요없는 서비스는 di를 하지 않고 클래식하게 쓰는게 편함.
//		System.out.println("컨트롤러 시작 끝 page-> "+ page.getStart());
//		System.out.println("컨트롤러 시작 끝 page-> "+ page.getEnd());
//		// parameter emp -> page만 추가 setting
//		users.setStart(page.getStart()); // 시작시 1
//		users.setEnd(page.getEnd());     // 시작시 10
//
//		List<Users> userlist= s06.userlist(users);
//
//		model.addAttribute("userTotal", userTotal);
//		model.addAttribute("userlist",userlist);
//		model.addAttribute("page", page);
//
//		return "/views/adminPage";
//	}
	@RequestMapping("userSeacrh1")
	public String userSeacrh1(Users users, Model model, String currentPage) {
		int totalUser =s06.conditionUserCount(users);
		
		Paging page =new Paging(totalUser, currentPage);
		
		users.setStart(page.getStart());
		users.setEnd(page.getEnd());
		
		List<Users> listSearchUser=s06.listSearchUsers(users);
		
		model.addAttribute("userTotal",totalUser);
		model.addAttribute("page",page);
		model.addAttribute("userlist",listSearchUser);
		return "/views/adminPage";
		
	}
	
}
