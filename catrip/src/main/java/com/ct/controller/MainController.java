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
import com.ct.domain.MemberVO;
import com.ct.service.MemberService;

@Controller
@RequestMapping(value="/catrip/*")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MemberService mService;
	
	// 회원가입 처리 - 사용자 정보 처리
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String MemberJoinPOST(HttpServletRequest request, MemberVO vo) throws Exception {
														   // ⬇️
		 // 매개변수 선언(vo)을 통해서 관련정보(파라미터) 자동 수집
		logger.debug("MemberJoinAction() 호출");
		
		logger.debug(vo+"");
		
		// 서비스 (통해서) 회원가입 메서드 호출 => DAO - 회원가입 메서드 호출
		mService.insertMember(vo);
		
		// 페이지 이동 -> 로그인 페이지
		
		return "redirect:/login";

	}
	
	// http://localhost:8088/login
	// 로그인 - 정보 입력(get)
	@RequestMapping(value = "/login", method = RequestMethod.GET) // 컨트롤러 주소인 /member를 제외해야함
	public void loginGET() {
		logger.debug(" loginGET() 호출 ");
		logger.debug(" 연결된 뷰페이지로 이동(/member/login.jsp) ");
	}
	
	// 로그인 - 정보 입력(post)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo ,HttpSession session, Model model, String id, String pw) {
		
		MemberVO result = mService.loginMember(vo);
		
		if(result != null) {
			session.setAttribute("id", result);
			session.setMaxInactiveInterval(3600*24);
			model.addAttribute(result);
			logger.debug(" 로그인 성공! ");
			return "redirect:/main";
		}else {
			logger.debug(" 로그인 실패! ");
			return "redirect:/login";
		}
	}
	
}
