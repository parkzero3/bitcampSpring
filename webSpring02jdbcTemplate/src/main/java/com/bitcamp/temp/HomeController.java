package com.bitcamp.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	public JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	// servet-context.xml의 jdbcTemplate 빈 객체를 대입시키는 이노테이션
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
		Constants.jdbcTemplate = template;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}	
}
