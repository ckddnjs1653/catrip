package com.ct.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ct.domain.BoardVO;
import com.ct.domain.PageVO;
import com.ct.domain.TripVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession SqlSession;
	
	private static final String NAMESPACE="com.ct.mapper.tripMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	
	// 게시판 글 목록 조회
	@Override
	public List<BoardVO> boardList(PageVO pvo) throws Exception {

		logger.debug("검색어xxxxxxxxxxxxxx");
		return SqlSession.selectList(NAMESPACE + ".boardList",pvo);
	}
	
	//게시판 목록 갯수
		@Override
		public int count() throws Exception {
			
			logger.debug("검색어xxxxxxxxxxxxxx");
			return SqlSession.selectOne(NAMESPACE+".count");
		}
	
	// 게시판 글 목록 조회 (+검색어)
	@Override
	public List<BoardVO> boardList(BoardVO vo ,PageVO pvo) throws Exception {
		logger.debug("ㅇㅇㅇㅇㅇ1 " + pvo.getStartPage());
		logger.debug("ㅇㅇㅇㅇㅇ2 " + pvo.getPageSize());
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("subject", vo.getSubject());
		data.put("startPage", pvo.getStartPage());
		data.put("pageSize", pvo.getPageSize());
		logger.debug("검색어ooooooooooo" + vo.getSubject());
		return SqlSession.selectList(NAMESPACE+".boardSearch" ,data);
	}
	
	//게시판 목록 갯수(+검색어)
		@Override
		public int count(BoardVO vo) throws Exception {
			
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("subject", vo.getSubject());
			logger.debug("검색어ooooooooooo" + vo.getSubject());
			return SqlSession.selectOne(NAMESPACE+".count1",data);
		}
	
	// 글쓰기
	@Override
	public void insertBoard(BoardVO vo, String id) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		data.put("vo", vo);
		
		
		int result = SqlSession.insert(NAMESPACE + ".regist1", data);
		
		if(result != 0) {
			logger.debug("글쓰기 완료");
		}
	}
	
	// 글 상세내용 보기
	@Override
	public BoardVO read1Board(int b_bno) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+".getBoard1",b_bno);
	}

	// 글 조회수 증가
	@Override
	public void updateCnt(int b_bno) throws Exception {

		SqlSession.selectOne(NAMESPACE+".upCnt",b_bno);
	}

	// 글 수정하기
	@Override
	public void updateBoard(BoardVO bvo) throws Exception {
		
		SqlSession.update(NAMESPACE+".update1", bvo);
		
	}

	// 글 삭제하기
	@Override
	public void deleteBoard1(int b_bno) throws Exception {
		
		SqlSession.delete(NAMESPACE+".delete1",b_bno);
		
	}
	
	

	

	

	
	
	


	
	
	
	
	
}
