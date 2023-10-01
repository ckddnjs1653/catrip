package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.domain.TripVO;
import com.ct.persistence.MemberDAO;
import com.ct.persistence.TripDAO;

@Service
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripDAO tdao;

	@Override
	public void regist2POST(TripVO vo) throws Exception {
		tdao.regist2POST(vo);
	}

	@Override
	public List<TripVO> getboardList() throws Exception {
		return tdao.getboardList();
	}
	
	
	
	

}
