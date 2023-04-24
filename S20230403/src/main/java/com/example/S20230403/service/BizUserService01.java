package com.example.S20230403.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.S20230403.Dao.SukbakDao01;
import com.example.S20230403.model.Accom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BizUserService01 implements SukbakService01{
	private final SukbakDao01 sd01; 
	
	/*
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> HandlerExceptionResolver(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("Error message: " + e.getMessage());
	}
	*/
	
	@Override
	public void insertCompanyInfo(Accom accom) {
		log.info("비즈서비스01 insertCompanyInfo 시작...");
		sd01.insertCompanyInfo(accom);
	}

	@Override
	public List<Accom> bizCompanyList(String id) {
		log.info("비즈서비스01 bizCompanyList 시작...");
		List<Accom> accomList =  sd01.bizCompanyList(id);
		System.out.println("accomList -> "+accomList.toString());
		return accomList;
	}
	
}
