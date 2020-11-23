package com.bitcamp.temp.register;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.temp.Constants;

public class RegisterDAO {
	public JdbcTemplate template =null;
	public RegisterDAO() {
		template = Constants.jdbcTemplate;
	}
	public RegisterVO login(RegisterVO vo) {
		//						VO 에 cnt 생성후 별명으로 지정
		String sql= "select count(userid) cnt from register where userid=? and userpwd=?";		
		//queryForObject : 선택된 레코드가 없을경우 에러발생..
		RegisterVO vo1 = template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(),vo.getUserpwd());
		
		if(vo1.getCnt()<=0) {//일치하는 레코드가 없을때
			return null;
		}else { //일치하는 레코드가 있을시
			String sql2="select userid, username from register where userid=? and userpwd=?";
			return template.queryForObject(sql2, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(),vo.getUserpwd());
		}
	}
}
