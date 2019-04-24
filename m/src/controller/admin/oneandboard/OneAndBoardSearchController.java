package controller.admin.oneandboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.OneAndBoard;
import service.admin.oneandboard.OneAndBoardService;
import service.admin.oneandboard.OneAndBoardServiceImpl;

@WebServlet("/oneandboard/search")
public class OneAndBoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OneAndBoardService oboardService = new OneAndBoardServiceImpl();	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		
		//��û�Ķ���� -> MODEL
		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type);
		System.out.println(word);		
		
		//�Խñ� ��ȸ����
		List<OneAndBoard> oboardlist = oboardService.getSearch(type, word);
		
		//MODEL ����
		req.setAttribute("oboardlist", oboardlist);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/oneandboard/list.jsp")
			.forward(req, resp);
		
	}
	
}







