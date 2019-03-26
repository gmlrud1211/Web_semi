package service.mypage.bookmark;

import java.util.List;

import dao.mypage.bookmark.BookmarkDao;
import dao.mypage.bookmark.BookmarkDaoImpl;
import dao.study.DetailStudy;
import dao.study.DetailStudyImpl;
import dto.Bookmark;

public class BookmarkServiceImpl implements BookmarkService {

	private BookmarkDao bmDao = new BookmarkDaoImpl();
	@Override
	public List getBookmarkListByUno(int u_no) {
		return bmDao.selectBookmarkByUno(u_no);
	}

	@Override
	public void deleteBookmark(int bm_no) {
		bmDao.deleteBookmark(bm_no);
	}

	@Override
	public void insertBookmark(Bookmark bookmarks) {
		bmDao.insertBookmark(bookmarks);
		
	}

	@Override
	public void deleteBookmark(Bookmark bmark) {
		bmDao.deleteBookmark(bmark);
		
	}





}
