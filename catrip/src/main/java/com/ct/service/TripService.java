package com.ct.service;

import java.util.List;

import com.ct.domain.TripVO;

public interface TripService {
	
	// 글쓰기
	public void regist2POST(TripVO vo) throws Exception;
	
	// 글조회
	public List<TripVO> getboardList() throws Exception;
	
	// 글 내용보기
	public TripVO getBorad2(Integer bno) throws Exception;
	

}
