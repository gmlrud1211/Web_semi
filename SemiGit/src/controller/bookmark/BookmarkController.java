package controller.bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.bookmark.BookmarkDao;
import dao.bookmark.BookmarkDaoImpl;
import service.bookmark.BookmarkService;
import service.bookmark.BookmarkServiceImpl;


@WebServlet("/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookmarkDao bDao = new BookmarkDaoImpl();
	private BookmarkService bServ = new BookmarkServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int u_no = Integer.parseInt((String)request.getParameter("u_no")); // user no 받아옴
		
		List bmList = bServ.getBookmarkListByUno(u_no); 
		
		session.setAttribute("bmList", bmList);

		
		request.getRequestDispatcher("/view/bookmark/list.jsp").forward(request, response);	
		
	}


}
