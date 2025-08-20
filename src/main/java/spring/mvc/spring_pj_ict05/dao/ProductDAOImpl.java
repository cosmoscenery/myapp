package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	// 컨넥션풀, 마이바티스 연동
	@Autowired 
	private SqlSession sqlSession;
	
	//상품 등록
	@Override
	public int productInsert(ProductDTO dto) {
		System.out.println("ProductDAOImpl - productInsert");
		
		// 방법1.
//		int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.ProductDAO.productInsert", dto);
//		return insertCnt;
		
		// 방법2.
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		int insertCnt = dao.productInsert(dto);
		return insertCnt;
	}

	// 상품갯수
	@Override
	public int productCnt() {
		System.out.println("ProductDAOImpl - productCnt");
		
		int insertCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.ProductDAO.productCnt");
		
		return insertCnt;
	}

	// 상품 목록
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		System.out.println("ProductDAOImpl - productList");
		
		List<ProductDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.ProductDAO.productList", map);
		
		return list;
	}

	// 상품 상세페이지
	@Override
	public ProductDTO productDetail(int pdNo) {
		System.out.println("ProductDAOImpl - productDetail");
		
		// 방법1.
		// ProductDTO dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.ProductDAO.productDetail", pdNo);
			
		// 방법2.
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		ProductDTO dto = dao.productDetail(pdNo);
		
		return dto;
	}

	// 상품 수정
	@Override
	public int productUpdate(ProductDTO dto) {
		System.out.println("ProductDAOImpl - productUpdate");
		
		int updateCnt = sqlSession.update("spring.mvc.spring_pj_ict05.dao.ProductDAO.productUpdate", dto);
		
		return updateCnt;
	}

	// 상품삭제
	@Override
	public int productDelete(int pdNo) {
		System.out.println("ProductDAOImpl - productDelete");
		
		int updateCnt = sqlSession.update("spring.mvc.spring_pj_ict05.dao.ProductDAO.productDelete", pdNo);
		
		return updateCnt;
	}

}
