package com.example.S20230403.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.S20230403.Dao.ListDao;
import com.example.S20230403.model.Accom;
import com.example.S20230403.model.JinJoin;
import com.example.S20230403.model.Room_Img;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {
	private final ListDao ld;
	
	@Override
	public List<Accom> getAccomList() {
		System.out.println("서비스 accomList 스타트");
		List<Accom> accomLists = ld.fetchAccomList();
		
		return accomLists;
	}

	@Override
	public List<JinJoin> getAccomDetailList(String biz_id, String checkIn, String checkOut) {
		System.out.println("서비스 accomDetail 스타트");
		List<JinJoin> accomDetail = ld.fetchAccomDetailList(biz_id, checkIn, checkOut);
		return accomDetail;
	}

	@Override
	public Accom getAccomBasicInfo(String biz_id) {
		System.out.println("서비스 accomBasicInfo");
		Accom accomBasicInfo = ld.fetchAccomBasicInfo(biz_id);
		return accomBasicInfo;
	}

	@Override
	public List<Room_Img> getRoomImgList(String biz_id) {
		System.out.println("서비스 roomImgList 스타트");
		List<Room_Img> roomImg = ld.fetchRoomImgList(biz_id);
		return roomImg;
	}


}
