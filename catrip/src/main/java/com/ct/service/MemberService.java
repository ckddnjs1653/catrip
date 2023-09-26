package com.ct.service;

import com.ct.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO loginMember(MemberVO vo) ;
}
