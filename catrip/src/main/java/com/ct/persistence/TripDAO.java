package com.ct.persistence;

import java.util.List;
import java.util.Map;

import com.ct.domain.TripVO;

public interface TripDAO {
	
	// 글쓰기
	public void regist2POST(TripVO vo) throws Exception;
	
	// 글조회
	public List<TripVO> getboardList() throws Exception;
	
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
	
}
