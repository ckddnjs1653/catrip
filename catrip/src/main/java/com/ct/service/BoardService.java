package com.ct.service;

import java.util.List;

import com.ct.domain.BoardVO;

public interface BoardService {

	
	// 글 목록 조회
	public List<BoardVO> boardList() throws Exception;
	
	// 글쓰기
	public void insertBoard(BoardVO vo) throws Exception;
	
	// 글 상세내용 보기
	public BoardVO read1Board(int b_bno) throws Exception;
	
	// 글 조회수 증가
	public void updateCnt(int b_bno) throws Exception;
	
	// 글 수정하기
	public void updateBoard(BoardVO bvo) throws Exception;
	
	// 글 삭제하기
	public void deleteBoard1(int b_bno) throws Exception;
	
}
