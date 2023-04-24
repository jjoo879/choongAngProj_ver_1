package com.example.S20230403.model;

import java.util.Date;

import lombok.Data;

@Data
public class JinJoin {
	   //USERS
	   private String user_id;
	   private String auth_level;
	//   private String name;
	//   private String nickname;
	//   private String password;
	//   private String email;
	//   private String phone;
	//   private String telecom;
	//   private String gender;
	//   private String agree;
	//   private String user_status;
	      
	   //ACCOM
	   private String biz_id;
	   private String accom_avail;
	   private String accom_type;
	   private String biz_name;
	   private String addr;
	   private String tel;
	   private int room_count;
	   private String description;
	   private String latitude;
	   private String longitude;
	   private String pool;
	   private String parking;
	   private String cafe;
	   private String restaurant;
	   private String store;
	   private String sauna;
	   private String laundry;
	   private String fitess;
	   
	   //ROOM
	   private int r_id;
	   private String r_name;
	   private int r_price;
	   private int r_capacity;
	   private String r_info;
	   private int r_count;
	   private int bath_count;
	   private String bath;
	   private String wifi;
	   private String ac;
	   private String tv;
	//   private String bed_type;
	   
	   //ROOM_IMG
	   private String r_img;
	   
	   //RESERVATION
	   private int resv_capa;
	   private Date check_in;
	   private Date check_out;
	   private String resv_name;
	   private String resv_phone;
	   
	   //PAYMENT
	   private int pay_id;
	   private Date pay_date;
	   private int pay_amt;
	   private String pay_method;
	   private String pay_status;
	   
	   //SOLDOUT
	   private String resv_date;
	   private String sout_avail;
	   
	   //REVIEW
	   private String room_used;
	   private int rating;
	   private Date review_date;
	   private String review_content;
	   private String del_request;
	   
	   //REVIEW_IMG
	   private int review_img_id;
	   private String review_img;
	   
	   //예약->예약버튼 바꾸려고 담는 필드
	   private int is_reserved;
	   
}
