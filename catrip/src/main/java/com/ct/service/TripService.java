package com.ct.service;

import java.util.List;
import java.util.Map;

import com.ct.domain.PageVO;
import com.ct.domain.TripVO;

public interface TripService {
	
	// 글쓰기
	public void regist2POST(TripVO vo) throws Exception;
	
	// 글조회(검색어X)
	public List<TripVO> getboardList(PageVO pvo) throws Exception;
	
	// 글조회(검색어O)
	public List<TripVO> getboardList(TripVO vo, PageVO pvo) throws Exception;
	
	// 글 내용보기
	public TripVO getBorad2(Integer bno) throws Exception;
	
	// 조회수
	public void viewcnt2(Integer bno) throws Exception;
	
	// 글 수정하기(GET)
	public TripVO modify2GET(Integer bno) throws Exception;
	
	// 글 수정하기(POST)
	public void modify2POST(Map<String, Object> data) throws Exception;
	
	// 글 삭제하기
	public void delete2(Integer bno) throws Exception;
	
	// 글 개수 조회
	public int count() throws Exception;
	
	// 글 개수 조회(검색용)
	public int count(TripVO vo) throws Exception;
	
	// 도시 이름 불러오기 (글쓰기용)
	public List<TripVO> cityList() throws Exception;

}
