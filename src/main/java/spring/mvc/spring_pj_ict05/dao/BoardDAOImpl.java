package spring.mvc.spring_pj_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.BoardCommentDTO;
import spring.mvc.spring_pj_ict05.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	   // 게시글 목록
	   @Override
	   public List<BoardDTO> boardList(Map<String, Object> map) {
	      
	      System.out.println("BoardDAOImpl - boardList()");
	      
	      // 1. list 생성
	      // 데이터가 존재하면
	      // 2. dto 생성
	      // 3. dto에 1건의 rs 게시글 정보를 담는다
	      // 4. list에 dto를 추가한다
	      // 5. list를 리턴
	      List<BoardDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardList", map);
	     
	      return list;
	   }


	// 게시글 갯수 구하기
	@Override
	public int boardCnt() {
		
		System.out.println("BoardDAOImpl - boardCnt()");
		
		int total = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardCnt");
		
		return total;
	}

	// 조회수 증가
	@Override
	public void plusReadCnt(int board_num) {
		
		System.out.println("BoardDAOImpl - plusReadCnt()");

		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.plusReadCnt", board_num);
		
	}
	
	// 게시글 상세 화면 처리
	@Override
	public BoardDTO getBoardDetail(int board_num) {
		
		System.out.println("BoardDAOImpl - getBoardDetail()");
		
	     BoardDTO dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.getBoardDetail", board_num); 
				
		return dto;
	}
	
	// 게시글 수정삭제 버튼 클릭시 - 비밀번호 인증 처리
	@Override
	public int password_chk(Map<String, Object> map) {
		
		System.out.println("BoardDAOImpl - password_chk()");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.password_chk", map);
		
		return selectCnt;
	}

	// 게시글 수정 처리
	@Override
	public void updateBoard(BoardDTO dto) {
		
		System.out.println("BoardDAOImpl - updateBoard()");
		
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.updateBoard", dto);
	}

	// 게시글 삭제 처리
	@Override
	public void deleteBoard(int board_num) {
		
		System.out.println("BoardDAOImpl - deleteBoard()");
		
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.deleteBoard", board_num);
	}

	// 게시글 작성 처리
	@Override
	public void insertBoard(BoardDTO dto) {
		
		System.out.println("BoardDAOImpl - insertBoard()");
		
		sqlSession.insert("spring.mvc.spring_pj_ict05.dao.BoardDAO.insertBoard", dto);
	}

	// 댓글 작성 처리
	@Override
	public void insertComment(BoardCommentDTO dto) {
		
		System.out.println("BoardDAOImpl - insertComment()");
		
		sqlSession.insert("spring.mvc.spring_pj_ict05.dao.BoardDAO.insertComment", dto);
	}

	// 댓글 목록
	@Override
	public List<BoardCommentDTO> commentList(int board_num) {
		
		System.out.println("BoardDAOImpl - commentList()");
		
	      // 1. list 생성
	      List<BoardCommentDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.BoardDAO.commentList",board_num);
	      
	            
	      // 5. list를 리턴
	      return list;
	}
}
