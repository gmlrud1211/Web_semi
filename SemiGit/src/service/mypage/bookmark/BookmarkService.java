package service.mypage.bookmark;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Bookmark;
import util.Paging;

public interface BookmarkService {

//	public List getBookmarkListByUno(int u_no);
	
	public void deleteBookmark(int bm_no);
	
	public int getCurPage(HttpServletRequest req);
	
	// �� �ۼ� �Խñ� �� ���
	public int getTotalBookmarkCount(int u_no);
	
	// ����ں� �Խñ� ����¡ ����Ʈ ���
	public List getBookmarkPagingList(int u_no, Paging paging);
		
}
