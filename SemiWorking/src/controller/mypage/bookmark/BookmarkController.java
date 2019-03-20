
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
import service.mypage.bookmark.BookmarkService;
import service.mypage.bookmark.BookmarkServiceImpl;


@WebServlet("/mypage/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookmarkDao bDao = new BookmarkDaoImpl();
	private BookmarkService bServ = new BookmarkServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = (int)session.getAttribute("u_no"); // u_no 받아오기
		List bmList = bServ.getBookmarkListByUno(u_no); 
		
		session.setAttribute("bmList", bmList);
		
		request.getRequestDispatcher("/view/mypage/bookmark/bookmarkList.jsp").forward(request, response);	

	}
	



}
