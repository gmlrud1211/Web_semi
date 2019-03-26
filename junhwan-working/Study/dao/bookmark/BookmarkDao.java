
package dao.mypage.bookmark;

import java.util.List;

import dto.Bookmark;


public interface BookmarkDao {

	// 사용자별 북마크 조회
	public List selectBookmarkByUno(int u_no);
	
	// 총 북마크 수 반환
	public int selectCntBookmark(int u_no);
	
	// 북마크 삭제
	public void deleteBookmark(int bm_no);
	
	// 북마크 db삽입
	public void insertBookmark(Bookmark bookmark);

	public void deleteBookmark(Bookmark bmark);
}

