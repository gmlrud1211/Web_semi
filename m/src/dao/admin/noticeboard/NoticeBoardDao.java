package dao.admin.noticeboard;

import java.util.List;

import dto.NoticeBoard;
import util.Paging;

public interface NoticeBoardDao {

	//공지사항 전체 조회
	public List selectAll();
	

	//공지사항 상세조회 반환

	//공지사항 조회수 증가
	public void updateCount(NoticeBoard nboardview);
	
	//공지사항 상세조회 반환
	public NoticeBoard selectBoardByBoardno(NoticeBoard nboardview);
	
	//공지사항 삭제 반환
	public int delectNboardByNboardno(NoticeBoard nboarddel);
	
	//총 게시글 수 반환
	public int selectCntBoard();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
		

    //공지사항 등록
	public void noticeBoardInsert(NoticeBoard nboardinsert);

	//공지사항 수정
	public void update(NoticeBoard nboardUpdate);
	
	//공지사항 검색 
	public List<NoticeBoard> search(String type, String word);
}
















