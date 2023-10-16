package com.ct.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.domain.PageVO;
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
	public List<TripVO> getboardList(PageVO pvo) throws Exception {
		return tdao.getboardList(pvo);
	}

	@Override
	public TripVO getBorad2(Integer bno) throws Exception {
		return tdao.getBorad2(bno);
	}

	@Override
	public void viewcnt2(Integer bno) throws Exception {
		tdao.viewcnt2(bno);
		
	}

	@Override
	public TripVO modify2GET(Integer bno) throws Exception {
		return tdao.modify2GET(bno);
		
	}

	@Override
	public void modify2POST(Map<String, Object> data) throws Exception {
		tdao.modify2POST(data);
		
	}

	@Override
	public void delete2(Integer bno) throws Exception {
		tdao.delete2(bno);
		
	}

	@Override
	public int count() throws Exception {
		return tdao.count();
	}

	@Override
	public List<TripVO> getboardList(TripVO vo, PageVO pvo) throws Exception {
		return tdao.getboardList(vo, pvo);
	}

	@Override
	public int count(TripVO vo) throws Exception {
		return tdao.count(vo);
	}

	@Override
	public List<TripVO> cityList() throws Exception {
		
		return tdao.cityList();
	}
	
	
	
	

}
