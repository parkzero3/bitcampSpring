package com.bitcamp.webDbcp.register;

import com.bitcamp.webDbcp.DBConn;

public class RegisterDAO extends DBConn implements RegisterDaoInterface {

	@Override
	public void loginCheck(RegisterVO vo) {
		
		try {
			dbConn();
			sql="select username from register where userid=? and userpwd=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpwd());
			rs = pstmt.executeQuery();
			if(rs.next()) { //로그인 성공시
				vo.setUsername(rs.getString(1));
				vo.setLogStatus("Y");
			}
		}catch(Exception e) {
			System.out.println("RegisterDAO -> loginCheck 에러발생"+e.getMessage());
		}finally {
			dbClose();
		}

	}

	@Override
	public int regInsert(RegisterVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int regEdit(RegisterVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findId(RegisterVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findPwd(RegisterVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int regDelete(RegisterVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
