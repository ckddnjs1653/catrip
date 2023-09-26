package com.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.persistence.MemberDAO;
import com.ct.persistence.TripDAO;

@Service
public class TripServiceImpl {
	
	@Autowired
	private TripDAO tdao;
	
	

}
