package controller.mypage.profile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserFavoritCate;
import dto.Users;
import service.users.UsersService;
import service.users.UsersServiceImpl;


@WebServlet("/mypage/profile/pwchange")
public class PwChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsersService uServ = new UsersServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/mypage/profile/pwChange.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int) session.getAttribute("u_no");

		String nu_pw = request.getParameter("newPw");
//		System.out.println(nu_pw);
		
		uServ.changePw(u_no, nu_pw);
		
		response.sendRedirect("/mypage/profile");

	}

}
