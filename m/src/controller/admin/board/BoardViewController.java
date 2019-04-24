package controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;

@WebServlet("/admin/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//占쏙옙청占식띰옙占쏙옙占� -> MODEL
		Board board = boardService.getParam(req, resp);
		
		//占쌉시깍옙 占쏙옙회占쏙옙占쏙옙
		Board boardview = boardService.view(board);
		
		//MODEL 占쏙옙占쏙옙
		req.setAttribute("boardview", boardview);
		
		//VIEW占쏙옙占쏙옙
		req.getRequestDispatcher("/view/admin/board/detail.jsp")
			.forward(req, resp);
		
	}
	
}







