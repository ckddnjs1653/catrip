package com.ct.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ct.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession SqlSession;
	
	private static final String NAMESPACE="com.ct.mapper.tripMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	// C - 회원정보 가입
	@Override
	public void insertMember(MemberVO vo) {
		
		SqlSession.insert(NAMESPACE+".insertMember",vo);
	}

	// 로그인
	@Override
	public MemberVO loginMember(MemberVO vo) {
		
		return SqlSession.selectOne(NAMESPACE + ".login", vo);
	}

	@Override
	public MemberVO loginMember(String id, String pw){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pw", pw);
		return SqlSession.selectOne(NAMESPACE + ".login", params);
	}
	
	
}
