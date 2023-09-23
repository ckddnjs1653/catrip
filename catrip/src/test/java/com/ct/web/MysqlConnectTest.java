package com.ct.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlConnectTest {

	 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String DBURL ="jdbc:mysql://localhost:3306/caTrip";
	    private static final String DBID = "root";
	    private static final String DBPW = "1234";
	    
	    // DB 연결 메서드
	    // @Test : 테스트할 내용을 메서드 안에 작성함
	    //         어노테이션 표시 -> Junit 테스트 동작수행
	    
	    @Test
	    public void testDBConnection() throws Exception {
	        System.out.println("DB 연결 테스트 - 시작!");
	        
	        // 1. 드라이버 로드
	        Class.forName(DRIVER);
	        
	        // 2. DB 연결 수행
	        Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
	        
	        System.out.println("DB 연결 성공!12");
	        System.out.println(con);
	        
	        System.out.println("DB 연결 테스트 - 종료!");
	        
	    }
	    
}
