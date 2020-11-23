package com.bitcamp.ajaxtest.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxHome")
	public String startAjax() {
		return "ajax/ajaxView";
	}
	
	@RequestMapping(value="/ajaxString",method=RequestMethod.GET,produces = "application/text;charset=UTF-8")
	@ResponseBody  //ajax매핑 매소드는 view페이지가 리턴되지않음
	public String startString(int no, String username, String userid) {
		System.out.println("클라이언트가 서버로 보낸데이터"+no+","+username+","+userid);
		
		String txt = "번호:"+no+"<br/>이름:"+username+"<br/>아이디:"+userid+"<br/>";
		return txt;
	}
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public TestVO ajaxObject() {
		return new TestVO(5555,"세종대왕","서울시 마포구");
		
	}
	@RequestMapping(value="/ajaxList",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<TestVO> ajaxList(TestVO vo){
		List<TestVO> list= new ArrayList<TestVO>();
		
		list.add(vo);
		list.add(new TestVO(1000,"고길동","서울시 도봉구 쌍문동"));
		list.add(new TestVO(2000,"도우너","깐따삐아"));
		list.add(new TestVO(3000,"또치","에버랜드 타조공원"));
		
		return list;
	}
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String,TestVO> ajaxMap() {
		HashMap<String,TestVO> map = new HashMap<String, TestVO>();
		
		map.put("k1", new TestVO(1111,"가가멜","서울시강남구"));
		map.put("k2", new TestVO(2222,"스머프","서울시강남구"));
		map.put("k3", new TestVO(3333,"거북이","부산 해운대"));
		
		return map;
	}
	@RequestMapping(value="/ajaxJson",method=RequestMethod.GET, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		// {"no":"1234","username":"홍길동","tel":"010-1111-1111","addr":"서울시동작구"}
		int no = 1234;
		String username= "홍길동";
		String tel="010-1111-1111";
		String addr ="서울시동작구";
		
		String jsonText ="{\"no\":\""+no+"\",\"username\":\""+
							username+"\",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\"}";
		System.out.println(jsonText);
		return jsonText;
	}
}
