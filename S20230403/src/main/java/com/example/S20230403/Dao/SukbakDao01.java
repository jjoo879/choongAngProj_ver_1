package com.example.S20230403.Dao;

import java.util.List;

import com.example.S20230403.model.Accom;

public interface SukbakDao01 {

	void 			insertCompanyInfo(Accom accom);

	List<Accom> 	bizCompanyList(String id);
 
}
 