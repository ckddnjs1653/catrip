package com.ct.persistence;

import java.util.List;
import java.util.Map;

import com.ct.domain.BoardVO;
import com.ct.domain.PageVO;
import com.ct.domain.PartyVO;

public interface Board2DAO {

	// 게시판 목록 조회
		public List<BoardVO> boardList(PageVO pvo) throws Exception;
		
		// 게시판 목록 갯수
		public int count() throws Exception;
		
		// 게시판 목록 조회 (+검색어)
		public List<BoardVO> boardList(BoardVO vo,PageVO pvo) throws Exception;
		
		// 게시판 목록 갯수(+검색어)
		public int count(BoardVO vo) throws Exception;
		
		// 글쓰기
		public void insertBoard(BoardVO vo, String id) throws Exception;
		
		// 글 상세보기
		public BoardVO read1Board(int b_bno) throws Exception;
		
		// 글 조회수 증가
		public void updateCnt(int b_bno) throws Exception;
		
		// 글 수정하기
		public void updateBoard(BoardVO bvo) throws Exception;
		
		// 글 삭제하기
		public void deleteBoard1(int b_bno) throws Exception;
		
		// 신청하기
		public void apply0(Map<String, Object> data) throws Exception;
		
		// 신청자 목록
		public List<PartyVO> apply(int b_bno);
		
		// 승인
		public void read0Apply(Map<String, Object> data);
		
		// 인원수 증가
		public void boardUpdate(int b_bno);
		
}
