package service.mypage.bookmark;

import java.util.List;

import dao.mypage.bookmark.BookmarkDao;
import dao.mypage.bookmark.BookmarkDaoImpl;
import dto.Bookmark;

public class BookmarkServiceImpl implements BookmarkService {

	private BookmarkDao bmDao = new BookmarkDaoImpl();
	
	@Override
	public List getBookmarkListByUno(int u_no) {
		return bmDao.selectByUserno(u_no);
	}

	@Override
	public void deleteBookmark(int bm_no) {
		bmDao.deleteBookmark(bm_no);
	}

	


}
