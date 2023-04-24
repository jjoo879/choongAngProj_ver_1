package com.example.S20230403.Dao;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.JinJoin;
import com.example.S20230403.model.Room_Img;

public interface ListDao {

	List<Accom> fetchAccomList();

	List<JinJoin> fetchAccomDetailList(String biz_id, String checkIn, String checkOut);
	
	Accom fetchAccomBasicInfo(String biz_id);

	List<Room_Img> fetchRoomImgList(String biz_id);


}
