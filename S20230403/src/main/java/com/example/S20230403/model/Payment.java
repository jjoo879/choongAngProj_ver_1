package com.example.S20230403.model;

import java.util.Date;

import lombok.Data;

@Data
public class Payment {
	private int    pay_id;
	private String biz_id;
	private int    r_id;
	private String user_id;
	private Date   pay_date;
	private String pay_method;
	private String pay_status;


	// 조인용
	private String resv_name;
	private String phone;
	private int    r_price;
	private String r_name;
	private Date   check_in;
	private Date   check_out;
	private int    pay_amt;


}
