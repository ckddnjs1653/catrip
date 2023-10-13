package com.ct.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class TripVO {

	private Integer t_bno;
	private String t_city;
	private String t_name;
	private String t_foreign;
	private String t_continent;
	private String t_score;
	private String t_danger;
	private String t_content;
	private String t_image;
	private String t_hot;
	private String title;
	private Date regdate;
	private Integer viewcnt;


	
}
