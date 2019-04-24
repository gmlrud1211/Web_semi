package service.admin.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.NoticeBoard;
import util.Paging;

public interface NoticeBoardService {

	//요청파라미터 데이터를 객체화하여 반환
	public NoticeBoard getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//공지사항 전체 조회
	public List getList();
	
	//공지사항 검색 조회 
	public List<NoticeBoard> getSearch(String type, String word);
	
	//게시글 상세 조회
	//	조회된 게시글의 조회수도 증가시킨다
	public NoticeBoard view(NoticeBoard nboardview);
	
	// 게시글 삭제 
	public int delete(NoticeBoard nboarddel);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);
	
	//게시글 등록
	public void insert(NoticeBoard nboard);
	
	// 공지사항 수정
	public void update(NoticeBoard nboardUpdate);
	
}

















