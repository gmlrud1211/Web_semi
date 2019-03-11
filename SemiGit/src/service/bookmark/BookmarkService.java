package service.bookmark;

import java.util.List;

import dto.bookmark.Bookmark;

public interface BookmarkService {

	public List getBookmarkListByUno(int u_no);
	
	public void deleteBookmark(Bookmark bm);
	
}
