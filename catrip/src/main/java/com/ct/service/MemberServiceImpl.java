package com.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.domain.MemberVO;
import com.ct.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public void insertMember(MemberVO vo) throws Exception{
		mdao.insertMember(vo); 
	}
	
	@Override
    public MemberVO loginMember(MemberVO vo) {

        MemberVO result = mdao.loginMember(vo);

        return result;
    }
	
}
