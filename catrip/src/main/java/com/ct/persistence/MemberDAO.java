package com.ct.persistence;

import com.ct.domain.MemberVO;

public interface MemberDAO {

	// C - 회원정보 가입
	public void insertMember(MemberVO vo) throws Exception;
	
}
