package controller.board;

import java.io.IOException;
import java.util.List;

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
import dto.Study;
import service.board.BoardService;
import service.board.BoardServiceImpl;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService boardservice = new BoardServiceImpl();
	BoardDao boardDao = new BoardDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Board board = new Board();
		String bno = request.getParameter("b_no");
		int b_no = Integer.parseInt(bno);
		board.setB_no(b_no);
		// 첨부파일 명 가져오기 
		String fileName = boardservice.getFile(board);
		request.setAttribute("fileName", fileName);

		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("u_name");
		request.setAttribute("userName", user);

		// 수정할 게시글 가져와서 객체에 담기 
		board = boardservice.getBoard(bno);
		
		request.setAttribute("board", board);
		//  수정페이지로 이동
		request.getRequestDispatcher("/view/board/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Board board = new Board();
		
		String b_head = request.getParameter("head");
		
		String b_title = request.getParameter("title");
		String b_content = request.getParameter("content");
		String bno = request.getParameter("b_no");
		int b_no = Integer.parseInt(bno);
		
		
		String fileno = request.getParameter("file_no");
		int file_no = Integer.parseInt(fileno);
		
		if( file_no > 0 )  {
			
			board.setFile_no(file_no);
			 
			FileUpload upfile = new FileUpload();
			upfile.setFile_no(file_no);
		} 
		
		board.setB_head(b_head);
		board.setB_title(b_title);
		board.setB_content(b_content);
		board.setB_no(b_no);
		
		
		boardservice.boardUpdate(board);
		response.sendRedirect("/board/list");
	}

}
