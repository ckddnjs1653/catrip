package com.ct.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {

	private String content;
	private String subject;
	private int b_bno; 
	private Date b_regdate;
	private int cnt;
	private int maxPerson;
	private int personNum;
	private String HM_ABR;
	private String id;
	private String t_name;
	private String t_city;
	private String k_city;
}
