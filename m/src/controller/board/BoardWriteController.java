package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("u_name");
		request.setAttribute("userName", user);

		request.getRequestDispatcher("/view/board/write.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		
		//요청파라미터
		String b_head = request.getParameter("head");
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("content");
		//파일번호 구하기
		String filenoParam = request.getParameter("fileno");
		BoardDao dao = new BoardDaoImpl();

		//게시글 번호 얻기
		int boardno = dao.getBoardno();
		int u_no = (int)session.getAttribute("u_no");		
		
		//게시글 정보 입력
		Board board = new Board();
		board.setB_head(b_head);
		board.setB_title(b_title);
		board.setB_content(b_content);
		board.setU_no(u_no);
		
		 //파일첨부가 존재하면 처리
		if( request.getParameter("fileno") != null) {
			String file_no = request.getParameter("fileno");
			int f_no = Integer.parseInt(file_no);
			board.setFile_no(f_no);
			 
			FileUpload upfile = new FileUpload();
			upfile.setFile_no(f_no);
		} 

		//게시글 삽입
		dao.boardWrite(boardno, board);
		response.sendRedirect("/board/list");
	}
}
