package com.ct.service;

import java.util.List;

import com.ct.domain.BoardVO;
import com.ct.domain.PageVO;

public interface BoardService {

	
	// 글 목록 조회
	public List<BoardVO> boardList(PageVO pvo) throws Exception;
	
	// 게시판 목록 갯수
	public int count() throws Exception;
	
	// 게시판 목록 조회 (+검색어)
	public List<BoardVO> boardList(BoardVO vo,PageVO pvo) throws Exception;
	
	// 게시판 목록 갯수 (+검색어)
	public int count(BoardVO vo) throws Exception;
	
	// 글쓰기
	public void insertBoard(BoardVO vo, String id) throws Exception;
	
	// 글 상세내용 보기
	public BoardVO read1Board(int b_bno) throws Exception;
	
	// 글 조회수 증가
	public void updateCnt(int b_bno) throws Exception;
	
	// 글 수정하기
	public void updateBoard(BoardVO bvo) throws Exception;
	
	// 글 삭제하기
	public void deleteBoard1(int b_bno) throws Exception;
	
}
