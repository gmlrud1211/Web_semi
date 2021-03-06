package controller.admin.noticeboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;
import util.Paging;

@WebServlet("/noticeboard/adminlist")
public class NoticeBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeBoardService nboardService = new NoticeBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//현재 페이지 번호 얻기
		int curPage = nboardService.getCurPage(req);
		
		//총 게시글 수 얻기
		int totalCount = nboardService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging);
		
		//게시글목록 MODEL로 추가
		List<NoticeBoard> nboardlist = nboardService.getPagingList(paging);
		req.setAttribute("nboardlist", nboardlist);
		
		//페이징객체 MODEL로 추가
		req.setAttribute("paging", paging);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/noticeboard/list.jsp")
			.forward(req, resp);
		
	}
	
}









