package com.example.S20230403.model;

import lombok.Data;

@Data
public class Users {
	private String user_id;
	private String name;
	private String nickname;
	private String password;
	private String email;
	private String phone;
	private String telecom;
	private String gender;
	private String agree;
	private String user_status;
	private String auth_level;

//	Paging
	private int rownum;
	private int rn;
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
}
