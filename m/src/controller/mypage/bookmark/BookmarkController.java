
package controller.mypage.bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.mypage.bookmark.BookmarkDao;
import dao.mypage.bookmark.BookmarkDaoImpl;
import dto.MyBoard;
import service.mypage.bookmark.BookmarkService;
import service.mypage.bookmark.BookmarkServiceImpl;
import util.Paging;


@WebServlet("/mypage/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookmarkService bServ = new BookmarkServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); // u_no 받아오기

		int curPage = bServ.getCurPage(request);
		int totalCount = bServ.getTotalBookmarkCount(u_no);
						
		Paging paging = new Paging(totalCount, curPage);

		List<MyBoard> bmList = bServ.getBookmarkPagingList(u_no, paging);

		request.setAttribute("bmList", bmList);					
		request.setAttribute("paging", paging);
		
		
		request.getRequestDispatcher("/view/mypage/bookmark/bookmarkList.jsp").forward(request, response);	

	}
	



}
