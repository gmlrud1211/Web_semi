package dao.bookmark;

import java.util.List;

import dto.bookmark.Bookmark;
import dto.users.Users;

public interface BookmarkDao {

	// 사용자별 북마크 조회
	public List selectByUserno(int u_no);
	
	// 총 북마크 수 반환
	public int selectCntBookmark();
	
	// 북마크 삭제
	public void deleteBookmark(Bookmark bm);
	
	
}
