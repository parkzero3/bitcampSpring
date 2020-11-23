package com.bitcamp.webDbcp.board;

import java.util.List;

public interface BoardDaoInterface {

	//전체리스트
	public List<BoardVO> getAllRecord();
	//글쓰기
	public int writeBoard(BoardVO vo);
	//글삭제
	public int deleteBoard(int no, String userid);
	//글수정
	public int editBoard(BoardVO vo);
	//글선택
	public void selectBoard(BoardVO vo);
	//조회수증가
	public void hitCount(int no);
	
}
