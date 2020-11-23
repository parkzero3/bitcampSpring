package com.bitcamp.test.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.test.board.BoardDaoImp;
import com.bitcamp.test.board.BoardVO;
@Controller
public class TransactionAnnotation {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@RequestMapping("/tran")
	public ModelAndView tranTest() {
		//TranctionStatus객체를 구해야한다.
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		BoardDaoImp dao = sqlSession.getMapper(BoardDaoImp.class);
		try {
			BoardVO vo = new BoardVO();
			vo.setSubject("트랙젝션 테스트123");
			vo.setContent("트랙젝션 테스트 글내용");
			vo.setUserid("hong1234");
			vo.setIp("111.222.333.444");
			
			dao.boardInsert(vo);
			
			BoardVO vo2 = new BoardVO();
			vo2.setSubject("트랙젝션 테스트2123");
			vo2.setContent("트랙젝션 테스트 글내용2");
			vo2.setUserid("hong1234");
			vo2.setIp("111.222.333.125");
			
			dao.boardInsert(vo2);
			transactionManager.commit(status);
		}catch(Exception e) {
			transactionManager.rollback(status);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:boardList");
		return mav;
	}
}
