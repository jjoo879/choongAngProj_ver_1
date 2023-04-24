package com.example.S20230403.model;

import java.util.Date;

import lombok.Data;

@Data
public class Review {
	private int pay_id;
	private String room_used;
	private int rating;
	private Date review_date;
	private String review_content;
}
