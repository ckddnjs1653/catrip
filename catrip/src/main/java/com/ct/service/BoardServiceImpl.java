package com.ct.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.domain.BoardVO;
import com.ct.domain.PageVO;
import com.ct.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO bdao;
	
	

	// 글 목록 조회
	@Override
	public List<BoardVO> boardList(PageVO pvo) throws Exception {

		logger.debug("검색어xxxxxxxxxxxxxxxxxxxxxxx");
		return bdao.boardList(pvo);
	}
	
	// 글 목록 갯수
	@Override
	public int count() throws Exception {
		logger.debug("검색어xxxxxxxxxxxxxxxxxxxxxxx");
		return bdao.count();
	}
	
	// 글 목록 조회(+검색어)
	@Override
	public List<BoardVO> boardList(BoardVO vo ,PageVO pvo) throws Exception {
		
		logger.debug("검색ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ" +vo.getSubject());
		return bdao.boardList(vo,pvo);
	}

	// 글 목록 갯수(+검색어)
	@Override
	public int count(BoardVO vo) throws Exception {
		
		logger.debug("검색ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ" );
		return bdao.count(vo);
	}

	// 글쓰기
	@Override
	public void insertBoard(BoardVO vo, String id) throws Exception {
		
		bdao.insertBoard(vo, id);
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

	// 글 수정하기
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
