package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ProductService {
	
	// 상품 등록
	public void productAddAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
	
	// 상품 목록
	public void productListAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
	
	// 상품 상세페이지
	public void productDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
	
	// 상품 수정
	public void productUpdateAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
	// 상품삭제
	public void productDeleteAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
}
