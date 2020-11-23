package com.bitcamp.webDbcp.board;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardDAO bDao;
	
	//게시판리스트 @@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value="/boardList")
	public ModelAndView boardList() {
		
		List<BoardVO> list= bDao.getAllRecord();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("board/boardList");
		
		return mav;
	}
	//글내용보기 @@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value="/boardView")
	public ModelAndView boardView(BoardVO vo) {
		//조회수증가
		bDao.hitCount(vo.getNo());
		bDao.selectBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo",vo);
		mav.setViewName("board/boardView");
		
		return mav;
	}
	//글쓰기@@@@@@@@@@@@@@@@@@@@@@@@ 폼으로 이동
	@RequestMapping(value="/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		return mav;
	}
	
	//글쓰기@@@@@@@@@@@@@@@@@@@@@@@@@@ DB에작성
	@RequestMapping(value="/boardWriteOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpServletRequest r) {
		vo.setIp(r.getRemoteAddr());
		HttpSession session = r.getSession(); 
		
		vo.setUserid((String)session.getAttribute("userid"));
		
		int result = bDao.writeBoard(vo);
		
		ModelAndView mav =new ModelAndView();
		
		//글등록 --> 리스트
		//글등록 실패 --> 글등록페이지
		if (result>0) {//글등록
			mav.setViewName("redirect:boardList"); // 컨트롤러로 이동 -> 이유 : 리스트 셋팅후 리스트 뷰로 넘어감
		}else {//등록실패시
			mav.addObject("msg","글 등록이");
			mav.setViewName("board/result");
		}
		
		return mav;		
	}	
	//글수정@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 폼으로이동
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(BoardVO vo) {
		bDao.selectBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	//글수정@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DB수정
	@RequestMapping(value="/boardEditOk",method=RequestMethod.POST )
	public ModelAndView boardEditOk(BoardVO vo) {
		int result = bDao.editBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no",vo.getNo());
		if(result>0) {// 수정성공
			mav.setViewName("redirect:boardView");
		}else{
			mav.addObject("msg","글 수정이");
			mav.setViewName("board/result");
		}
		return mav;
	}
	//글삭제 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value="/boardDel")
	public ModelAndView boardDelete(@RequestParam("no") int no, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");
		
		int result = bDao.deleteBoard(no, userid);
		ModelAndView mav =new ModelAndView();
		if(result>0) {//삭제성공시
			mav.setViewName("redirect:boardList");
		}else {//삭제실패시
			mav.addObject("msg","글 삭제가 ");
			mav.setViewName("board/result.jsp");
		}
		return mav;
	}
}
