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

		
		//요청파라미터 -> MODEL
		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type);
		System.out.println(word);		
		
		//게시글 조회수행
		List<Users> userslist = usersService.getSearch(type, word);
		
		//MODEL 전달
		req.setAttribute("userslist", userslist);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/usersmanage/list.jsp")
			.forward(req, resp);
		
	}
	
}







