package spring.mvc.spring_pj_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.Context;  // 주의 naming임
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;	// 주의 sql임

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// 싱글톤 객체 생성 => @Repository -> @Autowired
	
	
	// 커넥션풀 (context.xml에 설정) + 마이바티스 경로 => dataSource-config.xml에서 구현
	// Mybatis jar 파일들이 pom.xml에 등록되어 있어야 SqlSession(=인터페이스)이 import 가능
	// dataSource-config.xml에 bean id="sqlSession"로 설정되어 있어야 함
	
	@Autowired
	private SqlSession sqlSession;	// 접근
	
	// ID 중복확인 처리
	@Override
	public int useridCheck(String strId) {
		System.out.println("CustomerDAOImpl - useridCheck()");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.useridCheck", strId);
		
		return selectCnt;	
	}

	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("CustomerDAOImpl - insertCustomer()");
		
		int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.CustomerDAO.insertCustomer", dto);
			
		return insertCnt;
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(Map<String, Object> map) {
		System.out.println("CustomerDAOImpl - idPasswordChk()");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.idPasswordChk", map);
			
		return selectCnt;
	}

	// 회원정보 인증처리 및 탈퇴처리
	@Override
	public int deleteCustomer(String strId) {

		System.out.println("CustomerDAOImpl - deleteCustomer()");
		
		int deleteCnt = sqlSession.delete("spring.mvc.spring_pj_ict05.dao.CustomerDAO.deleteCustomer", strId);
		
		return deleteCnt;
	}

	// 상세페이지 조회
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		
		System.out.println("CustomerDAOImpl - getCustomerDetail()");
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.getCustomerDetail", strId) ;
			
		return dto;
	}

	// 회원정보 수정처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		
		System.out.println("CustomerDAOImpl - updateCustomer()");

		int updateCnt = sqlSession.update("spring.mvc.spring_pj_ict05.dao.CustomerDAO.updateCustomer", dto);
			
		return updateCnt;
	}

}
