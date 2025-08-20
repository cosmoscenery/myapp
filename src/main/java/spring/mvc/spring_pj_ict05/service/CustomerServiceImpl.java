package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.spring_pj_ict05.dao.CustomerDAO;
import spring.mvc.spring_pj_ict05.dao.CustomerDAOImpl;
import spring.mvc.spring_pj_ict05.dto.CustomerDTO;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired	// 주소주세요! ㅇㅇㅇㅇ입니다 (주소가 들어있는 초대장)
	private CustomerDAO dao ;	// 다형성 적용
	
	// ID 중복확인 처리
	@Override
	public void idConfirmAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - idConfirmAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = request.getParameter("user_id");  // 화면 입력값은 반드시 parameter씀. jsp로 넘길때만 Attribute
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();  // = new CustomerDAOImpl();
		
		// 5단계. ID 중복확인 처리
		int selectCnt = dao.useridCheck(strId);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt); // 컨트롤러 가서 viewPage에 있는 jsp로 이동/ "selectCnt" 이름을 그 jsp에서 사
		model.addAttribute("strId", strId);
	}

	// 회원가입 처리
	@Override
	public void signInAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - signInAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져와서 DTO의 setter를 통해 값 전달
		// request.getParameter("user_id") -> 화면에 입력한 id / 를 DTO에 담음
		// DTO 생성 -> setter -> 멤버변수
		CustomerDTO dto = new CustomerDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setUser_password(request.getParameter("user_password"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
		
		// 주소
		String address1 = request.getParameter("user_address1");
		String address2 = request.getParameter("user_address2");
		String address = address1 + " " + address2;
		dto.setUser_address(address);
		
		// hp는 필수가 아니므로 null 값이 들어올 수 있으므로 값이 존재할 깨만 받아온다(010 1234 5678)
		String hp ="";
		String hp1 = request.getParameter("user_hp1");
		String hp2 = request.getParameter("user_hp2");
		String hp3 = request.getParameter("user_hp3");
		
		if(!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {  // ("") = null
			hp = hp1 + "-" + hp2 + "-" + hp3;
		}
		dto.setUser_hp(hp);
		
		// 이메일
		String email1 = request.getParameter("user_email1");
		String email2 = request.getParameter("user_email2");
		String email = email1 + "@" + email2;
		dto.setUser_email(email);
		
		// 등록일 .. 아래문장 생략시 sysdate로 사용됨 / 현재시간
		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAOImpl dao = new CustomerDAOImpl(); -> dao 디폴트 생성자를 private로 막아놨기 때문에 접근 불가
		// CustomerDAO dao = CustomerDAOImpl.getInstance();  // 다형성 적용
		
		// 5단계. 회원가입 처리
		int insertCnt = dao.insertCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("insertCnt", insertCnt);
		
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public void loginAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - loginAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = request.getParameter("user_id");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// HashMap 생성 -> key, value 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId", strId);
		map.put("strPassword", strPassword);
		
		// 5단계. 로그인 처리
		int selectCnt = dao.idPasswordChk(map);
		
		// 로그인 성공시 세션ID를 설정(중요)
		if(selectCnt == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", strId);
			
			// request.getSession().setAttribute("sessionID", strId); => 위에 두줄이랑 같음. 보통 이 문장으로 씀
		}
 		
		// 6단계. jsp로 처리결과 전달 - 위에서 세션을 했기 때문에 굳이 안적어도 됨
		// request.setAttribute("selectCnt", selectCnt);
	}

	// 회원정보 인증처리 및 탈퇴처리
	@Override
	public void deleteCustomerAction(HttpServletRequest request, HttpServletResponse response,  Model model)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - deleteCustomerAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(id)
		String sessionId = (String)request.getSession().getAttribute("sessionID");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// HashMap 생성 -> key, value 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId", sessionId);	// 2군데서 사용하므로 key 일치 
		map.put("strPassword", strPassword);
		
		// 5-1 단계. 회원정보 인증처리 처리
		int selectCnt = dao.idPasswordChk(map);
		
		int deleteCnt = 0;
		
		// 회원정보 인증성공시
		if(selectCnt == 1) {
			// 5-2단계. 탈퇴처리
			deleteCnt = dao.deleteCustomer(sessionId);
			if (deleteCnt == 1) {
				// 세션삭제 => 주의
		    	  request.getSession().invalidate();
			}
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("deleteCnt", deleteCnt);
	}

	// 회원정보 인증처리 및 상세페이지 조회
	@Override
	public void modifyDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - modifyDetailAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(id)
		String sessionId = (String)request.getSession().getAttribute("sessionID");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// HashMap 생성 -> key, value 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId", sessionId);	// 2군데서 사용하므로 key 일치 
		map.put("strPassword", strPassword);
		
		// 5-1 단계. 회원정보 인증처리 처리
		int selectCnt = dao.idPasswordChk(map);
		
		CustomerDTO dto = null;
		
		// 회원정보 인증성공시
		if(selectCnt == 1) {
			// 5-2단계. 상세페이지 조회
			dto = dao.getCustomerDetail(sessionId);
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("dto", dto);
	}

	// 회원정보 수정처리
	@Override
	public void modifyCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - modifyCustomerAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져와서 DTO의 setter를 통해 값 전달
		// DTO 생성 -> setter -> 멤버변수
		CustomerDTO dto = new CustomerDTO();  
		dto.setUser_id((String)request.getSession().getAttribute("sessionID"));  // input 박스에서 입력받지 않고 세셩ID  사용
		dto.setUser_password(request.getParameter("user_password"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
		
		// 주소
		String address1 = request.getParameter("user_address1");
		String address2 = request.getParameter("user_address2");
		String address = address1 + " " + address2;
		dto.setUser_address(address);
		
		// hp는 필수가 아니므로 null 값이 들어올 수 있으므로 값이 존재할 깨만 받아온다(010 1234 5678)
		String hp ="";
		String hp1 = request.getParameter("user_hp1");
		String hp2 = request.getParameter("user_hp2");
		String hp3 = request.getParameter("user_hp3");
		
		if(!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {  // ("") = null
			hp = hp1 + "-" + hp2 + "-" + hp3;
		}
		dto.setUser_hp(hp);
		
		// 이메일
		String email1 = request.getParameter("user_email1");
		String email2 = request.getParameter("user_email2");
		String email = email1 + "@" + email2;
		dto.setUser_email(email);
		
		// 등록일 .. 아래문장 생략시 sysdate로 사용됨 / 현재시간
		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5단계. 회원정보 수정처리
		int updateCnt = dao.updateCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("updateCnt", updateCnt);
	}

}
