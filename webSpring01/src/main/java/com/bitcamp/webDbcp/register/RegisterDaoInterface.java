package com.bitcamp.webDbcp.register;

public interface RegisterDaoInterface {
	//로그인
	public void loginCheck(RegisterVO vo);	
	//회원가입
	public int regInsert(RegisterVO vo);
	//회원정보수정
	public int regEdit(RegisterVO vo);
	//아이디 찾기
	public int findId(RegisterVO vo);
	//비밀번호 찾기
	public int findPwd(RegisterVO vo);
	//회원탈퇴 
	public int regDelete(RegisterVO vo);
	
	//미리 인터페이스를 만들어놓는것이 좋음
}
