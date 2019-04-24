package service.admin.oneandboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import dto.OneAndBoard;
import util.Paging;

public interface OneAndBoardService {

	//요청파라미터 데이터를 객체화하여 반환
	public OneAndBoard getParam(HttpServletRequest req, HttpServletResponse resp);
	
	//1대1 전체 조회
	public List getList();
	
	//1대1 상세 조회
    public OneAndBoard view(OneAndBoard oboardview);

	//요청파라미터에서 curPage 반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);


	// 답변 등록 업데이트
	public void update(OneAndBoard oboardupdate);


	//1대1 문의 검색 조회
	public List<OneAndBoard> getSearch(String type, String word);
	
}

















