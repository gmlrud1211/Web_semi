package controller.admin.noticeboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;

@WebServlet("/noticeboard/search")
public class NoticeBoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nbService = new NoticeBoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		
		//��û�Ķ���� -> MODEL
		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type);
		System.out.println(word);		
		
		//�Խñ� ��ȸ����
		List<NoticeBoard> nboardlist = nbService.getSearch(type, word);
		
		//MODEL ����
		req.setAttribute("nboardlist", nboardlist);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/noticeboard/list.jsp")
			.forward(req, resp);
		
	}
	
}







