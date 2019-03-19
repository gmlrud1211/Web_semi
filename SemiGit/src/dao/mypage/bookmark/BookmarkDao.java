
package dao.mypage.bookmark;

import java.util.List;

import dto.Bookmark;
import util.Paging;

public interface BookmarkDao {

	
	// 총 북마크 수 반환
	public int CntBookmark(int u_no);
	
	// 북마크 삭제
	public void deleteBookmark(int bm_no);
	
	// 페이징된 북마크 리스트 반환
	public List selectBookmarkPagingList(int u_no, Paging paging);
	
	
}

