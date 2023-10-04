package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.domain.BoardVO;
import com.ct.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO bdao;

	// 글 목록 조회
	@Override
	public List<BoardVO> boardList() throws Exception {

		return bdao.boardList();
	}

	// 글쓰기
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		
		bdao.insertBoard(vo);
	}
	// 글 상세내용 보기
	@Override
	public BoardVO read1Board(int b_bno) throws Exception {
		
		return bdao.read1Board(b_bno);
	}

	// 글 조회수 증가
	@Override
	public void updateCnt(int b_bno) throws Exception {

		bdao.updateCnt(b_bno);
	}

	// 글 수정하
	@Override
	public void updateBoard(BoardVO bvo) throws Exception {

		bdao.updateBoard(bvo);
	}

	// 글 삭제하기
	@Override
	public void deleteBoard1(int b_bno) throws Exception {

		bdao.deleteBoard1(b_bno);
	}

	
	
	

	
	
	

}
