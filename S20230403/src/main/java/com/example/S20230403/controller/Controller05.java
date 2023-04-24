package com.example.S20230403.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.S20230403.model.JooJoin;
import com.example.S20230403.model.Users;
import com.example.S20230403.service.AdminServcie05;
import com.example.S20230403.service.Paging;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class Controller05 {
	
	private final AdminServcie05 as;

//	관리자 페이지에 일반 회원, 사업자 회원, QnA, 리뷰, 이벤트, 공지사항 테이블 불러오는 로직
	@RequestMapping(value = "/adminPage")
	public String getUsers(JooJoin jooJoin, Model model, String currentPage) {
		
		// 각 테이블마다의 전체 Count
	    int totalUser = as.userTotal();
	    int totalAccom = as.accomTotal();
	    int totalQnA = as.qnaTotal();
	    int totalReview = as.reviewTotal();
	    int totalEvent = as.eventTotal();
	    int totalNotice = as.noticeTotal();

	    // Paging 작업
	    Paging pageUser = new Paging(totalUser, currentPage);
	    Paging pageAccom = new Paging(totalAccom, currentPage);
	    Paging pageQnA = new Paging(totalQnA, currentPage);
	    Paging pageReview = new Paging(totalReview, currentPage);
	    Paging pageEvent = new Paging(totalEvent, currentPage);
	    Paging pageNotice = new Paging(totalNotice, currentPage);

	    // Parameter에 각각 Page만 추가 Setting
	    jooJoin.setStart(pageUser.getStart());
	    jooJoin.setEnd(pageUser.getEnd());
	    List<JooJoin> listUser = as.userList(jooJoin);

	    jooJoin.setStart(pageAccom.getStart());
	    jooJoin.setEnd(pageAccom.getEnd());
	    List<JooJoin> listAccom = as.accomList(jooJoin);

	    jooJoin.setStart(pageQnA.getStart());
	    jooJoin.setEnd(pageQnA.getEnd());
	    List<JooJoin> listQnA = as.qnaList(jooJoin);

	    jooJoin.setStart(pageReview.getStart());
	    jooJoin.setEnd(pageReview.getEnd());
	    List<JooJoin> listReview = as.reviewList(jooJoin);

	    jooJoin.setStart(pageEvent.getStart());
	    jooJoin.setEnd(pageEvent.getEnd());
	    List<JooJoin> listEvent = as.eventList(jooJoin);

	    jooJoin.setStart(pageNotice.getStart());
	    jooJoin.setEnd(pageNotice.getEnd());
	    List<JooJoin> listNotice = as.noticeList(jooJoin);

	    model.addAttribute("totalUser", totalUser);
	    model.addAttribute("listUser", listUser);
	    model.addAttribute("pageUser", pageUser);

	    model.addAttribute("totalAccom", totalAccom);
	    model.addAttribute("listAccom", listAccom);
	    model.addAttribute("pageAccom", pageAccom);

	    model.addAttribute("totalQnA", totalQnA);
	    model.addAttribute("listQnA", listQnA);
	    model.addAttribute("pageQnA", pageQnA);

	    model.addAttribute("totalReview", totalReview);
	    model.addAttribute("listReview", listReview);
	    model.addAttribute("pageReview", pageReview);

	    model.addAttribute("totalEvent", totalEvent);
	    model.addAttribute("listEvent", listEvent);
	    model.addAttribute("pageEvent", pageEvent);

	    model.addAttribute("totalNotice", totalNotice);
	    model.addAttribute("listNotice", listNotice);
	    model.addAttribute("pageNotice", pageNotice);

		return "views/adminPage";
	}
		
//	@RequestMapping(value = "/delUser")
//	public String delUsers(@RequestParam("user_id") String user_id, Model model) {
//		System.out.println("AdminController05 delUsers start");
//		int result = as.delUsers(user_id);
//		return "redirect:adminUser";
//	}
	
//	활성화 되어있는 일반 회원 -> 비활성화 시키는 로직
	@RequestMapping(value = "/delUser")
	public String delUsers(JooJoin jooJoin, Model model) {
		System.out.println("AdminController05 delUsers start");
		System.out.println("AdminController05 delUsers getusersid-> "+jooJoin.getUser_id());
		int result = as.delUsers(jooJoin);
		return "redirect:adminPage";
	}
	
//	비활성화 된 일반 회원 다시 활성화 시키는 로직. 사용하려나?
//	@PostMapping("/delUser")
//	public String toggleUserStatus(JooJoin jooJoin, Model model) {
//		jooJoin = as.getUserById(jooJoin);
//		String newStatus = jooJoin.getUser_status().equals("activated") ? "deactivated" : "activated";
//		jooJoin.setUser_status(newStatus);
//		int result = as.updateUser(jooJoin);
//		return "redirect:adminUser";
//	}
	
//	사용가능(중분류 코드 : 210) 상태인 사업자(숙박업소) -> 사용 불가능 (230)으로 바꾸는 로직
	@RequestMapping(value = "/delAccom")
	public String delAccom(JooJoin jooJoin, Model model) {
		System.out.println("AdminController05 delAccom start");
		System.out.println("AdminController05 delAccom getBiz_id-> "+jooJoin.getBiz_id());
		int result = as.delAccom(jooJoin);
		return "redirect:adminPage";
	}
	
//	QnA 삭제
	@ResponseBody
	@RequestMapping(value = "/delQnA")
	public String delQnA(@RequestParam("qna_id") int qna_id, Model model) {
		System.out.println("AdminController05 delQnA start");
		int result = as.delQnA(qna_id);
		return "redirect:adminPage";
	}
	
//	Review 삭제
	@ResponseBody
	@RequestMapping(value = "/delReview")
	public String delReview(@RequestParam("review_id") int review_id, Model model) {
		System.out.println("AdminController05 delReview start");
		int result = as.delReview(review_id);
		return "redirect:adminPage";
	}
	
//	Event 삭제
	@ResponseBody
	@RequestMapping(value = "/delEvent")
	public String delEvent(@RequestParam("event_id") int event_id, Model model) {
		System.out.println("AdminController05 delEvent start");
		int result = as.delEvent(event_id);
		return "redirect:adminPage";
	}
	
//	Notice 삭제
	@ResponseBody
	@RequestMapping(value = "/delNotice")
	public String delNotice(@RequestParam("notice_id") int notice_id, Model model) {
		System.out.println("AdminController05 delNotice start");
		int result = as.delNotice(notice_id);
		return "redirect:adminPage";
	}
	
	
	
	
}
