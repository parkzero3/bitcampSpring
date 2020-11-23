package com.bitcamp.webDbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	protected Connection con = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	protected String sql = null;
	
	public DBConn() {}
	
	//DB 연결 (db 회선 받아오기 )
	public void dbConn() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			
			DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle");
			con = ds.getConnection();
			
		}catch(Exception e) {
			System.out.println("DB연결 에러발생");
			e.printStackTrace();
		}
	}
	//DB닫기 (db 회선 반납하기)
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			System.out.println("DB닫기 에러발생");
			e.printStackTrace();
		}
	}
}
