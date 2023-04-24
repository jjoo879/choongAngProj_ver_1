package com.example.S20230403.service;

import java.util.List;

import com.example.S20230403.model.JooJoin;

public interface AdminServcie05 {
	int 			delUsers(JooJoin jooJoin);
	JooJoin 		getUserById(JooJoin jooJoin);
	int 			updateUser(JooJoin jooJoin);
	int 			delAccom(JooJoin jooJoin);
	int				delQnA(int qna_id);
	int				delReview(int review_id);
	int				delEvent(int event_id);
	int				delNotice(int notice_id);
	int 			userTotal();
	int 			accomTotal();
	int 			qnaTotal();
	int 			reviewTotal();
	int 			eventTotal();
	int 			noticeTotal();
	List<JooJoin> 	userList(JooJoin jooJoin);
	List<JooJoin> 	accomList(JooJoin jooJoin);
	List<JooJoin> 	qnaList(JooJoin jooJoin);
	List<JooJoin> 	reviewList(JooJoin jooJoin);
	List<JooJoin> 	eventList(JooJoin jooJoin);
	List<JooJoin> 	noticeList(JooJoin jooJoin);
}
