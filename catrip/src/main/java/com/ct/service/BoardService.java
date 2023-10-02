package com.ct.service;

import java.util.List;

import com.ct.domain.BoardVO;

public interface BoardService {

	
	// 글 목록 조회
	public List<BoardVO> boardList() throws Exception;
	
	// 글쓰기
	public void insertBoard(BoardVO vo) throws Exception;
	
	
}
