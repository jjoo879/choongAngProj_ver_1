package com.example.S20230403.service;

import java.util.List;

import com.example.S20230403.model.Accom;

public interface SukbakService01 {

	void 			insertCompanyInfo(Accom accom);

	List<Accom>   	bizCompanyList(String id);
 
}
 