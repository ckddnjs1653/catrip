package com.ct.persistence;

import java.util.List;

import com.ct.domain.BoardVO;

public interface BoardDAO {

	// 게시판 목록 조회
	public List<BoardVO> boardList() throws Exception;
	
	// 글쓰기
	public void insertBoard(BoardVO vo) throws Exception;
}
