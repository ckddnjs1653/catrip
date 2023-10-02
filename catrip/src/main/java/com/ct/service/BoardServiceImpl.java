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

	
	
	

}
