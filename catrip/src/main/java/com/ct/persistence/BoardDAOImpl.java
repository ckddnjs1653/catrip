package com.ct.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ct.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession SqlSession;
	
	private static final String NAMESPACE="com.ct.mapper.tripMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	
	// 게시판 글 목록 조회
	@Override
	public List<BoardVO> boardList() throws Exception {

		
		return SqlSession.selectList(NAMESPACE + ".boardList");
	}
	
	// 글쓰기
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		
		int result = SqlSession.insert(NAMESPACE + ".regist1", vo);
		
		if(result != 0) {
			logger.debug("글쓰기 완료");
		}
	}


	
	
	
	
	
}
