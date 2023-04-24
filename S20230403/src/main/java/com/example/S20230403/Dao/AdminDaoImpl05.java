package com.example.S20230403.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.JooJoin;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminDaoImpl05 implements AdminDao05 {
	
	private final SqlSession session;

	@Override
	public int delUsers(JooJoin jooJoin) {
		return session.update("adminDeleteUser", jooJoin);
	}

	@Override
	public JooJoin getUserById(JooJoin jooJoin) {
		return session.selectOne("adminGetUserById", jooJoin);
	}

	@Override
	public int updateUser(JooJoin jooJoin) {
		 return session.update("adminRevokeUser", jooJoin);
	}

	@Override
	public int delAccom(JooJoin jooJoin) {
		return session.update("adminDeleteAccom", jooJoin);
	}

//	-----------------------------------------------------------
	
	@Override
	public int delQnA(int qna_id) {
		return session.delete("adminDeleteQnA", qna_id);
	}

	@Override
	public int delReview(int review_id) {
		return session.delete("adminDeleteReview", review_id);
	}

	@Override
	public int delEvent(int event_id) {
		return session.delete("adminDeleteEvent", event_id);
	}

	@Override
	public int delNotice(int notice_id) {
		return session.delete("adminDeleteNotice", notice_id);
	}

//	------------------------------------------------------------
	
	@Override
	public int userTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jhuserTotal");
	}

	@Override
	public int accomTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jhaccomTotal");
	}

	@Override
	public int qnaTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jhqnaTotal");
	}

	@Override
	public int reviewTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jhreviewTotal");
	}

	@Override
	public int eventTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jheventTotal");
	}

	@Override
	public int noticeTotal() {
		// TODO Auto-generated method stub
		return session.selectOne("jhnoticeTotal");
	}

	@Override
	public List<JooJoin> userList(JooJoin user_id) {
		// jhUserlist
		return session.selectList("jhUserlist", user_id);
	}

	@Override
	public List<JooJoin> accomList(JooJoin biz_id) {
		// TODO Auto-generated method stub
		return session.selectList("jhAccomlist", biz_id);
	}

	@Override
	public List<JooJoin> qnaList(JooJoin qna_id) {
		// TODO Auto-generated method stub
		return session.selectList("jhQnalist", qna_id);
	}

	@Override
	public List<JooJoin> reviewList(JooJoin pay_id) {
		// TODO Auto-generated method stub
		return session.selectList("jhReviewlist", pay_id);
	}

	@Override
	public List<JooJoin> eventList(JooJoin event_id) {
		// TODO Auto-generated method stub
		return session.selectList("jhEventlist", event_id);
	}

	@Override
	public List<JooJoin> noticeList(JooJoin notice_id) {
		// TODO Auto-generated method stub
		return session.selectList("jhNoticelist", notice_id);
	}


}
