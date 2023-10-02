package com.ct.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<TripVO> getboardList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE +".board2");
		
	}

	@Override
	public TripVO getBorad2(Integer bno) throws Exception {
		
		logger.debug("체크 : " + bno);
		
		return sqlSession.selectOne(NAMESPACE + ".getBoard2", bno);
	}
	
	
	
	

}
