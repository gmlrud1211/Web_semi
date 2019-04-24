package controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Board;
import dto.BoardComment;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession(true);
		boolean login = false;
		if(session.getAttribute("login") != null) {
			login = (boolean) session.getAttribute("login");
		} else {
			login = false;
		}
		req.setAttribute("login", login);
		
		// 요청파라미터 -> MODEL
		Board board = boardService.getParam(req, resp);

		int u_no = -1;
		if(session.getAttribute("u_no") != null) {
			u_no = (int)session.getAttribute("u_no");	
			req.setAttribute("u_no", u_no);	
		}

		// 추천게시글인지 체크 (true=추천, false=비추천)
		boolean isRecommend = boardService.isRcmd(board, u_no);
		
		// 작성자 u_no 전달 (본인 게시글인지 여부 확인위함)
		int write_no = boardService.getUno(board);

		// 첨부파일 명 가져오기 
		String fileName = boardService.getFile(board);
		
		// 게시글 조회수행
		Board boardView = boardService.view(board);

		List<BoardComment> commentList = new ArrayList<>();
		commentList = boardService.getComment(board.getB_no());
		
		// MODEL 전달
		req.setAttribute("write_no", write_no);
		req.setAttribute("boardView", boardView);
		req.setAttribute("Recommend", isRecommend);
		req.setAttribute("fileName", fileName);
		req.setAttribute("commentList", commentList);
		
		// VIEW지정
		req.getRequestDispatcher("/view/board/detail.jsp").forward(req, resp);
	}
}
