package com.example.S20230403.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.S20230403.Dao.Dao06;
import com.example.S20230403.model.Accom;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceImpl06 implements Service06 {
	private final Dao06 d06;

	@Override
	public List<NoticeFaq> listNoticeFaq(NoticeFaq nf) {
		List<NoticeFaq> nfqlist =d06.listnofiFaq(nf);

		return nfqlist;
	}

	@Override
	public List<NoticeFaq> listnc(NoticeFaq nf) {
		List<NoticeFaq> listnc =d06.listnc(nf);

		return listnc;
	}

	@Override
	public List<NoticeFaq> listnt(NoticeFaq nf) {
		List<NoticeFaq> listnt =d06.listnt(nf);

		return listnt;
	}

	@Override
	public List<Accom> searchAc(Accom accom) {
		List<Accom> searchAc =d06.searchAc(accom);
		System.out.println("서비스 임플 시작");

		return searchAc;
	}

	@Override
	public List<Users> userlist(Users users) {
		List<Users> userlist =d06.userlist(users);
		System.out.println(" 서비스 임플에서 유저 찾기 시작!");
		return userlist;
	}

	@Override
	public int userNum(Users users) {
		int userNum =d06.userNum(users);
		return userNum;
	}


	@Override
	public int userTotal() {
		int  userTotal=d06.userTotal();

		return userTotal;
	}

	@Override
	public int conditionUserCount(Users users) {
		int condUserCnt =d06.coundTotalUser(users);
		System.out.println(" 서비스 임플에서 유저 찾기 시작!");
		
		return condUserCnt;
	}

	@Override
	public List<Users> listSearchUsers(Users users) {
		
		List<Users> listSearchUsers =d06.listSearchUsers(users);
		System.out.println(" 서비스 임플에서 유저 찾기 시작!");

		return listSearchUsers;
	}
}
