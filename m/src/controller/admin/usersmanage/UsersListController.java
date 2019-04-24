package controller.admin.usersmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;
import service.admin.usersmanage.UsersService;
import service.admin.usersmanage.UsersServiceImpl;
import util.Paging;

@WebServlet("/usersmanage/list")
public class UsersListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService usersService = new UsersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//���� ������ ��ȣ ���
		int curPage = usersService.getCurPage(req);
		
		//�� �Խñ� �� ���
		int totalCount = usersService.getTotalCount();
		
		//������ ��ü ����
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//�Խñ۸�� MODEL�� �߰�
		List<Users> userslist = usersService.getPagingList(paging);
		req.setAttribute("userslist", userslist);
		
		//����¡��ü MODEL�� �߰�
		req.setAttribute("paging", paging);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/usersmanage/list.jsp")
			.forward(req, resp);
		
	}
	
}









