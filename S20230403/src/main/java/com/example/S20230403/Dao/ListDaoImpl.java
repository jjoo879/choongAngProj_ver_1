package com.example.S20230403.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.JinJoin;
import com.example.S20230403.model.Room_Img;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ListDaoImpl implements ListDao {
	private final SqlSessionTemplate session;

	@Override
	public List<Accom> fetchAccomList() {
		System.out.println("다오 fetchAccomList 스타트");
		List<Accom> accomList = session.selectList("jsAccomList");
		
		return accomList;
	}

	@Override
	public List<JinJoin> fetchAccomDetailList(String biz_id, String checkIn, String checkOut) {
		System.out.println("다오 fetchAccomDetailList 스타트");
		
		Map<String, Object> reservedCheck = new HashMap<>();
		reservedCheck.put("biz_id", biz_id);
		reservedCheck.put("checkIn", checkIn);
		reservedCheck.put("checkOut", checkOut);
		
		List<JinJoin> accomDetail = session.selectList("jsAccomDetailList", reservedCheck);
		return accomDetail;
	}

	@Override
	public Accom fetchAccomBasicInfo(String biz_id) {
		System.out.println("다오 fetchAccomBasicInfo 스타트");
		Accom accomBasicInfo = session.selectOne("jsAccomBasicInfo", biz_id);
		return accomBasicInfo;
	}

	@Override
	public List<Room_Img> fetchRoomImgList(String biz_id) {
		System.out.println("다오 fetchRoomImgList 스타트");
		List<Room_Img> roomImg = session.selectList("jsRoomImgList", biz_id);
		return roomImg;
	}

}
