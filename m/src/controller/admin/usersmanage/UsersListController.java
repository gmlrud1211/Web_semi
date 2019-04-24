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

		//현재 페이지 번호 얻기
		int curPage = usersService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount = usersService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//게시글목록 MODEL로 추가
		List<Users> userslist = usersService.getPagingList(paging);
		req.setAttribute("userslist", userslist);
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/usersmanage/list.jsp")
			.forward(req, resp);
		
	}
	
}









