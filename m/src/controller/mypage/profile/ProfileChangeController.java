package controller.mypage.profile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.StudyCategory;
import dto.UserFavoritCate;
import dto.Users;
import service.users.UsersService;
import service.users.UsersServiceImpl;


@WebServlet("/mypage/profile/updateProfile")
public class ProfileChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService uServ = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		Users u = uServ.getUserByUno(u_no);
		List<UserFavoritCate> ucList = uServ.getFavoritCateByUno(u_no);
		List<StudyCategory> cateList = uServ.getCateList();
		
		String ufc = "";
		for(int i=0; i<ucList.size(); i++) {
			ufc+=String.valueOf(ucList.get(i).getSt_code());
			if(i!=ucList.size()-1)	ufc+=",";
		}
//		System.out.println(ufc);
		
//		System.out.println(ucList.toString());
		
		req.setAttribute("users", u);
		req.setAttribute("ufc", ufc);
		req.setAttribute("cateList", cateList);
				
		req.getRequestDispatcher("/view/mypage/profile/profileChange.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
		
		Users u = uServ.updateGetParam(req, resp);
	
		List<UserFavoritCate> ucList = uServ.getFavoritCateByUno(u_no);
		String[] favoritCate = req.getParameterValues("cate");
		
		uServ.updateUsers(u_no, u, favoritCate);
		
		resp.sendRedirect("/mypage/profile");
		
		
	}
}
