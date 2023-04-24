package com.example.S20230403.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.JinJoin;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.service.ListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Controller04 {
	private final ListService ls;
	
	@GetMapping("/hotelList")
	public String hoteList(Model model) {
		System.out.println("컨트롤러04 hotelList 스타트");
		List<Accom> accomList = ls.getAccomList();
		model.addAttribute("accomList",accomList);
		
		return "views/hotelList";
	}
	
	@GetMapping("/accomDetail")
	public String accomDetail(String biz_id, String checkIn, String checkOut, Model model) {
		
		// 객실안내/예약 리스트에 날짜예약 체크해서 리스트 다 가져오되, 날짜에 걸린 객실만 is_reserved 로 1 받아 view에서 예약불가버튼 변경예정
		List<JinJoin> accomDetail = ls.getAccomDetailList(biz_id, checkIn, checkOut);
		
		//메인에 이름,주소만 가져오는 객체 (accomDetail[0].biz_name 이런식으로 첫번째 요소만 가져올 수있는데 나중엔 메모리 영향줘서 그냥 따로뺌
		Accom accomBasicInfo = ls.getAccomBasicInfo(biz_id);
		
		//상세숙소페이지에 이미지 가져오기
		List<Room_Img> roomImg = ls.getRoomImgList(biz_id);
		
		
		model.addAttribute("accomDetail",accomDetail);
		model.addAttribute("accomBasicInfo",accomBasicInfo);
		model.addAttribute("roomImg",roomImg);
		
		return "views/accomDetail";
	}
	
	@ResponseBody
	@GetMapping("/accomDetail1")
	public List<JinJoin> accomDetail1(String biz_id, String checkIn, String checkOut) {
		
		// 객실안내/예약 리스트에 날짜예약 체크해서 리스트 다 가져오되, 날짜에 걸린 객실만 is_reserved 로 1 받아 view에서 예약불가버튼 변경예정
		List<JinJoin> accomDetail = ls.getAccomDetailList(biz_id, checkIn, checkOut);
		
		return accomDetail;
	}
	
}
