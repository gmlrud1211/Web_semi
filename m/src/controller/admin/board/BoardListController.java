package controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;
import util.Paging;

@WebServlet("/admin/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage = boardService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount = boardService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<Board> boardlist = boardService.getPagingList(paging);
		req.setAttribute("boardlist", boardlist);
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/board/list.jsp")
			.forward(req, resp);
		
	}
	
}









