package service.mypage.bookmark;

import java.util.List;

import dto.Bookmark;

public interface BookmarkService {

	public List getBookmarkListByUno(int u_no);
	
	public void deleteBookmark(int bm_no);
	
}
