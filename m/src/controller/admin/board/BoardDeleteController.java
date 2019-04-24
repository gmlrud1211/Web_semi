package controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.BoardComment;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;

@WebServlet("/admin/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��û�Ķ���� -> MODEL
		Board board = boardService.getParam(req, resp);
		
		//�Խñۻ��� ����
		boardService.delete(board.getB_no());
		
	
		
		//MODEL ����
//		req.setAttribute("boarddel", boarddel);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/board/delete.jsp")
			.forward(req, resp);
		
	}
	
}







