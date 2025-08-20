package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface BoardService {

	// 게시글 목록
	public void boardListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException; 
	
	// 게시글 상세 처리
    public void boardDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException; 
	
    
    // 게시글 수정삭제 버튼 클릭시 - 비밀번호 인증처리
    public int password_chkAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException; 
	
    
    // 게시글 수정 처리
    public void boardUpdateAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException; 
	
    
    // 게시글 삭제 처리
    public void boardDeleteAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException; 
	
    
    // 게시글 작성 처리
    public void boardInsertAction(HttpServletRequest request, HttpServletResponse response, Model model)
    		throws ServletException, IOException;
    
    // 댓글 작성 처리
    public void commentAddAction(HttpServletRequest request, HttpServletResponse response, Model model)
    		throws ServletException, IOException;
    
    // 댓글 목록
	public void commentListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
}
