package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.spring_pj_ict05.dao.BoardDAO;
import spring.mvc.spring_pj_ict05.dto.BoardCommentDTO;
import spring.mvc.spring_pj_ict05.dto.BoardDTO;
import spring.mvc.spring_pj_ict05.page.Paging;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	// 게시글 목록
   @Override
   public void boardListAction(HttpServletRequest request, HttpServletResponse response, Model model)
         throws ServletException, IOException {
      System.out.println("BoardServiceImpl - boardListAction()");
      
      // 3단계. 화면에서 입력받은 값을 가져온다.
      String pageNum = request.getParameter("pageNum");
      
      // 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
      // BoardDAO dao = BoardDAOImpl.getInstance();
      
      // 5-1단계. 전체 게시글 갯수 카운트
      Paging paging = new Paging(pageNum);
      int total = dao.boardCnt();
      System.out.println("total : " + total);
      
      paging.setTotalCount(total);      
      
      
      // 5-2단계. 게시글 목록 조회
      int start = paging.getStartRow();
      int end = paging.getEndRow();
      
      Map<String, Object> map =  new HashMap<String, Object>();
      map.put("start", start);
      map.put("end", end);
      
      
      List<BoardDTO> list = dao.boardList(map);
      System.out.println("list : " + list);
      
      // 6단계. jsp로 처리결과 전달
      model.addAttribute("list", list);
      model.addAttribute("paging", paging);
   }

	// 게시글 상세 화면 처리
	@Override
	public void boardDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - boardDetailAction()");
		
		// 3단계. get 방식으로 넘긴 값을 가져온다 (hidden)
		// <a href="${path}/board_detailAction.bc?b_num=${dto.b_num}"> ${dto.b_title} </a>
		int board_num = Integer.parseInt(request.getParameter("b_num"));
	      
	   // 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
	   // BoardDAO dao = BoardDAOImpl.getInstance();
	      
	    // 5-1단계. 조회수 증가
	    dao.plusReadCnt(board_num);
	      
	    // 5-2단계. 게시글 상세 페이지
	    BoardDTO dto = dao.getBoardDetail(board_num); 
	      
	    // 6단계. jsp로 처리결과 전달
	    model.addAttribute("dto", dto);
	    
	}

	// 게시글 수정삭제 버튼 클릭시 - 비밀번호 인증처리
	@Override
	public int password_chkAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - password_chkAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져온다 (hidden 포함)
		int num = Integer.parseInt(request.getParameter("hidden_b_num"));
		String password = request.getParameter("b_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
	    // BoardDAO dao = BoardDAOImpl.getInstance();
		
		Map<String, Object> map =  new HashMap<String, Object>();	// num은 int, password는 String 따라서 Object
	    map.put("num", num);
	    map.put("password", password);
	    
	    // 5-1단계. 게시글 수정 삭제시 비밀번호 인증
	    int result = dao.password_chk(map);
	    
	    // 5-2단계. 게시글 상세 페이지 => 수정하기 위해서 수정 상세 페이지에 뿌린다
	    BoardDTO dto = null;
	    if(result != 0) {
	    	dto = dao.getBoardDetail(num);	// int num으로 선언한 num
	    }
	    
	    // 6단계. jsp로 처리결과 전달
	    model.addAttribute("dto" , dto);
		
	    // 7단계. 인증결과 리턴
		return result;
	}

	// 게시글 수정 처리
	@Override
	public void boardUpdateAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - boardUpdateAction()");
		
		// 3단계. 화면에서 입력받은 값(hidden 포함)을 가져와서 DTO에 담기
		BoardDTO dto = new BoardDTO();
		
		dto.setB_num(Integer.parseInt(request.getParameter("hidden_b_num")));
		dto.setB_title(request.getParameter("b_title"));
		dto.setB_content(request.getParameter("b_content"));
		dto.setB_password(request.getParameter("b_password"));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
	    // BoardDAO dao = BoardDAOImpl.getInstance();
	    
	    // 5단계. 게시글 수정처리 후 컨트롤러에서 board_list로 이동
	    dao.updateBoard(dto);

	}

	// 게시글 삭제 처리
	@Override
	public void boardDeleteAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - boardDeleteAction()");
		
		// 3단계. 화면에서 입력받은 값(hidden 포함)을 가져오기
		int num = Integer.parseInt(request.getParameter("hidden_b_num"));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
	    // BoardDAO dao = BoardDAOImpl.getInstance();
	    
	    // 5단계. 게시글 삭제처리 후 컨트롤러에서 board_list로 이동
		dao.deleteBoard(num);
	}

	// 게시글 작성 처리
	@Override
	public void boardInsertAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - boardInsertAction()");
		
		// 3단계. 화면에서 입력받은 값(hidden 포함)을 가져와서 dto에 담는다 
		BoardDTO dto = new BoardDTO();
		dto.setB_title(request.getParameter("b_title"));
		dto.setB_content(request.getParameter("b_content"));
		dto.setB_writer((String)request.getSession().getAttribute("sessionID"));
		dto.setB_password(request.getParameter("b_password"));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// BoardDAO dao = BoardDAOImpl.getInstance();
		
		// 5단계. 게시글 삭제처리 후 컨트롤러에서 board_list로 이동
		dao.insertBoard(dto);
	}

	// 댓글 작성 처리
	@Override
	public void commentAddAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - commentAddAction()");
		
		// 3단계. 화면에서 입력받은 값(jQuery에서 넘긴값)을 가져와서 dto에 담는다
		// CommentDTO 생성
		BoardCommentDTO dto = new BoardCommentDTO();
		dto.setC_board_num(Integer.parseInt(request.getParameter("board_num")));
		dto.setC_writer(request.getParameter("writer"));
		dto.setC_content(request.getParameter("content"));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// BoardDAO dao = BoardDAOImpl.getInstance();
		
		// 5단계. 댓글 작성처리 후 컨트롤러에서 list로 이동
		dao.insertComment(dto);		
	}

	// 댓글 목록
	@Override
	public void commentListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("BoardServiceImpl - commentListAction()");
		
		// 3단계. 화면에서 입력받은 값(jQuery에서 넘긴값)을 가져와서 dto에 담는다
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// BoardDAO dao = BoardDAOImpl.getInstance();
		
		// 5단계. 댓글 작성처리 후 컨트롤러에서 list로 이동
		List<BoardCommentDTO> list = dao.commentList(board_num);	
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("list", list);
	}

}
