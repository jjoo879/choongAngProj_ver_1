package com.example.S20230403.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@AllArgsConstructor
public class BizUserDao01 implements SukbakDao01{

	private final SqlSession sqlSession;
	
	@Override
	public void insertCompanyInfo(Accom accom) {
		log.info("비즈다오01 insertCompanyInfo 시작...");
		log.info(accom.toString());
		try {
			sqlSession.insert("insertCompanyInfo", accom);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}

		
	}

	@Override
	public List<Accom> bizCompanyList(String id) {
		log.info("비즈다오01 bizCompanyList 시작...");
		log.info("비즈다오01 id -> {}", id);
		try {
			List<Accom> accomList = sqlSession.selectList("bizCompanyList", id);
			return accomList;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}	
	}
}
