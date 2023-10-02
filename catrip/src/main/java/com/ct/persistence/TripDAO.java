package com.ct.persistence;

import java.util.List;

import com.ct.domain.TripVO;

public interface TripDAO {
	
	// 글쓰기
	public void regist2POST(TripVO vo) throws Exception;
	
	// 글조회
	public List<TripVO> getboardList() throws Exception;
		

}
