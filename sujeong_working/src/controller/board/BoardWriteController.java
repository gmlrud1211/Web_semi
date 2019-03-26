package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dto.Board;
import dto.FileUpload;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDao boardDao = new BoardDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청파라미터 -> u_name 
		/*
		 * String user = userService.getUserName(request); System.out.println(user);
		 * request.setAttribute("userName", user);
		 */

		//로그인 되어있지 않으면 /main으로 리다이렉트
		/*
			if( request.getSession().getAttribute("login") == null ) {
			//로그인해야 이용이 가능하다는 처리 추가해야함!
			response.sendRedirect("/main"); //리다이렉트
			return; //doGet 중단
		}
		*/
		request.getRequestDispatcher("/view/board/write.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		// u_no추가해야함!!!!!!!!!!!!

		//요청파라미터
		String b_head = request.getParameter("head");
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("content");
		//파일번호 구하기
		String filenoParam = request.getParameter("fileno");
		int fileno = -1;
		
		if(filenoParam!=null && !"".equals(filenoParam)) {
			fileno = Integer.parseInt(filenoParam);
		}
		
		BoardDao dao = new BoardDaoImpl();

		//게시글 번호 얻기
		int boardno = dao.getBoardno();
		
		//게시글 정보 입력
		Board board = new Board();
		board.setB_head(b_head);
		board.setB_title(b_title);
		board.setB_content(b_content);
		
		 //파일첨부가 존재하면 처리
		if(fileno != -1) {
			FileUpload fileupload = new FileUpload();
			fileupload.setFile_no(fileno);
			board.setFile_no(fileno);

			//게시글과 파일을 연결
			boardDao.updateFile(fileupload);
		}

		//게시글 삽입
		dao.boardWrite(boardno, board);
		response.sendRedirect("/board/list");
	}
}
