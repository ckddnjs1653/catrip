package com.ct.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private int tel;
	private Date regdate;
	
}
