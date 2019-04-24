package controller.admin.oneandboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.OneAndBoard;
import service.admin.oneandboard.OneAndBoardService;
import service.admin.oneandboard.OneAndBoardServiceImpl;
import util.Paging;

@WebServlet("/oneandboard/list")
public class OneAndBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OneAndBoardService oboardService = new OneAndBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//현재 페이지 번호 얻기
		int curPage = oboardService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount = oboardService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//게시글목록 MODEL로 추가
		List<OneAndBoard> oboardlist = oboardService.getPagingList(paging);
		req.setAttribute("oboardlist", oboardlist);
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/oneandboard/list.jsp")
			.forward(req, resp);
		
	}
	
}









