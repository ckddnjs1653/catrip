package com.ct.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

public class ChattingHandler extends TextWebSocketHandler {
	
	

	private static final Logger logger = LoggerFactory.getLogger(ChattingHandler.class);
	
	// 웹 소켓 세션을 저장할 리스트 생성
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	// 클라이언트와 연결 된 후
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		
        
        // 스프링 시큐리티 사용시 가능한 메소드
        // System.out.println(session.getPrincipal().getName() + "의 입장");
	}
	
	// 웹 소켓 서버로 데이터를 전송했을 경우
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage msg) throws Exception {
	    for (WebSocketSession s : sessionList) {
	        s.sendMessage(new TextMessage(msg.getPayload()));
	    }
	}
	
	// 클라이언트와 연결이 끊어진 경우
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
        
        // 스프링 시큐리티 사용시 가능한 메소드
        // System.out.println(session.getPrincipal().getName() + "의 퇴장");
	}

}