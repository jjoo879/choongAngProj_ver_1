package com.example.S20230403.service;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Users;

public interface Service06 {

	List<NoticeFaq> listNoticeFaq(NoticeFaq nf);

	List<NoticeFaq> listnc(NoticeFaq nf);

	List<NoticeFaq> listnt(NoticeFaq nf);

	List<Accom> searchAc(Accom accom);

	List<Users> userlist(Users usid);

	int userNum(Users usid);

	int userTotal();

	int conditionUserCount(Users usid);

	List<Users> listSearchUsers(Users usid);

}
