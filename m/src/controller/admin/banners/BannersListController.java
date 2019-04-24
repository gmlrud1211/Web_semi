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

		//현재 페이지 번호 얻기
		int curPage =  banService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount =  banService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//게시글목록 MODEL로 추가
		List<Banners> bannerslist =  banService.getPagingList(paging);
		req.setAttribute("bannerslist", bannerslist);
		System.out.println(bannerslist);
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/banners/list.jsp")
			.forward(req, resp);
		
	}
	
}









