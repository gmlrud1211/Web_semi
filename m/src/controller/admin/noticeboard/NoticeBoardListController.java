package controller.admin.noticeboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;
import util.Paging;

@WebServlet("/noticeboard/adminlist")
public class NoticeBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nboardService = new NoticeBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage = nboardService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount = nboardService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<NoticeBoard> nboardlist = nboardService.getPagingList(paging);
		req.setAttribute("nboardlist", nboardlist);
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/noticeboard/list.jsp")
			.forward(req, resp);
		
	}
	
}









