package com.example.S20230403.Dao;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Users;

public interface Dao06 {

	List<NoticeFaq> listnofiFaq(NoticeFaq nf);

	List<NoticeFaq> listnc(NoticeFaq nf);

	List<NoticeFaq> listnt(NoticeFaq nf);

	List<Accom> searchAc(Accom accom);

	List<Users> userlist(Users usid);

	int userNum(Users usid);

	int userTotal();

	int coundTotalUser(Users usid);

	List<Users> listSearchUsers(Users usid);

}
