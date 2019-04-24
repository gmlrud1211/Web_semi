package controller.admin.oneandboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import dto.OneAndBoard;
import service.admin.oneandboard.OneAndBoardService;
import service.admin.oneandboard.OneAndBoardServiceImpl;

@WebServlet("/oneandboard/view")
public class OneAndBoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OneAndBoardService obService = new OneAndBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��û�Ķ���� -> MODEL
		OneAndBoard oboard = obService.getParam(req, resp);
		
		//�Խñ� ��ȸ����
		OneAndBoard oboardview = obService.view(oboard);
		
		//MODEL ����
		req.setAttribute("oboardview", oboardview);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/oneandboard/view.jsp")
			.forward(req, resp);
		
	}
	
}







