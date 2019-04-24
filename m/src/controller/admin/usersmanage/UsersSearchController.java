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

@WebServlet("/usersmanage/search")
public class UsersSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService usersService = new UsersServiceImpl();	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		
		//��û�Ķ���� -> MODEL
		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type);
		System.out.println(word);		
		
		//�Խñ� ��ȸ����
		List<Users> userslist = usersService.getSearch(type, word);
		
		//MODEL ����
		req.setAttribute("userslist", userslist);
		
		//VIEW����
		req.getRequestDispatcher("/view/admin/usersmanage/list.jsp")
			.forward(req, resp);
		
	}
	
}







