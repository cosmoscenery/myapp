package spring.mvc.spring_pj_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.spring_pj_ict05.service.BoardServiceImpl;


@Controller
public class BoardController {

private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardServiceImpl service;	// 주소값 
	
	// [게시글 목록]
	@RequestMapping("/board_list.bc")
	public String board_list(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_list.bc >>>");
		
		service.boardListAction(request, response, model);
		
		return "admin/csCenter/board_list";   // 마지막에 "/WEB-INF/views/" => /로 끝나기 떄문에 /로 시작하면 안됨
	}
	
	
	// [게시글 상세화면]
	@RequestMapping("/board_detailAction.bc")
	public String board_detailAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_detailAction.bc >>>");
		
		service.boardDetailAction(request, response, model);
		
		return "admin/csCenter/board_detailAction";
	}
	
	// [게시글 수정삭제 버튼] 클릭시 - 비밀번호 인증처리
	@RequestMapping("/password_chkAction.bc")
	public String password_chkAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /password_chkAction.bc >>>");
		
		int result =  service.password_chkAction(request, response, model);
  	  
	   	 if(result != 0) { // 인증성공시
	   		 return "admin/csCenter/board_edit";
	   		 
	   	 } else { // 인증실패시
	   		 System.out.println("<<< 비밀번호 불일치 >>>");
	   		 int b_num = Integer.parseInt(request.getParameter("hidden_b_num"));
	   		 
	   		 String viewPage = request.getContextPath() + "/board_detailAction.bc?b_num=" +b_num + "&message=error";
	   		 response.sendRedirect(viewPage);
	   		 return null;  // sendRedirect 후 forward를 못타도록 하기위함/ 반환이 String이기 때문에 null
	   	 }
	}
	
	// [게시글 수정 처리]
	@RequestMapping("/board_updateAction.bc")
	public String board_updateAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_updateAction.bc >>>");
		
		service.boardUpdateAction(request, response, model);
		
		String viewPage = request.getContextPath() + "/board_list.bc" ;
	  	response.sendRedirect(viewPage);
	  	return null;
	}
	
	// [게시글 삭제 처리]
	@RequestMapping("/board_deleteAction.bc")
	public String board_deleteAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_deleteAction.bc >>>");
		
		service.boardDeleteAction(request, response, model);
		
		String viewPage = request.getContextPath() + "/board_list.bc" ;
	  	response.sendRedirect(viewPage);
	  	return null;
	}
	
	// [게시글 작성 화면]
	@RequestMapping("/board_insert.bc")
	public String board_insert(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_insert.bc >>>");
		
		return "admin/csCenter/board_insert";
		
	}
	
	// [게시글 작성 처리]
	@RequestMapping("/board_insertAction.bc")
	public String board_insertAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /board_insertAction.bc >>>");
		
		service.boardInsertAction(request, response, model);
  	  
   	  	String viewPage = request.getContextPath() + "/board_list.bc" ;
  	  	response.sendRedirect(viewPage);
  	  
		return null;
	}
	
	// [댓글 작성 처리]
	@RequestMapping("/comment_insert.bc")
	public String comment_insert(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /comment_insert.bc >>>");
	
		service.commentAddAction(request, response, model);
		
		// board_detailAction.jsp의 comment_list()로 복귀 =>$.ajax의 콜백함수로 리턴
		
		return null;
	}
	
	// [댓글 목록]
	@RequestMapping("/comment_list.bc")
	public String comment_list(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException {
		logger.info("<<< url ==> /comment_list.bc >>>");
	
		service.commentListAction(request, response, model);
		
		return "admin/csCenter/comment_list";
	}
}
