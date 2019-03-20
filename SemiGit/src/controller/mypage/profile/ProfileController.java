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


@WebServlet("/mypage/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsersService uServ = new UsersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		Users u = uServ.getUserByUno(u_no);
		List<UserFavoritCate> ucList = uServ.getFavoritCateByUno(u_no);
//		System.out.println(ucList.toString());
		
		req.setAttribute("users", u);
		req.setAttribute("ucList", ucList);
		
		req.getRequestDispatcher("/view/mypage/profile/usersProfile.jsp").forward(req, resp);

	}
}
