package service.mypage.bookmark;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bookmark;
import dto.Study;

public interface BookmarkService {

	public List getBookmarkListByUno(int u_no);
	
	public void deleteBookmark(int bm_no);
	
	public void insertBookmark(Bookmark bookmarks);
	
	public void deleteBookmark(Bookmark bmark);
}
