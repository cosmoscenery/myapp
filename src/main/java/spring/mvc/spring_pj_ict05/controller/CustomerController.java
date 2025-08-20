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

import spring.mvc.spring_pj_ict05.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerServiceImpl service;	// 주소값 
	
	// 첫 페이지 -----------------------------------------------
	@RequestMapping("/main.do")
	public String main() {
		logger.info("<<< url ==> /main.do >>>");
		
		return "common/main";   // 마지막에 "/WEB-INF/views/" => /로 끝나기 떄문에 /로 시작하면 안됨
	}
	
	// [회원가입] ------------------------------------------
    // 회원가입 페이지로 이동
	@RequestMapping("/join.do")
	public String join() {
		logger.info("<<< url ==> /join.do >>>");
		
		return "customer/join/join";
	}
	
	// id 중복확인 버튼 클릭시
	@RequestMapping("/idConfirmAction.do")
	public String idConfirmAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /idConfirmAction.do >>>");
		
		service.idConfirmAction(request, response, model);
		
		return "customer/join/idConfirmAction";
	}
	
	// 회원가입 버튼 클릭시 
	@RequestMapping("/joinAction.do")
	public String joinAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /joinAction.do >>>");
		
		service.signInAction(request, response, model);
		
		return "customer/join/joinAction";
	}
	
	// [로그인] -------------------------------------------
    // 로그인 페이지로 이동
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /login.do >>>");
		
		return "customer/login/login";
	}
	
	// 로그인 처리 페이지
	@RequestMapping("/loginAction.do")
	public String loginAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /loginAction.do >>>");
		
		service.loginAction(request, response);
		
		return "customer/login/loginAction";
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("<<< url ==> /logout.do >>>");
		
		// 세션삭제
  	  	request.getSession().invalidate();
  	  
  	  return "common/main";
	}
	
	// [회원탈퇴] ----------------------------------------------
    // 회원탈퇴 - 인증화면
	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("<<< url ==> /logout.do >>>");
		
		return "customer/mypage/customerinfo/deleteCustomer";
	}
	
	// 회원탈퇴 처리
	@RequestMapping("/deleteCustomerAction.do")
	public String deleteCustomerAction(HttpServletRequest request, HttpServletResponse response,  Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /logout.do >>>");
		
		service.deleteCustomerAction(request, response, model);
		
		return "customer/mypage/customerinfo/deleteCustomerAction";
	}
	
	// [회원수정] ----------------------------------------------
	
    // 회원수정 - 인증화면
	@RequestMapping("/modifyCustomer.do")
	public String modifyCustomer(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /modifyCustomer.do >>>");
		
		return "customer/mypage/customerinfo/modifyCustomer";
	}
	
	// 회원수정 - 상세페이지
	@RequestMapping("/modifyDetailAction.do")
	public String modifyDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /modifyDetailAction.do >>>");
		
		service.modifyDetailAction(request, response, model);
		
		return "customer/mypage/customerinfo/modifyDetailAction";
	}
	
	// 회원수정 - 수정처리
	@RequestMapping("/modifyCustomerAction.do")
	public String modifyCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /modifyCustomerAction.do >>>");
		
		service.modifyCustomerAction(request, response, model);
		
		return "customer/mypage/customerinfo/modifyCustomerAction";
	}
	
	
}
