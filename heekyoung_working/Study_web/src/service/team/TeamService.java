package service.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface TeamService {

	//curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
		
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	
}
