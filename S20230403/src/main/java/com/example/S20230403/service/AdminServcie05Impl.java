package com.example.S20230403.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.S20230403.Dao.AdminDao05;
import com.example.S20230403.model.JooJoin;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServcie05Impl implements AdminServcie05 {
	
	private final AdminDao05 ad;

//	일반 회원 정보 전체 조회

//	사업자 회원 정보 전체 조회

//	1대1 문의 / 불만접수 정보 전체 조회

//	리뷰 정보 전체 조회

//	이벤트 정보 전체 조회

//	공지사항 정보 전체 조회

//	---------------------------------------------------------------
	
//	일반 회원 비활성화
	@Override
	public int delUsers(JooJoin jooJoin) {
		System.out.println("AdminServcie05Impl delUsers start");
		return ad.delUsers(jooJoin);
	}

//	일반 회원 id 검색
	@Override
	public JooJoin getUserById(JooJoin jooJoin) {
		System.out.println("AdminServcie05Impl getUserById start");
		return ad.getUserById(jooJoin);
	}

//	위에서 검색한 id의 status Update
	@Override
	public int updateUser(JooJoin jooJoin) {
		return ad.updateUser(jooJoin);
	}

//	사업자 회원 비활성화
	@Override
	public int delAccom(JooJoin jooJoin) {
		System.out.println("AdminServcie05Impl delAccom start");
		return ad.delAccom(jooJoin);
	}

//	QnA 삭제
	@Override
	public int delQnA(int qna_id) {
		System.out.println("AdminServcie05Impl delQnA start");
		return ad.delQnA(qna_id);
	}

//	Review 삭제
	@Override
	public int delReview(int review_id) {
		System.out.println("AdminServcie05Impl delReview start");
		return ad.delReview(review_id);
	}

//	Event 삭제
	@Override
	public int delEvent(int event_id) {
		System.out.println("AdminServcie05Impl delEvent start");
		return ad.delEvent(event_id);
	}

//	Notice 삭제
	@Override
	public int delNotice(int notice_id) {
		System.out.println("AdminServcie05Impl delNotice start");
		return ad.delNotice(notice_id);
	}

//	---------------------------------------------------------------
	
//	전체 수 조회
	@Override
	public int userTotal() {
		// TODO Auto-generated method stub
		return ad.userTotal();
	}

	@Override
	public int accomTotal() {
		// TODO Auto-generated method stub
		return ad.accomTotal();
	}

	@Override
	public int qnaTotal() {
		// TODO Auto-generated method stub
		return ad.qnaTotal();
	}

	@Override
	public int reviewTotal() {
		// TODO Auto-generated method stub
		return ad.reviewTotal();
	}

	@Override
	public int eventTotal() {
		// TODO Auto-generated method stub
		return ad.eventTotal();
	}

	@Override
	public int noticeTotal() {
		// TODO Auto-generated method stub
		return ad.noticeTotal();
	}

//	전체 리스트 조회
	@Override
	public List<JooJoin> userList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.userList(jooJoin);
	}

	@Override
	public List<JooJoin> accomList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.accomList(jooJoin);
	}

	@Override
	public List<JooJoin> qnaList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.qnaList(jooJoin);
	}

	@Override
	public List<JooJoin> reviewList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.reviewList(jooJoin);
	}

	@Override
	public List<JooJoin> eventList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.eventList(jooJoin);
	}

	@Override
	public List<JooJoin> noticeList(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.noticeList(jooJoin);
	}


	
	
	
}
