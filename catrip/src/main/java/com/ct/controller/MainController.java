package com.ct.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.controller.MainController;
import com.ct.domain.BoardVO;
import com.ct.domain.BottomPage;
import com.ct.domain.MemberVO;
import com.ct.domain.PageVO;
import com.ct.service.Board2Service;
import com.ct.service.BoardService;
import com.ct.domain.TripVO;
import com.ct.service.MemberService;
import com.ct.service.TripService;

@Controller
@RequestMapping(value = "/*")
public class MainController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private BoardService bService;

	@Autowired
	private TripService tService;
	
	@Autowired
	private Board2Service b2Service;

	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 메인페이지
	// http://localhost:8080/main
	@RequestMapping(value = "/main" ,method = RequestMethod.GET)
	public String mainGET(HttpSession session) {
	   
		
		
		MemberVO memberVO = (MemberVO) session.getAttribute("id");
		
		if(memberVO == null) {
			  logger.debug("id 정보가 없습니다. 메인 화면으로 이동하지 않습니다.");
		        return "redirect:/login";
		}else {
			return "/main";
		}
		
	}	
	
	// 로그아웃 세션제어
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutGET(HttpServletRequest request, HttpServletResponse response) {
			logger.debug(" smLogoutGET(호출)@@@@@ ");
			
			 request.getSession().invalidate();
			 
			 return "redirect:/login";
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
	
	// http://localhost:8080/login
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
	
	// ========== 애령 ==========
	// 게시판2
	// http://localhost:8080/board2
	// 게시글 조회
	@RequestMapping(value = "/board2", method = RequestMethod.GET)
	public void boardList(Model model, TripVO vo, PageVO pvo) throws Exception {
		logger.debug("board2 GET 컨트롤러 호출");
		if(vo.getTitle()  != null && !vo.getTitle().equals("")) {
			logger.debug("검색어 ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			int count = tService.count(vo);
			List<TripVO> boardList = tService.getboardList(vo, pvo);
			logger.debug("boardList : " + boardList);
			
			BottomPage bp = new BottomPage();
			bp.setPageVO(pvo);
			bp.setTotalCount(count);
			
			model.addAttribute("boardList", boardList);
			model.addAttribute("count", count);
			model.addAttribute("bp", bp);
			model.addAttribute("vo", vo);
			model.addAttribute("pvo", pvo);
		} else {
			logger.debug("검색어 XXXXXXXXXXXXXXX");
			int count = tService.count();
			List<TripVO> boardList = tService.getboardList(pvo);
			logger.debug("boardList : " + boardList);
			
			BottomPage bp = new BottomPage();
			bp.setPageVO(pvo);
			bp.setTotalCount(count);
			
			model.addAttribute("boardList", boardList);
			model.addAttribute("count", count);
			model.addAttribute("bp", bp);
			model.addAttribute("vo", vo);
			model.addAttribute("pvo", pvo);
		}
		
//		return "/board2";
	}
	
	// 글쓰기(GET)
	@RequestMapping(value = "/regist2", method = RequestMethod.GET)
	public void regist2() throws Exception {
	    logger.debug("regist2.jsp 페이지로 이동");
	}
	
	// 글쓰기(POST)
	@RequestMapping(value = "/regist2", method = RequestMethod.POST)
	public String regist2POST(TripVO vo) throws Exception {
		tService.regist2POST(vo);
		return "redirect:/board2";
	}
	
	
	// 글 상세보기
	@RequestMapping(value = "/read2", method = RequestMethod.GET)
	public void read2GET(Model model, @RequestParam("bno") int bno) throws Exception {
		logger.debug("bno : " + bno);
		
		tService.getBorad2(bno);
		tService.viewcnt2(bno);
		model.addAttribute("vo", tService.getBorad2(bno));
	}
	
	// 글 수정하기(GET)
	@RequestMapping(value = "/modify2", method = RequestMethod.GET)
	public void modify2GET(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.debug("글 수정 페이지로 이동");
		
		tService.modify2GET(bno);
		model.addAttribute("vo", tService.modify2GET(bno));
		
		TripVO vo = tService.modify2GET(bno);
		model.addAttribute("vo", vo);
	}
	
	// 글 수정하기(POST)
	@RequestMapping(value = "/modify2", method = RequestMethod.POST)
	public String modify2POST(@RequestParam("bno") int bno, TripVO vo) throws Exception {
		
		Map<String, Object> data = new HashMap<>();
	    data.put("bno", bno);
	    data.put("vo", vo);
		
		logger.debug("글 수정하기(POST) : " + vo);
		tService.modify2POST(data);
		logger.debug("글 수정완료");
		
		return "redirect:/board2";
	}
	
	// 글 삭제하기
	@RequestMapping(value = "/delete2", method = RequestMethod.POST)
	public String delete2(@RequestParam("bno") int bno) throws Exception {
		tService.delete2(bno);
		return "redirect:/board2";
	}
	
	// 게시판2 페이징처리
	
	
	// ========== 애령 - 끝 ==========
	
	// ============================국내 게시판 - 시작 ==============================================

	// http://localhost:8080/board1
	// 게시판1 
	@RequestMapping(value ="/board1",method = RequestMethod.GET)
	public void board1( Model model, BoardVO vo, PageVO pvo) throws Exception{
		
		if(vo.getSubject()  != null && !vo.getSubject().equals("")) {
			int count = bService.count(vo);
			List<BoardVO> board_List1 = bService.boardList(vo,pvo);
			BottomPage bp = new BottomPage();
            bp.setPageVO(pvo);
            bp.setTotalCount(count);
            model.addAttribute("bp",bp);
            logger.debug("pvo : " + pvo);
			logger.debug("검색엉ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			logger.debug("board_List1@@@@@@@@@@@" + board_List1);
			model.addAttribute("board_list",board_List1);
			model.addAttribute("count",count);
			model.addAttribute("vo",vo);
			model.addAttribute("pvo",pvo);
			
		} else {
			int count = bService.count();
			List<BoardVO> board_list = bService.boardList(pvo);
			BottomPage bp = new BottomPage();
            bp.setPageVO(pvo);
            bp.setTotalCount(count);
            model.addAttribute("bp",bp);
			logger.debug("검색어xxxxxxxxxxxx");
			logger.debug("board_list@@@@@@@@" + board_list);
			model.addAttribute("board_list",board_list);
			model.addAttribute("count",count);
			model.addAttribute("vo",vo);
			model.addAttribute("pvo",pvo);
		}
		
		
		
		
		
		
	}
	// http://localhost:8080/regist1
	// 글쓰기(GET)
	@RequestMapping(value="/regist1", method = RequestMethod.GET)
	public String registGET1(BoardVO vo,Model model,TripVO tvo) throws Exception{
		List<TripVO> trip = tService.cityList();
		
		model.addAttribute("trip",trip);
		
		
		return "regist1";
	}
	
	// 글쓰기(POST)
	@RequestMapping(value ="/regist1", method=RequestMethod.POST)
	public String registPOST1(BoardVO vo, @RequestParam("v") int v) throws Exception{
		if(v == 1) {
			bService.insertBoard(vo);
			return "redirect:/board1";
		} else {
			b2Service.insertBoard(vo);
			return "redirect:/board0";
		}
	}
	
	// 글 상세보기 (조회수 증가)
	@RequestMapping(value = "/read1", method = RequestMethod.GET)
	public void read1GET(Model model, @RequestParam("b_bno") int b_bno ) throws Exception {
		
		logger.debug("b_bno : " + b_bno);
			
		bService.updateCnt(b_bno);
		bService.read1Board(b_bno);
		model.addAttribute("b_bno", bService.read1Board(b_bno));
		
	}
	
	// 글 수정하기 (GET)
	@RequestMapping(value ="/modify1" ,method = RequestMethod.GET)
	public void upBoardGet(@RequestParam("b_bno") int b_bno, Model model) throws Exception {
		
		BoardVO vo = bService.read1Board(b_bno);
		model.addAttribute("vo", vo);
	}
	
	// 글 수정하기(POST)
	@RequestMapping(value ="/modify1" ,method = RequestMethod.POST)
	public String upBoardPost(BoardVO bvo, @RequestParam("value") int v) throws Exception {
		
		bService.updateBoard(bvo);
		
		if(v == 0) {
			return "redirect:/board0";
		} else {
			return "redirect:/board1";
		}
	}
	
	// 글 삭제하기
	@RequestMapping(value="/delete1", method=RequestMethod.GET)
	public String deleteBoardPOST(@RequestParam("v") int v, @RequestParam("b_bno") int b_bno) throws Exception{
		logger.debug("삭제 테스트 : " + v);
		bService.deleteBoard1(b_bno);
		
		if(v == 0) {
			return "redirect:/board0";
		} else {
			return "redirect:/board1";
		}
	}
	
	// 채팅
	@RequestMapping(value="/chat" , method=RequestMethod.GET)
    public String chat(Model model) {
        // 사용자 정보 가져오기 (Spring Security를 사용하지 않고 예시로 구현)
        String username = "guest"; // 예시로 사용자 이름을 "guest"로 설정

        // 로깅 추가
        System.out.println("==================================");
        System.out.println("@ChatController, GET Chat / Username : " + username);

        // 모델에 사용자 정보 추가
        model.addAttribute("userid", username);

        // 채팅 페이지로 이동 (View 이름을 반환)
        return "chat"; 
    }
	
	// ============================ 국내 게시판 - 끝 ==============================================
	
	
	
	// ============================ 해외 게시판 - 시작 ==============================================
	
	// http://localhost:8080/board0
	// 게시판1 
	@RequestMapping(value ="/board0",method = RequestMethod.GET)
	public void board0( Model model, BoardVO vo, PageVO pvo) throws Exception{
		
		if(vo.getSubject()  != null && !vo.getSubject().equals("")) {
			int count = b2Service.count(vo);
			List<BoardVO> board_List1 = b2Service.boardList(vo,pvo);
			BottomPage bp = new BottomPage();
            bp.setPageVO(pvo);
            bp.setTotalCount(count);
            model.addAttribute("bp",bp);
            logger.debug("pvo : " + pvo);
			logger.debug("검색엉ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			logger.debug("board_List1@@@@@@@@@@@" + board_List1);
			model.addAttribute("board_list",board_List1);
			model.addAttribute("count",count);
			model.addAttribute("vo",vo);
			model.addAttribute("pvo",pvo);
			
		} else {
			int count = b2Service.count();
			List<BoardVO> board_list = b2Service.boardList(pvo);
			BottomPage bp = new BottomPage();
            bp.setPageVO(pvo);
            bp.setTotalCount(count);
            model.addAttribute("bp",bp);
			logger.debug("검색어xxxxxxxxxxxx");
			logger.debug("board_list@@@@@@@@" + board_list);
			model.addAttribute("board_list",board_list);
			model.addAttribute("count",count);
			model.addAttribute("vo",vo);
			model.addAttribute("pvo",pvo);
		}
	}
	// ============================ 해외 게시판 - 끝 ==============================================


}