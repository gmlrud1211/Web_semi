package controller.admin.banners;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Banners;
import service.admin.banners.BannersService;
import service.admin.banners.BannersServiceImpl;
import util.Paging;

@WebServlet("/banners/list")
public class BannersListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BannersService banService = new BannersServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage =  banService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount =  banService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<Banners> bannerslist =  banService.getPagingList(paging);
		req.setAttribute("bannerslist", bannerslist);
		System.out.println(bannerslist);
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/banners/list.jsp")
			.forward(req, resp);
		
	}
	
}









