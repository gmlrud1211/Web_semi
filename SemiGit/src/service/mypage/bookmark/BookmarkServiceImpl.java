package service.mypage.bookmark;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.mypage.bookmark.BookmarkDao;
import dao.mypage.bookmark.BookmarkDaoImpl;
import dto.Bookmark;
import util.Paging;

public class BookmarkServiceImpl implements BookmarkService {

	private BookmarkDao bmDao = new BookmarkDaoImpl();

	@Override
	public void deleteBookmark(int bm_no) {
		bmDao.deleteBookmark(bm_no);
	}

	@Override
	public int getCurPage(HttpServletRequest req) {
		String param = req.getParameter("curPage");
		if(param!=null && !"".equals(param) ) {
	
			int curPage = Integer.parseInt(param);
			return curPage;
		}
	
		return 0;
	}
	
	@Override
	public int getTotalBookmarkCount(int u_no) {
		return bmDao.CntBookmark(u_no);
	}
	
	@Override
	public List getBookmarkPagingList(int u_no, Paging paging) {
		return bmDao.selectBookmarkPagingList(u_no, paging);
	}

	


}
