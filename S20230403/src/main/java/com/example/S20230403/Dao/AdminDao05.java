package com.example.S20230403.Dao;

import java.util.List;

import com.example.S20230403.model.JooJoin;

public interface AdminDao05 {
	int 			delUsers(JooJoin jooJoin);
	JooJoin			getUserById(JooJoin jooJoin);
	int				updateUser(JooJoin jooJoin);
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
	List<JooJoin> 	userList(JooJoin user_id);
	List<JooJoin> 	accomList(JooJoin biz_id);
	List<JooJoin> 	qnaList(JooJoin qna_id);
	List<JooJoin> 	reviewList(JooJoin pay_id);
	List<JooJoin> 	eventList(JooJoin event_id);
	List<JooJoin> 	noticeList(JooJoin notice_id);
}
