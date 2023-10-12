package com.ct.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ct.domain.PageVO;
import com.ct.domain.TripVO;

@Repository
public class TripDAOImpl implements TripDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(TripDAOImpl.class);
	
	private static final String NAMESPACE="com.ct.mapper.tripMapper";

	@Override
	public void regist2POST(TripVO vo) throws Exception {
		logger.debug("regist2POST DAOImpl 호출");
		int result = sqlSession.insert(NAMESPACE  + ".regist2", vo);
		
		if(result != 0)
			logger.debug("글쓰기 완료");
		
	}

	@Override
	public List<TripVO> getboardList(PageVO pvo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE +".board2", pvo);
		
	}

	@Override
	public TripVO getBorad2(Integer bno) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + ".getBoard2", bno);
	}

	@Override
	public void viewcnt2(Integer bno) throws Exception {
		
		sqlSession.update(NAMESPACE + ".viewcnt2", bno);
		
	}

	@Override
	public TripVO modify2GET(Integer bno) throws Exception {
		 return sqlSession.selectOne(NAMESPACE + ".modify2GET", bno);
		
	}

	@Override
	public void modify2POST(Map<String, Object> data) throws Exception {
		
		logger.debug("확인 : " + data);
		
		int result = sqlSession.update(NAMESPACE + ".modify2POST", data);
		
		if(result != 0) 
			logger.debug("글 수정 완료");
		
	}

	@Override
	public void delete2(Integer bno) throws Exception {
		int result = sqlSession.delete(NAMESPACE + ".delete2", bno);
		
		if(result != 0) 
			logger.debug("글 삭제 완료");
		
	}

	@Override
	public int count() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".Cnt");
	}

	@Override
	public List<TripVO> getboardList(TripVO vo, PageVO pvo) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("title", vo.getTitle());
		data.put("startPage", pvo.getStartPage());
		data.put("pageSize", pvo.getPageSize());
		logger.debug("검색어 O : " + vo.getTitle());
		
		return sqlSession.selectList(NAMESPACE+".Search2", data);
		
	}

	@Override
	public int count(TripVO vo) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("title", vo.getTitle());
		
		return sqlSession.selectOne(NAMESPACE + ".Cnt2", data);
	}
	
	
	
	

}
