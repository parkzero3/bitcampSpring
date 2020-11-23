package com.bitcamp.myapp.register;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.myapp.Constants;
import com.bitcamp.myapp.register.RegisterVO;

public class RegisterDAO {
	public JdbcTemplate template =null;
	
	public RegisterDAO() {
		this.template = Constants.template;
	}
	
	public RegisterVO login(RegisterVO vo) {
		
		String sql= "select count(userid) cnt from register where userid=? and userpwd=?";		
		
		RegisterVO vo1 = template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(),vo.getUserpwd());
		
		if(vo1.getCnt()<=0) {//일치하는 레코드가 없을때
			return null;
		}else { //일치하는 레코드가 있을시
			String sql2="select userid, username from register where userid=? and userpwd=?";
			return template.queryForObject(sql2, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(),vo.getUserpwd());
		}
	}
}
