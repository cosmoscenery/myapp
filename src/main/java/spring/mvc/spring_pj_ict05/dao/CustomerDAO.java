package spring.mvc.spring_pj_ict05.dao;

import java.util.Map;

import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

public interface CustomerDAO {

	// ID 중복확인 처리
	public int useridCheck(String strId);

	// 회원가입 처리
	public int insertCustomer(CustomerDTO dto);
	
	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	public int idPasswordChk(Map<String, Object> map);  // key는 항상 문자타입, value는 그때그때다름 => Object 줌
	
	// 회원정보 인증처리 및 탈퇴처리
	public int deleteCustomer(String strId);
	
	// 상세페이지 조회
	public CustomerDTO getCustomerDetail(String strId);
	
	// 회원정보 수정처리
	public int updateCustomer(CustomerDTO dto);
}
