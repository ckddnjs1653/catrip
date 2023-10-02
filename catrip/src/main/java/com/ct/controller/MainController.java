package com.ct.controller;

import java.util.List;

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
import com.ct.domain.BoardVO;
import com.ct.domain.MemberVO;
import com.ct.service.BoardService;
import com.ct.service.MemberService;

@Controller
@RequestMapping(value = "/*")
public class MainController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 메인페이지
	// http://localhost:8080/main
	@RequestMapping(value = "/main")
	public void mainGET() {
	    logger.debug("mainGET() 호출");
	    logger.debug("main.jsp 페이지 이동");
	}	
	
	// 회원가입 처리 - 사용자 정보 처리
	// http://localhost:8080/join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String memberJoin() {
		logger.debug("memberJoinGET() 호출");
		logger.debug("/member/MemberJoinGET.jsp 뷰페이지 연결(자동)");
		
		return "join"; // 연결되어있는 뷰 호출됨
		
	}
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

	// http://localhost:8080/board1
	// 게시판1 
	@RequestMapping(value ="/board1",method = RequestMethod.GET)
	public void board1( Model model) throws Exception{
		
		List<BoardVO> board_list = bService.boardList();
		
		model.addAttribute("board_list",board_list);
		
	}
	// http://localhost:8080/regist1
	//글쓰기(GET)
	@RequestMapping(value="/regist1",method = RequestMethod.GET)
	public String registGET1(BoardVO vo) throws Exception{
		
		return "regist1";
	}
	
	//글쓰기(POST)
	@RequestMapping(value ="/regist1",method=RequestMethod.POST)
	public String registPOST1(BoardVO vo) throws Exception{
		
		bService.insertBoard(vo);
		
		return "redirect:/board1";
	}
	
}
