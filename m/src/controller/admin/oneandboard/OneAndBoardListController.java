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
import util.Paging;

@WebServlet("/oneandboard/list")
public class OneAndBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OneAndBoardService oboardService = new OneAndBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage = oboardService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount = oboardService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<OneAndBoard> oboardlist = oboardService.getPagingList(paging);
		req.setAttribute("oboardlist", oboardlist);
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/oneandboard/list.jsp")
			.forward(req, resp);
		
	}
	
}









