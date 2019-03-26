package controller.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;
import service.users.UsersService;
import service.users.UsersServiceImpl;

@WebServlet("/users/join")
public class UsersJoinController extends HttpServlet {
private static final long serialVersionUID = 1L;

	private UsersService usersService = new UsersServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cateList", usersService.cateList());
		request.getRequestDispatcher("/view/users/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청파라미터 처리
		Users mem = usersService.getMemberParam(request);
		String[] favoriteList = usersService.getUserFavoriteCateParam(request);

		// 회원가입 INSERT - joinMem 호출
		usersService.joinMem(mem, favoriteList);
		request.getRequestDispatcher("/view/users/joinComplete.jsp").forward(request, response);
	}
}
