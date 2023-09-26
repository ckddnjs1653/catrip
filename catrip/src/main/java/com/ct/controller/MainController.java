package com.ct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ct.controller.MainController;
import com.ct.service.MemberService;
import com.ct.service.TripService;

@Controller
@RequestMapping(value="/*")
public class MainController {
	
	@Autowired
	private MemberService m_service;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 메인페이지
	// http://localhost:8080/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
	    logger.debug("mainGET() 호출");

	    logger.debug("main.jsp페이지 이동");

	}	
	
	
}
